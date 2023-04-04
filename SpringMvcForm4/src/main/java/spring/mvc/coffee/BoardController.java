package spring.mvc.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/board") 이거 해주면 굳이 안써도 다 공통적으로 붙여줌 
public class BoardController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/board/form1")
	public String form1() {
		
		return "board/writeform";
	}
	
	@PostMapping("/board/process1")
	public ModelAndView process1(@RequestParam String name, @RequestParam String date, @RequestParam String gender, 
			@RequestParam(required = false) String msg, @RequestParam(defaultValue = "1") int currentPage) {
			//없는 항목 추가할때 required = false 주면 된다 (required은 true가 기본값)  > 값이 없어도 빈칸으로 두고 에러는 안나게 하겠음
			//아니면 defaultValued로 초기값 설정해줘도 됨 
		
		ModelAndView mview=new ModelAndView();
		mview.addObject("name", name);
		mview.addObject("date", date);
		mview.addObject("gender", gender);
		mview.addObject("msg", msg);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("board/result");
		
		return mview;
	}
	
	@GetMapping("/board/result2")
	public String result2(Model model) {
		
		model.addAttribute("myimg1", "../image/최고심.jpg");
		model.addAttribute("title", "최고심사진");
		
		return "board/result2";
	}
		
}
