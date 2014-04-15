package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems2.dao.CourseDao;
import sems2.vo.CourseVo;

@WebServlet("/course/insert.bit")
@SuppressWarnings("serial")
public class CourseInsertServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//	POST요청의 값에 대해 적용. GET요청의 값은 ?
		//		-	서블릿 컨테이너의 안내에 따라 설정한다.
		//		-	getParameter()를 호출하기 전에 실행해야 한다.
		//		단, 한번이라도 getParameter()를 호출했다면 적용안됨
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목등록</title></head><body>");
		
		try{
			out.println("<h1>과목 등록 결과</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("subjectDao");
			
			CourseVo subjectVo = new CourseVo();
			subjectVo.setTitle(request.getParameter("title"));
			subjectVo.setDescription(request.getParameter("description"));
		
			dao.insert(subjectVo);
			out.println("등록 성공");

		}catch(Throwable e){
			out.println("오류 발생!");
		}
		out.println("</body></html>");
	}

}
