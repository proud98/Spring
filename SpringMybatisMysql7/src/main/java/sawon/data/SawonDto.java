package sawon.data;

import java.sql.Timestamp;

public class SawonDto {
	
	private String num;
	private String name;
	private String driver;
	private String buseo;
	private String photo;
	private Timestamp ipsaday;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Timestamp getIpsaday() {
		return ipsaday;
	}
	public void setIpsaday(Timestamp ipsaday) {
		this.ipsaday = ipsaday;
	}
	
	
	

}
