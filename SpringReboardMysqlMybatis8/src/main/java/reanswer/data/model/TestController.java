package reanswer.data.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import reboard.data.model.ReBoardDao;
import reboard.data.model.ReBoardDto;

@Controller
public class TestController {
	
	@Autowired
	ReBoardDao dao;
	
	@GetMapping("/sist/list")
	public @ResponseBody List<ReBoardDto> list(){
		
		return dao.getliList(0, 5);
	}
	
	@GetMapping("/sist/data")
	@ResponseBody
	public ReBoardDto onedata(@RequestParam int num) {
		
		return dao.getData(num);
	}
}
