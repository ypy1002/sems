package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		try {
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("courseDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			CourseVo course = dao.detail(no);
			
			request.setAttribute("course", course);
			
			RequestDispatcher rd = request.getRequestDispatcher("/course/jsp/detail.jsp");
			rd.forward(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















