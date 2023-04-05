package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //json전옹 컨트롤러..일반 메서드는 사용 못함
public class JsonToController {
	
	@GetMapping("/list2")
	public List<PhotoDto> list2(){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		//생성과 동시에 list에 담기
		list.add(new PhotoDto("최고심", "최고심.jpg"));
		list.add(new PhotoDto("최고심2", "최고심2.jpg"));
		list.add(new PhotoDto("최고심3", "최고심3.jpg"));
		list.add(new PhotoDto("최보현", "보현이그림.png"));
		list.add(new PhotoDto("네모네모", "스펀지밥.jpg"));
		return list;
	}
	
}
