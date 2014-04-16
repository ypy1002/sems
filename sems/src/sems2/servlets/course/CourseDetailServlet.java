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

@WebServlet("/course/detail.bit")
@SuppressWarnings("serial")

public class CourseDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목상세정보</title>"
				+ "<style>"
				
				+ "body{background-color : gray;}"
				+ "td { background-color : black; color : white; text-align : center; border-radius : 5px;}"
				+ "h1 { text-align : center;}"
				+ "div { width : 600px; margin-left : 31%;}"
				+ "th{ border-radius : 5px; background-color : violet;} "
				+ "#no { width : 100px;}"
				+ "#su { width : 300px;}"
				+ "td:hover { background-color : white; color : black;}"
				+ "textarea { background-color : brown; color : white; border-radius : 10px;}"
				
				+ "</style></head><body>");
		
		try{
			out.println("<h1>과정 상세정보</h1>");
			
			CourseDao dao = (CourseDao) this.getServletContext().getAttribute("courseDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
		
			CourseVo course = dao.detail(no);

			out.println("<div><table>");
			out.println("<tr><th id='no'>번호</th><td>" + course.getCno() +"</td></tr>");
			out.println("<tr><th>과정명</th><td>" + course.getTitle() +"</td></tr>");
			out.println("<tr><th>교육시간</th><td>" + course.getHours() +"</td></tr>");
			out.println("<tr><th>내용</th><td><textarea rows='5' cols='60'>" + course.getDescription() +"</textarea></td></tr>");
			out.println("</table></div>");
			
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a> ");
			out.println("<a href='delete.bit?no="
					+ course.getCno()
					+ "'>삭제</a> ");
			out.println("<a href='update.bit?no="
					+ course.getCno()
					+ "'>변경</a><br>");
		}catch(Throwable e){
			out.println("<h1>오류 발생! 등록되지 않은 데이터 번호! </h1>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
