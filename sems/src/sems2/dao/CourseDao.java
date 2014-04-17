package sems2.dao;


import java.util.List;

import sems2.vo.CourseVo;

public interface CourseDao {
	void insert(CourseVo users) throws Throwable;
	List<CourseVo> list(int pageNo, int pageSize) throws Throwable;
	CourseVo detail(int no) throws Throwable;
	void update(CourseVo users) throws Throwable;
	void delete(int no) throws Throwable;
}
