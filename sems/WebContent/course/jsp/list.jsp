<%@page import="sems2.vo.CourseVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<CourseVo> list = (List<CourseVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>과목목록</title>
  
  <style>
  body { width : 100%; height : 100%; background-color : black;}
  a { text-decoration : none; color : yellow; font-weight : bold;}
  .dd:hover { background-color : gray; }
  div { width : 50%; margin-left : 25%; text-align : center;}
  th { border-radius : 20px; text-align : center; background-color : gray; width : 100px;}
  td { border-radius : 20px; text-align : center; background-color : brown; height : 30px; font-weight: bold;}
  h1 { text-align : center; color : gray; }
  table { margin-left : 17%;}</style>
</head>
<body>
<h1>과정 목록</h1>
<div>
<table>
<tr>
  <th>No</th>
  <th>Title</th>
  <th>Detail</th>
  <th>Update</th>
  <th>Delete</th>
</tr>
<%for(CourseVo course : list) {%>
<tr>
  <td><%=course.getCno()%></td>
  <td><%=course.getTitle()%></td>
  <td><a href='detail.bit?no=<%=course.getCno()%>'>View</a></td>
  <td><a href='update.bit?no=<%=course.getCno()%>'>Update</a></td>
  <td><a href='delete.bit?no=<%=course.getCno()%>'>delete</a></td>
</tr>
<%}%>
</table><br><br>
<a href='/sems/course/insertForm/form.html'>Insert</a><br><br><a href='/sems/index.html'>Menu</a></div>

</body></html>















    