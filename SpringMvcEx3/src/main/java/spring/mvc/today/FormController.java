package spring.mvc.today;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dto.TestDto;

@Controller
public class FormController {
	
	@GetMapping("/data/myform")
	public String form() {
		
		return "form1";
	}
	
	@GetMapping("/data/read1")
	public ModelAndView read1(@RequestParam String name, @RequestParam int age, @RequestParam(value="msg",defaultValue = "기본값넘김") String msg) {
		//액션처리를 여기서 해주면 됨
		//@RequestParam 읽을 값 가져올때 사용(생략 가능)
		
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("name", name);
		mview.addObject("age", age);
		mview.addObject("msg", msg); //form에서 없는 값을 넘긴다면 오류가 남..... 기본값을 넘겨주면 해결
		
		mview.setViewName("process1");
		
		return mview;
		
	}
	
	@PostMapping("/data/read2") //form이 post방식_dto방식으로 넘겨받기
	public ModelAndView read2(@ModelAttribute TestDto dto) {
		
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("dto", dto);
		mview.setViewName("process2");
		
		return mview;
		
	}
	
	@PostMapping("/data/read3") //form이 post방식_map방식으 로 넘겨받기
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		
		ModelAndView mview=new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("price");
		
		String data=sang+"의 가격은"+price+"입니다";
		
		mview.addObject("data", data);
		mview.setViewName("process3");
		
		return mview;
	}
	
	

}
