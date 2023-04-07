package spring.mvc.reboard;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReBoardDao;

@Controller
public class BoardWriteController {
	
	@Autowired
	ReBoardDao dao;
	
	//���� ��� ��� �ش�
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		//�Ʒ� 5���� ���� ����� ��쿡�� ����´� (������ ��쿡�� �ȳѾ��)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String revel=map.get("revel");
		
		//������ ���� null, ����� ���� ���ڷ� ����
		System.out.println(currentPage+","+num);
		
		//�Է����� hidden���� �־������
		model.addObject("currentPage", currentPage==null?"1":currentPage);
		model.addObject("num", num==null?"0":num);
		model.addObject("regroup", regroup==null?"0":regroup);
		model.addObject("restep", restep==null?"0":restep);
		model.addObject("revel", revel==null?"0":revel);
		
		model.setViewName("writeform");
		
		return model;
	}
}
