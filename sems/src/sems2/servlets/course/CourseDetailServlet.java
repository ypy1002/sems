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

/* 목록으로 가기, 삭제하기 링크 추가
 * 
 */

@WebServlet("/course/detail.bit")
@SuppressWarnings("serial")
public class CourseDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과정 상세 정보</title>"
				+ "<style>"
				
				+ "body { width : 100%; height : 100%; background-color : black;}"
				+ "a { text-decoration : none; color : yellow;}"
				+ ".dd:hover { background-color : gray; }"
				+ "div { width : 21%; margin-left : 40%; text-align : center;	}"
				+ "th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}"
				+ "td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold; width : 200px;}"
				+ "textarea { border-radius : 20px;  background-color : brown; font-weight: bold; width : 200px; text-align : center;}"
				+ "h1 { text-align : center; color : gray; }"
				+ "</style>"
				+ "</head><body>");
		try {
			out.println("<h1>과정 상세정보</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("courseDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			CourseVo course = dao.detail(no);
			
			out.println("<div><table>");
			out.println("<tr>");
			out.println("<th>No</th>");
			out.println("<td>" + course.getCno() + "</td>");
			out.println("</tr>");
			
			out.println("<div><table>");
			out.println("<tr>");
			out.println("<th>Title</th>");
			out.println("<td>" + course.getTitle() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Description</th>");
			out.println("<td><textarea rows='5' cols='40'>" + course.getDescription() + "</textarea></td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Hours</th>");
			out.println("<td>"+ course.getHours() + "</td>");
			out.println("</tr>");
			
			out.println("</table><br><br>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>List</a><br><br>");
			out.println("<a href='delete.bit?no=" + course.getCno() + "'>Delete</a><br><br>");
			out.println("<a href='update.bit?no=" + course.getCno() + "'>Update</a></div>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















