package spring.mvc.friday;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //bean에 등록
public class HelloController {
	
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	@GetMapping("/") //form.xml파일에서 수정해줘서 이렇게 간단하게 사용 가능 
	public String home(Model model) {
		//Model 인터페이스는 request에 데이터를 저장함 
		
		//서블릿에서 코딩했던 request.setAttribute와 같음
		model.addAttribute("msg", "HelloController로부터 포워드됨");
		model.addAttribute("today", new Date());
		return "home";
		
	}
	
	@GetMapping("/apple/list") //list뒤에 .do .nhn무엇을 붙이던간에  다 호출됨(매핑주소에 확장자가 있으면 딱 그 확장자만 호출)
	public String hello1(Model model) {
		
		model.addAttribute("name", "주하랑"); //name에 주하랑을 저장 
		model.addAttribute("addr", "서울시 강남구"); //addr에 서울시 강남구 저장
		return "result1"; // WEB-INF/day0331/result1.jsp로 이동
		
	}
	
	@GetMapping("banana/insert") 
	public ModelAndView one() {
		//ModelAndView는 request에 저장하기 위한 Model과 포워드하기 위한 View를 합친 것임 (클래스)
		//클래스이기에 반드시 생성을 해줘여함 
		ModelAndView mview=new ModelAndView();
		
		//일단 request에 저장하기 
		mview.addObject("Java", 88);
		mview.addObject("Spring", 100);
		
		//그리고 포워드하기 위한 view 만들기
		mview.setViewName("result2");
				
		return mview; //리턴값은 생성한 변수명 mview
		
	}
	
	@GetMapping("orange/delete")
	public String two(Model model,HttpSession session) {
	
		//request에 저장
		model.addAttribute("name", "하랑");
		
		//session에 저장
		session.setAttribute("myid", "admin");
		
		return "result3";
		
	}
	
	@GetMapping("shop/detail")
	public String three() {
		
		return "result4";
	}
	
	@GetMapping("/board/add/data")
	
	public String four() {
		
		return "result5";
	}
                                                                                                                                                                                                                   
}
