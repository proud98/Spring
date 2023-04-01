package spring.di.ex3;

public class SawonData {
	
	private String sawonname;
	private int pay;
	private String ipsaday;
	
	public SawonData() {
		//디폴트 생성자
	}
	//사원명은 생성자 주입 방법
	public SawonData(String name) {
		sawonname=name;
	}
	
	//급여, 입사일은  setter주입
	public String getSawonname() {
		return sawonname;
	}
	public void setSawonname(String sawonname) {
		this.sawonname = sawonname;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getIpsaday() {
		return ipsaday;
	}
	public void setIpsaday(String ipsaday) {
		this.ipsaday = ipsaday;
	}
	
}
