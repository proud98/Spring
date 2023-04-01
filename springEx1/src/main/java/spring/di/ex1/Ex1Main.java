package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("기존의 자바 방식으로 호출");
		MessageInter m1=new Message1();
		m1.sayHello("영희");
		
		MessageInter m2=new Message2();
		m2.sayHello("하랑");
		
		System.out.println("스프링 방식으로 객체생성 후 호출");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext1.xml"); //bean을 등록한 곳
		
		MessageInter m3=(Message1)context.getBean("mesBean1"); //bean의 id
		m3.sayHello("마이클");
		
		MessageInter m4=context.getBean("mesBean2",Message2.class); //방법2
		m4.sayHello("하하하");

	}

}
