package spring.di.ex2;

public class Person {
	
	String schoolName; //setter로 주입 받고
	MyInfo info; //myinfo클래스를 멤버로 가져옴... 생성자로 주입 받고
	
	public Person(MyInfo info) {
		super(); //super는 위에서 가져오기 
		this.info=info;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	//출력
	public void write() {
		
		System.out.println("** 학생정보 출력 **");
		System.out.println("학교명: "+schoolName);
		System.out.println("이름: "+info.name);
		System.out.println("나이: "+info.age);
		System.out.println("주소: "+info.addr);
	}
	
	

}
