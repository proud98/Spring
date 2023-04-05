package spring.db.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarConrtoller {
	
	@Autowired
	MyCarDao dao;
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/samsung/list") //carlist를 list라고 함수설정
	public String list(Model model) {
		
		//전체갯수
		int totalCount=dao.getTotalCount();
		
		//전체목록
		List<MyCarDto> list=dao.getAllDatas(); //이건 배열 list
		
		//request에 저장
		model.addAttribute("totalCount", totalCount); //갯수저장
		model.addAttribute("list", list); //배열 리스트저장
		
		return "car/carlist";
	}
	
	@GetMapping("/samsung/writeform")
	public String write() {
		
		return "car/writeform"; //글쓰기 폼으로 이동
	}
	
	//insert 처리
	@PostMapping("/samsung/write")
	public String insert(@ModelAttribute MyCarDto dto) {
		
		dao.insertMyCar(dto);
		return "redirect:list"; //insert 처리 후 목록으로 이동..samsung/list와 같음
		
	}
	
	//수정폼으로 가기 
	@GetMapping("/samsung/updateform")
	public String updateform(@RequestParam String num,Model model) {
		
		//dto 가져오기
		MyCarDto dto=dao.getData(num);
		
		//저장
		model.addAttribute("dto", dto);
		
		return "car/updateform";
	}
	
	//수정action
	@PostMapping("/samsung/update")
	public String update(@ModelAttribute MyCarDto dto) {
		
		dao.updateMyCar(dto);
		return "redirect:list"; //insert 처리 후 목록으로 이동..samsung/list와 같음
		
	}
	
	
	//삭제
	@GetMapping("/samsung/delete")
	public String delete(@ModelAttribute MyCarDto dto) {
		
		dao.deleteMyCar(dto);
		return "redirect:list"; //insert 처리 후 목록으로 이동..samsung/list와 같음
		
	}
	
	
	
	

}
