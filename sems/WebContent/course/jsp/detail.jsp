<%@page import="sems2.vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
    <%
    CourseVo course = (CourseVo)request.getAttribute("course");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과정 상세 정보</title>
<style>
body { width : 100%; height : 100%; background-color : black;}
a { text-decoration : none; color : yellow;}
.dd:hover { background-color : gray; }
div { width : 21%; margin-left : 40%; text-align : center;  }
th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}
td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold; width : 200px;}
textarea { border-radius : 20px;  background-color : brown; font-weight: bold; width : 200px; text-align : center;}
h1 { text-align : center; color : gray; }
</style></head><body>
<h1>과정 상세정보</h1>
<div><table>
<tr>
<th>No</th>
<td><%=course.getCno()%></td>
</tr>
<tr>
<th>Title</th>
<td><%=course.getTitle()%></td>
</tr>
<tr>
<th>Description</th>
<td><textarea rows='5' cols='40'><%=course.getDescription()%></textarea></td>
</tr>
<tr>
<th>Hours</th>
<td><%=course.getHours()%></td>
</tr>
</table><br><br>
<a href='list.bit?pageNo=1&pageSize=10'>List</a><br><br>
<a href='delete.bit?no=<%=course.getCno()%>'>Delete</a><br><br>
<a href='update.bit?no=<%=course.getCno()%>'>Update</a></div>
</body></html>

