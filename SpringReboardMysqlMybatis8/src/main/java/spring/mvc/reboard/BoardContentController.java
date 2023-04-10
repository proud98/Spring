package spring.mvc.reboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReBoardDao;
import reboard.data.model.ReBoardDto;

@Controller
public class BoardContentController {
	
	@Autowired
	ReBoardDao dao;
	
	@GetMapping("/board/content")
	public ModelAndView content(@RequestParam int num, @RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		//readcount 받아오기
		dao.updateReadCount(num);
		//dto 받아오기
		ReBoardDto dto=dao.getData(num);
		
		model.addObject("dto", dto); //dto안에는 num도 있움
		model.addObject("currentPage", currentPage);
		
		model.setViewName("content");
		
		return model;
	}

}
