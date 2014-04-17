package sems2.servlets.course;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems2.dao.CourseDao;
import sems2.vo.CourseVo;

@WebServlet("/course/update.bit")
@SuppressWarnings("serial")
public class CourseUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
				
		
		try {
			//1) DB에서 과목 상세 정보를 가져온다.
			int no = Integer.parseInt(request.getParameter("no"));
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("courseDao");
			CourseVo vo = dao.detail(no);
			
			out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>사용자 데이터 입력 폼</title>");
			out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js'></script>"

			+ "<style>"
			
			  + "body { width : 100%; height : 100%; background-color : black;}"
			  + "input { border-radius : 5px;}"
			  + ".aad { border-radius : 5px; width : 19.7%;}"
			  + "a { text-decoration : none; color : yellow;}"
			  + "div { width : 50%; margin-left : 24%; text-align : center; margin-left : 22%;}"
			  + "h1 { text-align : center; color : gray; }"
			  + "textarea { border-radius : 5px;}"
			  
			  + "</style>");
			
			out.println("</head><body><div><h1>과정 데이터 변경</h1>");
			out.println("<form action='/sems/course/update.bit' method='post' onsubmit='return re();'>");
			out.println("<input class='aad' type='text' name='cno' value='" + vo.getCno() +"' readonly><br>");
			out.println("<input class='aad' type='text' id='title' name='title' placeholder='Title' value='" + vo.getTitle() +"'><br>");
			out.println("<textarea name='description' placeholder='Description'>" + vo.getDescription() + "</textarea><br>");
			out.println("<input class='aad' type='text' name='hours' placeholder='hours' value='" + vo.getHours() +"'><br>");
			out.println("<input type='submit' value='변경' onclick=check();>");
			out.println("<input type='reset' value='취소'><br><br>"
					+ "<a href='list.bit?pageNo=1&pageSize=10'>List</a>");
			out.println("</form></div>");
			
			out.println("<script>");

			out.println("var i = 0;");
			
			out.println("	function check(){");
			out.println("  	if($('#title').val() == ''){");
			out.println("    	alert('email은 필수 입력 항목입니다.');");
			out.println("   	i++;");
			out.println("  	}");
			out.println(" }");

			out.println("	function re(){");
			out.println("		if(i == 0){");
			out.println("			return true;");
			out.println("		}else{");
			out.println("			i = 0;");
			out.println("			return false;");
			out.println("		}");
			out.println("	}");

			out.println("</script>");
			out.println("</body></html>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// CharacterEncodingFilter로 대체함.
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목변경</title></head><body>");
		
		try {
			out.println("<h1>과목 변경 결과</h1>");
			
			CourseDao dao = (CourseDao)this.getServletContext()
					.getAttribute("courseDao");
			
			CourseVo vo = new CourseVo();
			vo.setCno(Integer.parseInt(request.getParameter("cno")));
			vo.setTitle(request.getParameter("title"));
			vo.setDescription(request.getParameter("description"));
			vo.setHours(Integer.parseInt(request.getParameter("hours")));
			
			dao.update(vo);
			
			out.println("변경 성공!");
			
			response.sendRedirect("detail.bit?no=" + vo.getCno());
			
		} catch (Throwable e) {
			out.println("<h1>오류 발생 했음!</h1>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















