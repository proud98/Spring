package spring.mvc.coffee;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.ShopDto;

@Controller
public class ShopController {
	
	@GetMapping("/shop/list")
	public String list() {
		
		return "shop/list";
	}
	
	@GetMapping("/shop/form2")
	public String shop() {
		
		return "shop/shopform";
	}
	
	@PostMapping("/shop/process2")
	public String process2(@ModelAttribute ShopDto dto,Model model) {
		
		model.addAttribute("dto", dto);
		
		return "shop/shopresult";
	}
	
	@GetMapping("/shop/form3")
	public String shop2() {
		return "shop/mapform";
	}
	
	@PostMapping("/shop/process3")
	public ModelAndView process3(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("name", map.get("name"));
		model.addObject("java", map.get("java"));
		model.addObject("oracle", map.get("oracle"));
		model.addObject("spring", map.get("spring"));
		
		model.setViewName("shop/mapresult");
		
		return model;
	}

}
