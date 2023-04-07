package sawon.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SawonController {
	
	@Autowired
	SawonDaoInter dao;
	
	@GetMapping("/sawon/list")
	public ModelAndView list(@RequestParam(defaultValue = "name") String title, @RequestParam(required = false) String search) {
		
		ModelAndView model=new ModelAndView();
		
		//전체개수
		int totalCount=dao.getTotalCount();
		
		//title과 search 맞게 넘어오는지 콘솔에 찍어보기
		System.out.println(title+","+search);
		
		//map 담아주기
		Map<String, String> map=new HashMap<String, String>();
		map.put("title", title);
		map.put("search", search);
		//검색 갯수
		int searchCount=dao.searchCount(map);
		
		//전체 회원 리스트
		List<SawonDto> list=dao.getAllDatas(map);
		
		model.setViewName("sawon/sawonlist");
		model.addObject("totalCount", totalCount);
		model.addObject("searchCount", searchCount);
		model.addObject("list", list); //list안에는 map값도 포함 되어 있음
		model.addObject("search",search);
		
		return model;
	}
	
	//사원 작성 폼이 나오게
	@GetMapping("sawon/form")
	public String form() {
		
		return "sawon/addform";
	}
	
	//작성 액션
	@PostMapping("/sawon/insert")
	public String insert(@ModelAttribute SawonDto dto, @RequestParam MultipartFile upload, HttpSession session) {
		//upload는 insert폼에서 input태그 file의 name
		
		String path=session.getServletContext().getRealPath("/WEB-INF/image/");
		System.out.println(path);
		
		String photoname; //dto에 담을 파일 변수 선언
		
		//파일첨부 여부에 따른 photoname 변수 설정
		if(upload.getOriginalFilename().equals("")) {
			photoname="no"; //사진 선택 안했을땐 no 
		}else {
			String fName=upload.getOriginalFilename();
			photoname=fName; //사진선택하면 fName
			
			//업로드
			try {
				
				upload.transferTo(new File(path+"\\"+photoname));
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto의 photo에 업로드한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		//insert
		dao.insertSawon(dto);
				
		return "redirect:list";
		
	}
	
	//수정폼으로 이동
	@GetMapping("/sawon/updateform")
	public String updateform(@RequestParam String num, Model model) {
		
		SawonDto dto=dao.getNum(num);
		
		model.addAttribute("dto",dto);
		
		return "sawon/updateform";
	}
	
	@PostMapping("/sawon/update")
	public String update(@ModelAttribute SawonDto dto, @RequestParam MultipartFile upload, HttpSession session) {
		//upload는 insert폼에서 input태그 file의 name
		
		String path=session.getServletContext().getRealPath("/WEB-INF/image/");
		System.out.println(path);
		
		String photoname=""; //dto에 담을 파일 변수 선언
		
		//파일첨부 여부에 따른 photoname 변수 설정
		if(upload.getOriginalFilename().equals("")) {
			photoname=null; //사진 선택 안했을땐 no 
		}else {
			photoname=upload.getOriginalFilename();
			//photoname=fName; //사진선택하면 fName
			
			//업로드
			try {
				
				upload.transferTo(new File(path+"\\"+photoname));
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto의 photo에 업로드한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		dao.updateSawon(dto);
				
		return "redirect:list";
		
	}
	
	@GetMapping("/sawon/delete")
	public String delete(@ModelAttribute SawonDto dto, HttpSession session) {
		
		dao.delete(dto);
		return "redirect:list";
	}
	
	
	/*
	 * //이미지포함 모든필드 수정
	 * 
	 * @PostMapping("/sawon/update") public String update(@ModelAttribute SawonDto
	 * dto, @RequestParam MultipartFile upload, HttpSession session) {
	 * 
	 * String path=session.getServletContext().getRealPath("/WEB-INF/image/");
	 * System.out.println(path);
	 * 
	 * String photoname=""; //dto에 담을 파일 변수 선언
	 * 
	 * photoname=upload.getOriginalFilename();
	 * 
	 * //업로드 try {
	 * 
	 * upload.transferTo(new File(path+"\\"+photoname));
	 * 
	 * } catch (IllegalStateException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }
	 * 
	 * //dto의 photo에 업로드한 photoname 넣어주기 dto.setPhoto(photoname);
	 * 
	 * //update dao.updateSawon(dto);
	 * 
	 * return "redirect:list";
	 * 
	 * }
	 */
}
