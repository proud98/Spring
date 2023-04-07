package spring.mvc.reboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class BoardListController {
	
	@Autowired
	ReBoardDao dao;
	
	@GetMapping("/")
	public String start() {
		return "redirect:board/list";
	}
	
	//페이징처리, 답글 리스트
	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		//총 개수
		int totalCount=dao.getTotalCount();
		
		int totalPage; 
		int startPage; 
		int endPage; 
		int start; 
		int perPage=5; 
		int perBlock=5; 
		     
		//총 페이지 갯수
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		
		//각 블럭의 시작 페이지 
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		    
		if(endPage>totalPage)
		   endPage=totalPage;
	    
	    //각 페이지에서 불러 올 시작번호
	    start=(currentPage-1)*perPage; 
	    
	    List<ReBoardDto> list=dao.getliList(start, perPage);
	    
	    int no=totalCount-(currentPage-1)*perPage;
	    
	    //출력에 필요한 변수를 model에 저장
	    model.addObject("totalCount", totalCount);
	    model.addObject("list", list);
	    model.addObject("totalPage", totalPage);
	    model.addObject("startPage", startPage);
	    model.addObject("endPage", endPage);
	    model.addObject("perBlock", perBlock);
	    model.addObject("currentPage", currentPage);
	    model.addObject("no", no);
		
		model.setViewName("boardlist");
		
		return model;
	}
	
	//insert
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute ReBoardDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpSession session){
		
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
		
		return "redirect:list";
	}
	

}
