package sems2.vo;

//	setter / getter 적용 <= 캡슐화

public class CourseVo {
	private int cno;
	private String title;   
	private String description;
	private int hours;
	
	

	public int getHours() {
		return hours;
	}

	public CourseVo setHours(int hours) {
		this.hours = hours;
		return this;
	}

	public int getCno() {
		return cno;
	}
	
	public CourseVo setCno(int cno) {
		this.cno = cno;
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

