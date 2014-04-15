package sems.servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@WebServlet("/subject/detail.bit")
@SuppressWarnings("serial")

public class SubjectDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목상세정보</title></head><body>");
		
		try{
			out.println("<h1>과목 상세정보</h1>");
			
			SubjectDao dao = (SubjectDao) this.getServletContext().getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
		
			SubjectVo subject = dao.detail(no);

			out.println("<table border = '1'>");
			out.println("<tr><th>번호</th><td>" + subject.getNo() +"</td></tr>");
			out.println("<tr><th>과목명</th><td>" + subject.getTitle() +"</td></tr>");
			out.println("<tr><th>내용</th><td><textarea rows='5' cols='60'>" + subject.getDescription() +"</textarea></td></tr>");
			out.println("</table>");
		}catch(Throwable e){
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
