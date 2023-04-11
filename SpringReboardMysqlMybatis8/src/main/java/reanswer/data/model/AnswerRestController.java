package reanswer.data.model;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerRestController {
	
	@Autowired
	ReanswerDao adao;
	
	@GetMapping("/board/deleteanswer")
	public HashMap<String, Integer> answrDelete(@RequestParam int idx, @RequestParam String pass){
		
		int check=adao.getCheckPassAnswer(idx, pass);
		
		//비번이 일치(1)할 경우
		if(check==1) {
			adao.deleteAnswer(idx);
		}
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		map.put("check", check); //{"check":1}
		
		return map;
		
		
	}
}
