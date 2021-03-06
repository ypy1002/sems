package sems3.servlets.users;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems3.dao.UsersDao;

/* Refresh
 * - 일정시간 후 서버에 지정된 URL을 요청하게 만듦
 * - 1) 응답 헤더에 리프래시 정보 심기
 * - 2) HTML 헤더에 리프래시 정보 심기 
 * 
 * Redirect
 * - 클라이언트에게 다시 요청할 주소를 알려줌.
 * - 경과 시간 지정 불가!
 * - 콘텐츠를 보내지 않는다.
 */

@WebServlet("/users/delete.bit")
@SuppressWarnings("serial")
public class UsersDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// 1) 응답 헤더에 Refresh 명령어 심기 
		//response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		
		// 2) 응답 내용에 Refresh 명령어 심기
		//out.println("<meta http-equiv='Refresh'"
		//		+ " content='1;url=list.bit?pageNo=1&pageSize=10'>");
		
		try {
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			
			int uno = Integer.parseInt(request.getParameter("uno"));
			
			dao.delete(uno);
			
			// 3) Redirect 처리
			// - 콘텐츠를 출력하지 않기 때문에 => 이전에 출력한 내용은 취소된다.
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















