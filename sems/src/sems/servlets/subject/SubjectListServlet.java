package sems.servlets.subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

@WebServlet("/subject/list.bit")
@SuppressWarnings("serial")
public class SubjectListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목목록</title><style>body{background-color : gray;}"
				+ " td { background-color : black; color : white; text-align : center; border-radius : 5px;}"
				+ " h1 { text-align : center; } div { width : 400px; margin-left : 39%;} th{ border-radius : 5px; background-color : violet; } "
				+ "#no { width : 50px; } #su { width : 300px; } td:hover { background-color : white; color : black; }"
				+ "#abox { text-align : center; } #a { text-align : center; text-decoration: none; color : yellow;}</style></head><body>");
		
		try{
			out.println("<h1>과목 목록</h1>");
			
			SubjectDao dao = (SubjectDao) this.getServletContext().getAttribute("subjectDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
			List<SubjectVo> list = dao.list(pageNo, pageSize);

			out.println("<div><table><tr><th id='no'>번호</th><th id='su'>과목명</th></tr>");
			
			for(SubjectVo subject : list){
				out.println("<tr><td>" + subject.getNo() + "</td><td>" + subject.getTitle() +"</td><tr>");
			}
		}catch(Throwable e){
			out.println("오류 발생!");
		}
		
		out.println("</table></div><div id='abox'><a id = 'a' href='http://192.168.200.77:9998/sems/index.html'>목록으로</a><br><br></div></body></html>");
	}

}
