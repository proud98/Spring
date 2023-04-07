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
	
	//����¡ó��, ��� ����Ʈ
	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		//�� ����
		int totalCount=dao.getTotalCount();
		
		int totalPage; 
		int startPage; 
		int endPage; 
		int start; 
		int perPage=5; 
		int perBlock=5; 
		     
		//�� ������ ����
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		
		//�� ���� ���� ������ 
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		    
		if(endPage>totalPage)
		   endPage=totalPage;
	    
	    //�� ���������� �ҷ� �� ���۹�ȣ
	    start=(currentPage-1)*perPage; 
	    
	    List<ReBoardDto> list=dao.getliList(start, perPage);
	    
	    int no=totalCount-(currentPage-1)*perPage;
	    
	    //��¿� �ʿ��� ������ model�� ����
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
		
		//���ε� �� �������
		String path=session.getServletContext().getRealPath("/WEB-INF/photo/");
		
		//���ϸ� ��¥ �ٿ��ֱ�
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHss");
		System.out.println(path);
		
		String photo="";
		
		//���� ���� ���ϸ� 'no' �� �����ϰ� ���� ���� ','�� ������
		//get(0)�� ù��° �����̶� ��
		if(upload.get(0).getOriginalFilename().equals("")) {
			photo="no";
		}else {
			for(MultipartFile f:upload) {
				String fName="p_"+sdf.format(new Date())+f.getOriginalFilename();
				photo+=fName+",";
				
				//���ε�
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
			
			//photo���� ������ �ĸ�����
			photo=photo.substring(0, photo.length()-1);
		}
		
		//dto�� photo �־��ֱ�
		dto.setPhoto(photo);
		
		//insert
		dao.insertReboardDto(dto);
		
		return "redirect:list";
	}
	

}
