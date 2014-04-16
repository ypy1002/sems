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
		out.println("<html><head><title>과목상세정보</title><style>body{background-color : gray;}"
				+ " td { background-color : black; color : white; text-align : center; border-radius : 5px;}"
				+ " h1 { text-align : center; } div { width : 600px; margin-left : 31%;} th{ border-radius : 5px; background-color : violet; } "
				+ "#no { width : 100px; } #su { width : 300px; } td:hover { background-color : white; color : black; }"
				+ "#abox { text-align : center; } #a { text-align : center; text-decoration: none; color : yellow;}"
				+ "textarea { background-color : brown; color : white; border-radius : 10px;} </style></head><body>");
		
		try{
			out.println("<h1>과목 상세정보</h1>");
			
			SubjectDao dao = (SubjectDao) this.getServletContext().getAttribute("subjectDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
		
			SubjectVo subject = dao.detail(no);

			out.println("<div><table>");
			out.println("<tr><th id='no'>번호</th><td>" + subject.getNo() +"</td></tr>");
			out.println("<tr><th>과목명</th><td>" + subject.getTitle() +"</td></tr>");
			out.println("<tr><th>내용</th><td><textarea rows='5' cols='60'>" + subject.getDescription() +"</textarea></td></tr>");
			out.println("</table></div>");
		}catch(Throwable e){
			out.println("<h1>오류 발생! 등록되지 않은 데이터 번호! </h1>");
			e.printStackTrace();
		}
		out.println("</body><div id='abox'><a id = 'a' href='http://192.168.200.77:9998/sems/index.html'>메뉴로</a><br><br>"
				+ "<a id = 'a' href='list.bit?pageNo=1&pageSize=10'>리스트로</a></div></html>");
	}
}
