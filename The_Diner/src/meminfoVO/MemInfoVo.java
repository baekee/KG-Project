package meminfoVO;

import java.util.Date;

//VO (Value Object) 

public class MemInfoVo {

	private String id;	//varchar2(20)
	private String password;		//varchar2(20)
	private String name;
	private String tel;
	private String email;
	private String knum;
	private String Rnum;
	
	public MemInfoVo(String id, String password, String name, String tel,String email,String knum,String Rnum) {
		//super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.knum = knum;
		this.Rnum = Rnum;
	}
	
	public MemInfoVo() {}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKnum() {
		return knum;
	}
	public void setKnum(String knum) {
		this.knum = knum;
	}
	public String getRnum() {
		return Rnum;
	}
	public void setRnum(String rnum) {
		Rnum = rnum;
	}
	
	
}
