package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems2.dao.CourseDao;
import sems2.vo.CourseVo;

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목목록</title></head><body>");
		
		try{
			out.println("<h1>과목 목록</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("courseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
			List<CourseVo> list = dao.list(pageNo, pageSize);

			out.println("<table border = '1'><tr><th>과목명</th><th>번호</th></tr>");
			
			for(CourseVo course : list){
				out.println("<tr><td>" + course.getCno() + "</td><td>" + course.getTitle() +"</td><tr>");
			}
		}catch(Throwable e){
			out.println("오류 발생!");
		}
		
		out.println("</table></body></html>");
	}

}
