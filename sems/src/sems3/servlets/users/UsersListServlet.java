package sems3.servlets.users;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		
		try {
			
			UsersDao dao = (UsersDao)this.getServletContext()
																							.getAttribute("usersDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo")); 
			int pageSize = Integer.parseInt(request.getParameter("pageSize")); 
			
			List<UsersVo> list = dao.list(pageNo, pageSize);
			request.setAttribute("list", list);
			RequestDispatcher rd =
					request.getRequestDispatcher("/users/list.jsp");
			rd.forward(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}