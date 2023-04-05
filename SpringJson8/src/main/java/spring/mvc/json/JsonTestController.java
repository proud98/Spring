package spring.mvc.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {
	
	@GetMapping("/list1") //json 전용으로 쓰일 매핑주소...list1이라고 걍 내 맘대로 적어줌 ajax에서 url로 활용 할 것
	@ResponseBody //json처리 후 브라우저로 출력... @Controller(일반)일 때 추가해주기
	public Map<String, String> list1(){
		//Map으로 key와 valuㄷ 값 넣기 key는 무조건 String일것.. value에는 int나 string 등등 다양하게 들어갈땐 object
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "하랑");
		map.put("hp", "010-2222-3333");
		map.put("addr", "서울시 강남구");
		
		return map;
	}
}
