package spring.anno.ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //tiwanManggo에 등록
public class ManggoController {
	
	@Autowired 
	//인터페이스 망고를 구현한 클래스가 필리핀망고 한 개 일때는 자동주입이 되는데 태국망고까지 두개면 오류남 (자동주입 문제 발생 > 정확한 이름을 적어주면 됨)
	//정확한 bean의 이름으로 주입하려면 @Resource(name="정확한이름") >  @Resource(name="tiwanManggo") 이런식으로 하면 됨 근데 tiwanManggo파일 지움 .. 
	Manggo manggo;
	
	public void writeManggo() {
		
		System.out.println("내가 좋아하는 과일은~~");
		manggo.writeManggoName();
	}

}
