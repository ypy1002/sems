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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//	POST요청의 값에 대해 적용. GET요청의 값은 ?
		//		-	서블릿 컨테이너의 안내에 따라 설정한다.
		//		-	getParameter()를 호출하기 전에 실행해야 한다.
		//		단, 한번이라도 getParameter()를 호출했다면 적용안됨
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title><style>body{background-color : gray;}"
				+ " h1 { text-align : center; } #abox { text-align : center; } "
				+ "#a { text-align : center; text-decoration: none; color : yellow;} </style></head><body>");
		
		try{
			out.println("<h1>과목 변경 결과</h1>");
			
			SubjectDao dao = (SubjectDao) this.getServletContext().getAttribute("subjectDao");
			
			SubjectVo subjectVo = new SubjectVo();
			subjectVo.setNo(Integer.parseInt(request.getParameter("no")));
			subjectVo.setTitle(request.getParameter("title"));
			subjectVo.setDescription(request.getParameter("description"));
			
			dao.update(subjectVo);
			out.println("<h1>변경 성공</h1>");

		}catch(Throwable e){
			out.println("<h1>오류 발생! 이미 등록된 데이터 또는, 없는 데이터 번호</h1>");
		}
		out.println("</body><div id='abox'><a id = 'a' href='http://192.168.200.77:9998/sems/index.html'>목록으로</a><br><br></div></html>");
	}

}
