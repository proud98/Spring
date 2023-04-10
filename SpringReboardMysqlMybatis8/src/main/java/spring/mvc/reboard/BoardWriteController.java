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
public class BoardWriteController {
	
	@Autowired
	ReBoardDao dao;
	
	
	//insert
		@PostMapping("/board/insert")
		public String insert(@ModelAttribute ReBoardDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpSession session, @RequestParam int currentPage){
			
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
			
			//insert
			dao.insertReboardDto(dto);
			
			//글쓰기 후 상세보기로 이동하게 하는 MaxNum 구하기
			int num=dao.getMaxNum();
			
			return "redirect:content?num="+num+"&currentPage="+currentPage;
		}
	
	//새글 답글 모두 해당
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		//아래 5개의 값은 답글일 경우에만 엄어온다 (새글일 경우에는 안넘어옴)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		//새글인 경우는 null, 답글인 경우는 숫자로 나옴
		System.out.println(currentPage+","+num);
		
		//입력폼에 hidden으로 넣어줘야함
		model.addObject("currentPage", currentPage==null?"1":currentPage);
		model.addObject("num", num==null?"0":num);
		model.addObject("regroup", regroup==null?"0":regroup);
		model.addObject("restep", restep==null?"0":restep);
		model.addObject("relevel", relevel==null?"0":relevel);
		
		model.setViewName("writeform");
		
		return model;
	}
}
