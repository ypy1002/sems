package seme2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/course/update.bit")
public class update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MysqlCourseDao dao = new MysqlCourseDao();

		int sno = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		CourseVo subjectVo = new CourseVo().setSno(sno).setTitle(title).setDescription(description);

		try {
			dao.update(subjectVo);
			response.setContentType("text/html;charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>test01</title><style>td{border : 1px solid red; text-align : center;} .no{width : 40px;} .subject{width : 200px;}</style></head>");
			out.println("<body>");
			out.println("<h1>변경성공입니다.</h1>");
			out.println("</body></html>");
		} catch (Throwable e) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>변경실패입니다.</h1>");
		}
	}
}
