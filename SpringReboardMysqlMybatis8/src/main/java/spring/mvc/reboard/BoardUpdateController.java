package spring.mvc.reboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import reboard.data.model.ReBoardDao;
import reboard.data.model.ReBoardDto;

@Controller
public class BoardUpdateController {
	
	@Autowired
	ReBoardDao dao;
	
	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(@RequestParam int num, @RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("updatepassform");
		return model;
	}
	
	@PostMapping("/board/updatepass")
	public ModelAndView upass(@RequestParam int num,@RequestParam int pass,@RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		//비번이 맞으면 수정폼 틀리면 paafail
		int check=dao.getCheckPass(num, pass);
		
		//비번이 맞으면
		if(check==1) {
			//num에 해당하는 dto 얻기
			ReBoardDto dto=dao.getData(num);
			
			model.addObject("dto", dto);
			model.addObject("currentPage", currentPage);
			model.setViewName("updateform"); //수정폼으로 포워드
		}else {
			//0일 경우(틀린경우)
			model.setViewName("passfail"); //실패로 포워드
		}
		return model;
		
	}
	
		@PostMapping("/board/update")
		public String update(@ModelAttribute ReBoardDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpSession session, @RequestParam String currentPage){
			
			//업로드 할 실제경로
			String path=session.getServletContext().getRealPath("/WEB-INF/photo/");
			
			//파일명에 날짜 붙여주기
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHss");
			System.out.println(path);
			
			String photo="";
			
			//사진 선택 안하면 'no' 로 들어가게하고 했을 경우는 ','로 나오게
			//get(0)은 첫번째 사진이란 뜻
			if(upload.get(0).getOriginalFilename().equals("")) {
				photo="no";
			}else {
				for(MultipartFile f:upload) {
					String fName="p_"+sdf.format(new Date())+f.getOriginalFilename();
					photo+=fName+",";
					
					//업로드
					try {
						f.transferTo(new File(path+"\\"+fName));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//photo에서 마지막 컴마제거
				photo=photo.substring(0, photo.length()-1);
			}
			
			//dto에 photo 넣어주기
			dto.setPhoto(photo);
			
			//update
			dao.updateReboard(dto);
			
			return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
		}
	
	
	
	
}
