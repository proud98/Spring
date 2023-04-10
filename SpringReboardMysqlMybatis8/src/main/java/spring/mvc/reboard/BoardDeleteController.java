package spring.mvc.reboard;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReBoardDao;


@Controller
public class BoardDeleteController {
	
	@Autowired
	ReBoardDao dao;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView dpassform(@RequestParam int num, @RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("deletepassform");
		return model;
	}
	
	//삭제
	@PostMapping("/board/delete")
	public String delete(@RequestParam int num, @RequestParam int pass, @RequestParam int currentPage, HttpSession session) {
		
		//비번 맞는지 채크
		int check=dao.getCheckPass(num, pass);
		//틀렸으면
		if(check==0) {
			return "passfail"; //로 보내기
		}else { //맞으면
			
			//photo폴더의 사진지우기
			String photo=dao.getData(num).getPhoto();
			if(!photo.equals("no")) {
				//,로 분리
				String []fName=photo.split(",");
				//싷제업로드 경로
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName) {
					File file=new File(path+"\\"+f);
					file.delete();
				}
			}
			//db삭제
			dao.deleteReboard(num);
			
			return "redirect:list?currentPage="+currentPage; //currentPage까지 같이 넘기기
		}
		
		
	}
	

}
