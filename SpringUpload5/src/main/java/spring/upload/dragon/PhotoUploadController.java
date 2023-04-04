package spring.upload.dragon;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class PhotoUploadController {
	
	@GetMapping("/uploadform1")
	public String form1() {
		
		return "board/uploadform1";
	}
	
	@GetMapping("/uploadform2")
	public String form2() {
		
		return "board/uploadform2";
	}
	
	@PostMapping("/upload1")
	public ModelAndView read1(@RequestParam String title, 
			@RequestParam MultipartFile photo, HttpServletRequest request) {
			//파일 가져올때 MultipartFile...! HttpServletRequest 안에는 realPath가 있음
		ModelAndView model=new ModelAndView();
		
		//업로드 실제 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image"); //""안에는 실제경로 넣기
		
		//파일명 구하기 (파일명은 MultipartFile로 구해야함)
		String fileName=photo.getOriginalFilename(); //업로드한 파일명
		
		//현재날짜와 시간을 이용해서 파일명으로 저장해보기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyMMddHHmmss");
		
		//이미지 첨부여부에 대한 조건..이미지 첨부되면 날짜_파일명 으로 저장되게하기
		if(!fileName.equals("")) {
			
			fileName="photo_"+sdf.format(new Date())+"_"+fileName;
			
			//실제경로인 path에 업로드(transferTo 메서드 사용)
			try {				
				photo.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			fileName="no"; //이미지 첨부 안 한 경우 
		}
		
		model.addObject("title", title);
		model.addObject("fileName", fileName);
		model.addObject("path", path);
		
		model.setViewName("board/uploadresult1");
		
		
		return model;
	}
	
	
	@PostMapping("/upload2")
	public ModelAndView read2(@RequestParam String title, 
			@RequestParam ArrayList<MultipartFile> photo, HttpServletRequest request) {
			//여러개 가져올땐 ArrayList<MultipartFile> 배열에 담아서 사용
		
		ModelAndView model=new ModelAndView();
		
		//업로드 실제 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image"); //""안에는 실제경로 넣기
		
		//현재 날짜와 시간 이용해서 파일명 저장하기 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		//배열생성
		ArrayList<String> files=new ArrayList<String>();
		
		//파일명 담기는 반복문(for:each) 사용 MultipartFile로 받은 포토를 하나하나 담아줌
		for(MultipartFile f:photo) {
			String fileName="p_"+sdf.format(new Date())+"_"+f.getOriginalFilename();
			files.add(fileName);
			
			//업로드
			try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addObject("title", title);
		model.addObject("path", path);
		model.addObject("files", files);
		
		model.setViewName("board/uploadresult2");
		
		
		return model;
	}

	

}
