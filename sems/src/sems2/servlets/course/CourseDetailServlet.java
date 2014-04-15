package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems2.dao.CourseDao;
import sems2.vo.CourseVo;

@WebServlet("/course/detail.bit")
@SuppressWarnings("serial")

public class CourseDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목상세정보</title></head><body>");
		
		try{
			out.println("<h1>과목 상세정보</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("courseDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
		
			CourseVo course = dao.detail(no);

			out.println("<table border = '1'>");
			out.println("<tr><th>번호</th><td>" + course.getCno() +"</td></tr>");
			out.println("<tr><th>과목명</th><td>" + course.getTitle() +"</td></tr>");
			out.println("<tr><th>교육시간</th><td>" + course.getHours() +"</td></tr>");
			out.println("<tr><th>내용</th><td><textarea rows='5' cols='60'>" + course.getDescription() +"</textarea></td></tr>");
			out.println("</table>");
		}catch(Throwable e){
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
