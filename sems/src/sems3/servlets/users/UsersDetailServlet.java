package sems3.servlets.users;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems3.dao.UsersDao;
import sems3.vo.UsersVo;

/* 목록으로 가기, 삭제하기 링크 추가
 * 
 */

@WebServlet("/users/detail.bit")
@SuppressWarnings("serial")
public class UsersDetailServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자 상세 정보</title>"
				+ "<style>"
				
				+ "body { width : 100%; height : 100%; background-color : black;}"
				+ "a { text-decoration : none; color : yellow;}"
				+ ".dd:hover { background-color : gray; }"
				+ "div { width : 21%; margin-left : 40%; text-align : center;	}"
				+ "th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}"
				+ "td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold; width : 200px;}"
				+ "h1 { text-align : center; color : gray; }"
				+ "</style>"
				+ "</head><body>");
		try {
			out.println("<h1>사용자 상세정보</h1>");
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			UsersVo users = dao.detail(no);
			
			out.println("<div><table>");
			out.println("<tr>");
			out.println("<th>No</th>");
			out.println("<td>" + users.getUno() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Email</th>");
			out.println("<td>" + users.getEmail() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Password</th>");
			out.println("<td>"+ users.getPassword() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<td>"+ users.getName() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Tel</th>");
			out.println("<td>"+ users.getTel() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Fax</th>");
			out.println("<td>"+ users.getFax() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>PostNo</th>");
			out.println("<td>"+ users.getPostNo() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Addr</th>");
			out.println("<td>"+ users.getAddr() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<th>Photo_Path</th>");
			out.println("<td>"+ users.getPhoto() + "</td>");
			out.println("</tr>");
			
			out.println("</table><br><br>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>List</a><br><br>");
			out.println("<a href='delete.bit?no=" + users.getUno() + "'>Delete</a><br><br>");
			out.println("<a href='update.bit?no=" + users.getUno() + "'>Update</a></div>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















