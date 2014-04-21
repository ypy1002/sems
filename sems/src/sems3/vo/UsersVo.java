package sems3.vo;


//	setter / getter 적용 <= 캡슐화

public class UsersVo {
	private int uno;
	private String email;   
	private String password;
	private String name;
	private String tel;
	private String fax;
	private String postNo;
	private String addr;
	private String photo;
	
	public int getUno() {
		return uno;
	}
	public UsersVo setUno(int uno) {
		this.uno = uno;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public UsersVo setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UsersVo setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getName() {
		return name;
	}
	public UsersVo setName(String name) {
		this.name = name;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public UsersVo setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getFax() {
		return fax;
	}
	public UsersVo setFax(String fax) {
		this.fax = fax;
		return this;
	}
	public String getPostNo() {
		return postNo;
	}
	public UsersVo setPostNo(String postNo) {
		this.postNo = postNo;
		return this;
	}
	public String getAddr() {
		return addr;
	}
	public UsersVo setAddr(String addr) {
		this.addr = addr;
		return this;
	}
	public String getPhoto() {
		return photo;
	}
	public UsersVo setPhoto(String photo) {
		this.photo = photo;
		return this;
	}
	
	
}
