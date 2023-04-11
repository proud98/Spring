package reanswer.data.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AnswerController {
	
	@Autowired
	ReanswerDao adao;
	
	/*
	@GetMapping("/board/answer")
	public ModelAndView answerlist(@RequestParam int num,@RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		int totalAnswerCount=dao.getTotalAnswerCount();
		
		model.addObject("totalAnswerCount",totalAnswerCount);
		
		model.setViewName("redirect:content?num="+num+"&currentPage="+currentPage);
		
		return model;
	}
	
	@GetMapping("/board/answer")
	public String answerlist(Model model,@RequestParam int num, @RequestParam int currentPage) {
		
		int totalAnswerCount=adao.getTotalAnswerCount();
		
		model.addAttribute("totalAnswerCount", totalAnswerCount);
		
		return "redirect:content?num="+num+"&currentPage="+currentPage;
		
		
	} */
	
	@PostMapping("/board/ainsert")
	public String insert(@ModelAttribute ReanswerDto dto, @RequestParam int num,@RequestParam int currentPage) {
		
		adao.insertReanswer(dto);
		
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
}
