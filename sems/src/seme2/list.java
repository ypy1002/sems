package seme2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/course/list.bit")
public class list extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MysqlCourseDao dao = new MysqlCourseDao();

		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		

		try {
			List<CourseVo> list = dao.list(pageNo, pageSize);

			response.setContentType("text/html;charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>test01</title><style>table { text-align : center;} td{border : 1px solid red; text-align : center;} td:hover{background-color : yellow;} .no{width : 40px;} .subject{width : 200px;}</style></head>");
			out.println("<body><table id='table'><tr><td class='no'>번호</td><td class='subject'>과목명</td></tr>");
			
			for (CourseVo subjectVo : list) {
				out.println("<tr><td>" + subjectVo.getSno() + "</td><td>" + subjectVo.getTitle() + "</td></tr>");
			}
			
			out.println("</table></body></html>");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
