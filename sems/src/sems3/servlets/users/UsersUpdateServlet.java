package sems3.servlets.users;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sems3.dao.UsersDao;
import sems3.vo.UsersVo;

@WebServlet("/users/update.bit")
@SuppressWarnings("serial")
public class UsersUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
				
		
		try {
			//1) DB에서 과목 상세 정보를 가져온다.
			int no = Integer.parseInt(request.getParameter("no"));
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			UsersVo vo = dao.detail(no);
			
			out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>사용자 데이터 입력 폼</title>");
			out.println("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js'></script>"

			+ "<style>"
			
			  + "body { width : 100%; height : 100%; background-color : black;}"
			  + "input { border-radius : 5px;}"
			  + "a { text-decoration : none; color : yellow;}"
			  + "div { width : 50%; margin-left : 24%; text-align : center; margin-left : 22%;}"
			  + "h1 { text-align : center; color : gray; }"
			  
			  + "</style>");
			
			out.println("</head><body><div><h1>사용자 데이터 변경</h1>");
			out.println("<form action='/sems/users/update.bit' method='post' onsubmit='return re();'>");
			out.println("<input type='text' name='uno' value='" + vo.getUno() +"' readonly><br>");
			out.println("<input type='text' id='email' name='email' placeholder='Email' value='" + vo.getEmail() +"'><br>");
			out.println("<input type='password' id='password' name='password' placeholder='password' value='" + vo.getPassword() +"'><br>");
			out.println("<input type='text' id='name' name='name' placeholder='name' value='" + vo.getName() +"'><br>");
			out.println("<input type='text' id='tel' name='tel' placeholder='tel' value='" + vo.getTel() +"'><br>");
			out.println("<input type='text' name='fax' placeholder='fax' value='" + vo.getFax() +"'><br>");
			out.println("<input type='text' name='postNo' placeholder='postNo' value='" + vo.getPostNo() +"'><br>");
			out.println("<input type='text' name='addr' placeholder='addr' value='" + vo.getAddr() +"'><br>");
			out.println("<input type='text' name='photoPath' placeholder='photoPath' value='" + vo.getPhoto() +"'><br><br>");
			out.println("<input type='submit' value='변경' onclick=check();>");
			out.println("<input type='reset' value='취소'><br><br>"
					+ "<a href='list.bit?pageNo=1&pageSize=10'>List</a>");
			out.println("</form></div>");
			
			out.println("<script>");

			out.println("var i = 0;");
			
			out.println("	function check(){");
			out.println("  	if($('#email').val() == ''){");
			out.println("    	alert('email은 필수 입력 항목입니다.');");
			out.println("   	i++;");
			out.println("  	}else if($('#password').val() == ''){");
			out.println("    	alert('password는 필수 입력 항목입니다.');");
			out.println("   	i++;");
			out.println("  	}else if($('#name').val() == ''){");
			out.println("    	alert('name은 필수 입력 항목입니다.');");
			out.println("   	i++;");
			out.println("   }else if($('#tel').val() == ''){");
			out.println("   	alert('tel은 필수 입력 항목입니다.');");
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
			
			UsersDao dao = (UsersDao)this.getServletContext()
					.getAttribute("usersDao");
			
			UsersVo vo = new UsersVo();
			vo.setUno(Integer.parseInt(request.getParameter("uno")));
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostNo(request.getParameter("postNo"));
			vo.setAddr(request.getParameter("addr"));
			vo.setPhoto(request.getParameter("photoPath"));
			
			dao.update(vo);
			
			out.println("변경 성공!");
			
			response.sendRedirect("detail.bit?no=" + vo.getUno());
			
		} catch (Throwable e) {
			out.println("<h1>오류 발생 했음!</h1>");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















