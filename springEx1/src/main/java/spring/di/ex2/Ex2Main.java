package spring.di.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//xml등록
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext2.xml");
		
		//myinfo 생성
		MyInfo my=(MyInfo)context.getBean("my");
		
		//값  확인
		System.out.println(my.toString());
		System.out.println(my); //my로만 가져와도 됨
		
		//person생성
		Person p=(Person)context.getBean("person");
		p.write();

	}

}
