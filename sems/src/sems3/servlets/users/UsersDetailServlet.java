package sems3.servlets.users;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		try {
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			UsersVo users = dao.detail(no);
			
		request.setAttribute("users", users);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/users/detail.jsp");
			rd.forward(request, response);
			
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}



