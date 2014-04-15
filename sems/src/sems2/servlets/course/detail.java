package sems2.servlets.course;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems.dao.MysqlSubjectDao;
import sems.vo.SubjectVo;

@SuppressWarnings("serial")
@WebServlet("/course/detail.bit")
public class detail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MysqlSubjectDao dao = new MysqlSubjectDao();

		int no = Integer.parseInt(request.getParameter("no"));

		try {
			SubjectVo vo = dao.detail(no);

			response.setContentType("text/html;charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>test01</title><style>td{border : 1px solid red; text-align : center;} .no{width : 40px;} .subject{width : 200px;}</style></head>");
			out.println("<body><table>");
			
				out.println("<tr><td>번호</td><td>" + vo.getSno() + "</td></tr><tr><td>과목명</td><td>" 
			+ vo.getTitle() + "</td></tr><tr><td>설명</td><td><textarea rows='5' cols='100'>" + vo.getDescription() + "</textarea></td></tr>");
			
			out.println("</table></body></html>");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
