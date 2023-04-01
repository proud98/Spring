package spring.mvc.today;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodayController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/happy")
	public String one() {
		
		return "happy";
	}
	
	@GetMapping("/hello")
	public String two(Model model) {
		
		model.addAttribute("msg", "Èûµé´ç....");
				
		return "hello";
	}
	
	@GetMapping("/nice/hi")
	public String three(Model model) {
		
		model.addAttribute("name", "ÇÏ¶û");
		model.addAttribute("addr", "¼º³²");
		return "nice";
	}

}
