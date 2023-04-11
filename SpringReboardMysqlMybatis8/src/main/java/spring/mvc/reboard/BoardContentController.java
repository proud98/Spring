package spring.mvc.reboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reanswer.data.model.ReanswerDao;
import reanswer.data.model.ReanswerDto;
import reboard.data.model.ReBoardDao;
import reboard.data.model.ReBoardDto;

@Controller
public class BoardContentController {
	
	@Autowired
	ReBoardDao dao;
	
	@Autowired
	ReanswerDao adao;
	
	@GetMapping("/board/content")
	public ModelAndView content(@RequestParam int num, @RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		//readcount 받아오기
		dao.updateReadCount(num);
		//dto 받아오기
		ReBoardDto dto=dao.getData(num);
		
		model.addObject("dto", dto); //dto안에는 num도 있움
		model.addObject("currentPage", currentPage);
		
		//num에 해당하는 댓글 db에서 가져와서 보내주기
		List<ReanswerDto> alist=adao.getAnswerList(num);
		
		model.addObject("acount", alist.size()); //alist에 대한 사이즈 구하면 개수를 알 수 있음 댓굴아 았을 때만 보낼 것 
		model.addObject("alist", alist); //댓글목록
		
		model.setViewName("content");
		
		return model;
	}
	
	

}
