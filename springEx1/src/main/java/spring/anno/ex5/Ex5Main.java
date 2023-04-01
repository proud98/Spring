package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {
	
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext.xml");
		
		MySqlController cont=(MySqlController)app.getBean("mysqlcont");
		
		cont.insert("하하");
		cont.delete("2");
		cont.select("조회ㄹㄹ");
	}
}
