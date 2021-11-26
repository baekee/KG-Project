package chat_model;

import java.util.Date;

public class ChatVO {

	private int num;
	private String ipno;
	private int portno;
	private String nickname;
	private String name;
	private Date mem_date;
	
	
	public ChatVO() {
		
	}
	
	public ChatVO(int num, String ip_no, int port_no, String nickname, String name, Date mem_date) {
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getIpno() {
		return ipno;
	}

	public void setIpno(String ipno) {
		this.ipno = ipno;
	}

	public int getPortno() {
		return portno;
	}

	public void setPortno(int portno) {
		this.portno = portno;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMem_date() {
		return mem_date;
	}

	public void setMem_date(Date mem_date) {
		this.mem_date = mem_date;
	}

	
	
}
