package spring.mvc.reboard;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReBoardDao;

@Controller
public class BoardWriteController {
	
	@Autowired
	ReBoardDao dao;
	
	//새글 답글 모두 해당
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		//아래 5개의 값은 답글일 경우에만 엄어온다 (새글일 경우에는 안넘어옴)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String revel=map.get("revel");
		
		//새글인 경우는 null, 답글인 경우는 숫자로 나옴
		System.out.println(currentPage+","+num);
		
		//입력폼에 hidden으로 넣어줘야함
		model.addObject("currentPage", currentPage==null?"1":currentPage);
		model.addObject("num", num==null?"0":num);
		model.addObject("regroup", regroup==null?"0":regroup);
		model.addObject("restep", restep==null?"0":restep);
		model.addObject("revel", revel==null?"0":revel);
		
		model.setViewName("writeform");
		
		return model;
	}
}
