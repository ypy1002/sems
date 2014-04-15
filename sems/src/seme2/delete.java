package seme2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/subject/delete.bit")
public class delete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MysqlCourseDao dao = new MysqlCourseDao();

		int sno = Integer.parseInt(request.getParameter("no"));

		try {
			dao.delete(sno);
			response.setContentType("text/html;charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<html><head><title>test01</title><style>td{border : 1px solid red; text-align : center;} .no{width : 40px;} .subject{width : 200px;}</style></head>");
			out.println("<body>");
			out.println("<h1>삭제성공입니다.</h1>");
			out.println("</body></html>");
		} catch (Throwable e) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<h1>삭제실패입니다.</h1>");
		}
	}
}
