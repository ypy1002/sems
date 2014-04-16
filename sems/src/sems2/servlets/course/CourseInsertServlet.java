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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//	POST요청의 값에 대해 적용. GET요청의 값은 ?
		//		-	서블릿 컨테이너의 안내에 따라 설정한다.
		//		-	getParameter()를 호출하기 전에 실행해야 한다.
		//		단, 한번이라도 getParameter()를 호출했다면 적용안됨
		
		//형덕스님께서 필터를 잘 만드셨다면 이녀석을 주석처리해도 아무 문제가 없겠지요 관세음보살
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목등록</title>"
				+ "<style>"
				
				+ "body { background-color : gray;}"
				+ "h1 { text-align : center;}"
				
				+ "</style></head><body>");
		
		try{
			out.println("<h1>과정 등록 결과</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("courseDao");
			
			CourseVo courseVo = new CourseVo();
			courseVo.setTitle(request.getParameter("title"));
			courseVo.setDescription(request.getParameter("description"));
			courseVo.setHours(Integer.parseInt(request.getParameter("hours")));
		
			dao.insert(courseVo);
			out.println("<h1>등록 성공</h1>");
			
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		}catch(Throwable e){
			out.println("<h1>오류 발생! 이미 등록된 데이터</h1>");
		}
		out.println("</body></html>");
	}

}
