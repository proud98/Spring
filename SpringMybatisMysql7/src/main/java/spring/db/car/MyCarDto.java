package spring.db.car;

public class MyCarDto {
	
	private String num;
	private String carname;
	private String carcolor;
	private String carguip;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCarcolor() {
		return carcolor;
	}
	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}
	public String getCarguip() {
		return carguip;
	}
	public void setCarguip(String carguip) {
		this.carguip = carguip;
	}
	public int getCarprice() {
		return carprice;
	}
	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}
	private int carprice;
}
