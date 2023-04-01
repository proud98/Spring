package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext.xml");
		
		Manggo manggo=(PhilipinManggo)app.getBean("pmanggo");
		manggo.writeManggoName();
		
		//Manggo mang=(TiwanManggo).app.getBean("tiwanManggo"); > 타이완망고를 뽑으려면 일케 하면 됨
		
		ManggoController mcon=(ManggoController)app.getBean("manggoController");
		mcon.writeManggo();

	}

}
