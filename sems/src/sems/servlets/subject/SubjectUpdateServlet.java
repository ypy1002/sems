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

@WebServlet("/subject/update.bit")
@SuppressWarnings("serial")
public class SubjectUpdateServlet extends HttpServlet {
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
			SubjectDao dao = (SubjectDao)this.getServletContext()
					.getAttribute("subjectDao");
			SubjectVo vo = dao.detail(no);
			
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
					+ vo.getNo()
					+ "' readonly><br>");
			out.println("과목명: <input type='text' name='title' value='"
					+ vo.getTitle()
					+ "'><br>");
			out.println("설명: <textarea name='description' rows='10' cols='80'>"
					+ vo.getDescription()
					+ "</textarea><br>");
			out.println("<input type='submit' value='변경'>");
			out.println("<input type='button' value='취소'");
			out.println("				onclick=\"location.href='detail.bit?no="
					+ vo.getNo()
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title>"
				+ "<style>"
				
				+ "body { background-color : gray;}"
				+ "h1 { text-align : center;} "
				+ "#abox { text-align : center;} "
				+ "#a { text-align : center; text-decoration: none; color : yellow;}"
				
				+ "</style></head><body>");
		
		try{
out.println("<h1>과목 변경 결과</h1>");
			
			SubjectDao dao = (SubjectDao)this.getServletContext()
					.getAttribute("subjectDao");
			
			SubjectVo vo = new SubjectVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			
			dao.update(vo);
			
			out.println("변경 성공!");

		}catch(Throwable e){
			out.println("<h1>오류 발생! 이미 등록된 데이터 또는, 없는 데이터 번호</h1>");
		}
		out.println("</body><div id='abox'><a id = 'a' href='http://192.168.200.77:9998/sems/index.html'>메뉴로</a><br><br>"
				+ "<a id = 'a' href='list.bit?pageNo=1&pageSize=10'>리스트로</a></div></html>");
	}

}
