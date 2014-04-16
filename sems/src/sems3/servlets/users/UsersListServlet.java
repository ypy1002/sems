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
		out.println("<html><head><title>과목목록</title></head><body>");
		try {
			out.println("<h1>과목 목록</h1>");
			
			UsersDao dao = (UsersDao)this.getServletContext()
																							.getAttribute("usersDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<UsersVo> list = dao.list(pageNo, pageSize);
			
			//out.println("<a href='/sems/insertForm/form.html'>새과목</a><br>");
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>No</th><th>Email</th><th>Password</th><th>Name</th><th>Tel</th><th>Detail</th><th>Delete</th>");
			out.println("</tr>");
			
			for (UsersVo users : list) {
				out.println("<tr>");
				out.println("<td>" + users.getUno() + "</td>");
				out.println("<td>" + users.getEmail() + "</td>");
				out.println("<td>" + users.getPassword() + "</td>");
				out.println("<td>" + users.getName() + "</td>");
				out.println("<td>" + users.getTel() + "</td>");
				out.println("<td><a href='detail.bit?no=" + users.getUno() + "'>View</a></td>");
				out.println("<td><a href='delete.bit?no=" + users.getUno() + "'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















