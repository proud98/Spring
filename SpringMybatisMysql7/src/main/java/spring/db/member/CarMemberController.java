package spring.db.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarMemberController {
	
	@Autowired
	CarMemberDao dao;
	
	@GetMapping("/member/list")
	public String membertlist(Model model) {
		
		int totalCount=dao.getTotalCount();
		
		List<CarMemberDto> mlist=dao.getAllDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("mlist", mlist);
		
		return "carmember/memberlist";
	}
	
	@GetMapping("/member/writeform")
	public String write() {
		
		return "carmember/writeform"; //글쓰기 폼으로 이동
	}
	
	//insert
	@PostMapping("/member/write")
	public String insert(@ModelAttribute CarMemberDto dto) {
		
		dao.insertMember(dto);	
		
		return "redirect:list";
	}
	
	//수정폼으로 이동
	@GetMapping("/member/updateform")
	public String updateform(@RequestParam String num, Model model) {
		
		CarMemberDto dto=dao.getNum(num);
		
		model.addAttribute("dto", dto);
		
		return "carmember/updateform";
		
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute CarMemberDto dto) {
		
		dao.updateMember(dto);
		return "redirect:list";
		
	}
	
	//삭제
	@GetMapping("/member/delete")
	public String delete(@ModelAttribute CarMemberDto dto) {
		
		dao.deleteMember(dto);
		return "redirect:list";
	}
	

}
