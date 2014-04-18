package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems2.dao.CourseDao;

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

@WebServlet("/course/delete.bit")
@SuppressWarnings("serial")
public class CourseDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		try {
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("courseDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no);
			
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















