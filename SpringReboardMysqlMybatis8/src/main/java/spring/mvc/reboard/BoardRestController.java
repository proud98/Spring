package spring.mvc.reboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reboard.data.model.ReBoardDao;
import reboard.data.model.ReBoardDto;

@RestController
public class BoardRestController {
	
	@Autowired
	ReBoardDao dao;
	
	/*
	@GetMapping("/rest/list1")
	public String restlist(Model model) {
		
		List<ReBoardDto> rlist=dao.selectBoard();
		model.addAttribute("rlist", rlist);
		
		return "list";
	} */
	
	@GetMapping("/rest/list1")
	public List<ReBoardDto> ajaxlist(){
		
		List<ReBoardDto> list=dao.selectTestBoard();
		
		for(ReBoardDto dto:list) {
			
			if(!dto.getPhoto().equals("no")) {
				
				String [] photos=dto.getPhoto().split(",");
				dto.setPhoto(photos[0]); //첫번째 사진으로 미리보기 넣어짐
			}
		}
		
		return list;
	}
	
}
