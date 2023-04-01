package spring.anno.ex6;

import org.springframework.stereotype.Component;

@Component("pmanggo") //pmanggo라고 bean에 주입
public class PhilipinManggo implements Manggo { //망고인터페이스를 구현 할 클래스 

	@Override
	public void writeManggoName() {
		// TODO Auto-generated method stub
		
		System.out.println("필리핀 망고");
	}

}
