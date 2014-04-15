package sems2.vo;

//	setter / getter 적용 <= 캡슐화

public class CourseVo {
	private int sno;
	private String title;   
	private String description;

	public int getSno() {
		return sno;
	}
	
	public CourseVo setSno(int sno) {
		this.sno = sno;
		return this;
	}
	
	public String getTitle() {
		return title;
	}
	
	public CourseVo setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getDescription() {
		return description;
	}
	
	public CourseVo setDescription(String description) {
		this.description = description;
		return this;
	}
}

