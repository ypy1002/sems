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

/* 과목명에 상세보기 링크 추가
 * 
 */

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과정 목록</title>"
				
				+ "<style>"
				+ "body { width : 100%; height : 100%; background-color : black;}"
				+ "a { text-decoration : none; color : yellow; font-weight : bold;}"
				+ ".dd:hover { background-color : gray; }"
				+ "div { width : 50%; margin-left : 25%; text-align : center;}"
				+ "th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}"
				+ "td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold;}"
				+ "h1 { text-align : center; color : gray; }"
				+ "table { margin-left : 17%;}"
				+ "</style>"
				+ "</head><body>");
		try {
			
			CourseDao dao = (CourseDao)this.getServletContext()
																							.getAttribute("courseDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<CourseVo> list = dao.list(pageNo, pageSize);
			
			out.println("<div><table>");
			out.println("<h1>과정 목록</h1>");
			out.println("<tr>");
			out.println("<th>No</th><th>Title</th><th>Detail</th><th>Update</th><th>Delete</th>");
			out.println("</tr>");
			
			for (CourseVo course : list) {
				out.println("<tr>");
				out.println("<td>" + course.getCno() + "</td>");
				out.println("<td>" + course.getTitle() + "</td>");
				out.println("<td class='dd'><a href='detail.bit?no=" + course.getCno() + "'>View</a></td>");
				out.println("<td class='dd'><a href='update.bit?no=" + course.getCno() + "'>Update</a></td>");
				out.println("<td class='dd'><a href='delete.bit?no=" + course.getCno() + "'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table><br><br>");
			out.println("<a href='/sems/course/insertForm/form.html'>Insert</a><br><br><a href='/sems/index.html'>Menu</a></div>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}