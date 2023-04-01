package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext app=new ClassPathXmlApplicationContext("appContext3.xml");
		
		//sawon생성
		Sawon sawon=app.getBean("saw", Sawon.class);
		
		sawon.writeSawon(); //sawon으로 부터 writeSawon호출

	}

}
