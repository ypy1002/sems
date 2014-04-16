package sems.servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems.dao.SubjectDao;

@WebServlet("/subject/delete.bit")
@SuppressWarnings("serial")
public class SubjectDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목삭제</title>"
				+ "<style>"
				
				+ "body { background-color : gray;}"
				+ "h1 { text-align : center;} "
				+ "#abox { text-align : center;} "
				+ "#a { text-align : center; text-decoration: none; color : yellow;}"
				
				+ "</style></head><body>");
		
		try{
			out.println("<h1>과목 삭제 결과</h1>");
			
			SubjectDao dao = (SubjectDao) this.getServletContext()
					.getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
      dao.delete(no); 
			
			out.println("<h1>삭제 성공</h1>");

			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		}catch(Throwable e){
			out.println("<h1>오류 발생! 없는 데이터 번호</h1>");
		}
		out.println("</body><div id='abox'><a id = 'a' href='http://192.168.200.77:9998/sems/index.html'>메뉴로</a><br><br>"
				+ "<a id = 'a' href='list.bit?pageNo=1&pageSize=10'>리스트로</a></div></html>");
	}

}
