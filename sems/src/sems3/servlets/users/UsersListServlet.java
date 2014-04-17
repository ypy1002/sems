package sems3.servlets.users;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems3.dao.UsersDao;
import sems3.vo.UsersVo;

/* 과목명에 상세보기 링크 추가
 * 
 */

@WebServlet("/users/list.bit")
@SuppressWarnings("serial")
public class UsersListServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자 목록</title>"
				
				+ "<style>"
				
				+ "body { width : 100%; height : 100%; background-color : black;}"
				+ "a { text-decoration : none; color : yellow; font-weight : bold;}"
				+ ".dd:hover { background-color : gray; }"
				+ "div { width : 50%; margin-left : 24%; text-align : center;}"
				+ "th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}"
				+ "td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold;}"
				+ "h1 { text-align : center; color : gray; }"
				+ "#ds { width : 200px;}"
				
				+ "</style>"
				+ "</head><body>");
		try {
			
			UsersDao dao = (UsersDao)this.getServletContext()
																							.getAttribute("usersDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<UsersVo> list = dao.list(pageNo, pageSize);
			
			out.println("<div><table>");
			out.println("<h1>사용자 목록</h1>");
			out.println("<tr>");
			out.println("<th>No</th><th>Email</th><th>Password</th><th>Name</th><th>Tel</th><th>Detail</th><th>Update</th><th>Delete</th>");
			out.println("</tr>");
			
			for (UsersVo users : list) {
				out.println("<tr>");
				out.println("<td>" + users.getUno() + "</td>");
				out.println("<td>" + users.getEmail() + "</td>");
				out.println("<td>" + users.getPassword() + "</td>");
				out.println("<td>" + users.getName() + "</td>");
				out.println("<td id='ds'>" + users.getTel() + "</td>");
				out.println("<td class='dd'><a href='detail.bit?no=" + users.getUno() + "'>View</a></td>");
				out.println("<td class='dd'><a href='update.bit?no=" + users.getUno() + "'>Update</a></td>");
				out.println("<td class='dd'><a href='delete.bit?no=" + users.getUno() + "'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table><br><br>");
			out.println("<a href='/sems/insertForm/form.html'>Insert</a><br><br><a href='/sems/index.html'>Menu</a></div>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}