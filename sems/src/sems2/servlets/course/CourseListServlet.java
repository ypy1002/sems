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
		out.println("<html><head><title>과정목록</title>"
				+ "<style>"
				
				+ "body {background-color : gray;}"
				+ "td { background-color : black; color : white; text-align : center; border-radius : 5px;}"
				+ "h1 { text-align : center;}"
				+ "div { width : 400px; margin-left : 39%;}"
				+ "th{ border-radius : 5px; background-color : violet;} "
				+ "#no { width : 50px;}"
				+ "#su { width : 300px;}"
				+ ".td1:hover { background-color : white; color : black;}"
				+ "#abox { text-align : center;}"
				+ "#a { text-align : center; text-decoration: none; color : yellow;}"
				+ "#al { text-decoration: none; color : violet;}"
				
				+ "</style></head><body>");
		
		try{
			out.println("<h1>과정 목록</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("courseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
			List<CourseVo> list = dao.list(pageNo, pageSize);
			out.println("<a href='courseform.html'>새과정</a><br>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>번호</th>");
			out.println("	<th>과정명</th>");
			out.println("</tr>");
			
			for(CourseVo course : list){
				out.println("<tr>");
				out.println("	<td>" + course.getCno() + "</td>");
				out.println("	<td><a href='detail.bit?no="	
				+ course.getCno()	
				+ "'>" 	+ course.getTitle() + "</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");	
		}catch(Throwable e){
			out.println("오류 발생!");
		}
		
		out.println("</body></html>");
	}

}
