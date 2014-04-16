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

@WebServlet("/users/update.bit")
@SuppressWarnings("serial")
public class UsersUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title></head><body>");
		
		try {
			//1) DB에서 과목 상세 정보를 가져온다.
			int no = Integer.parseInt(request.getParameter("no"));
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			UsersVo vo = dao.detail(no);
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>과목 변경폼</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>과목 변경</h1>");
			out.println("<form action='update.bit' method='post'>");
			out.println("번호: <input type='text' name='no' value='"
					+ vo.getUno()
					+ "' readonly><br>");
			out.println("과목명: <input type='text' name='title' value='"
					+ vo.getEmail()
					+ "'><br>");
			out.println("설명: <textarea name='description' rows='10' cols='80'>"
					+ vo.getPassword()
					+ "</textarea><br>");
			out.println("<input type='submit' value='변경'>");
			out.println("<input type='button' value='취소'");
			out.println("				onclick=\"location.href='detail.bit?no="
					+ vo.getUno()
					+ "'\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// CharacterEncodingFilter로 대체함.
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title></head><body>");
		
		try {
			out.println("<h1>과목 변경 결과</h1>");
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			
			UsersVo vo = new UsersVo();
			vo.setUno(Integer.parseInt(request.getParameter("no")));
			vo.setEmail(request.getParameter("title"));
			vo.setPassword(request.getParameter("description"));
			
			dao.update(vo);
			
			out.println("변경 성공!");
			
			response.sendRedirect("detail.bit?no=" + vo.getUno());
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















