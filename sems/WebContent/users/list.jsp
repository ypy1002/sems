<%@ page import="sems3.vo.UsersVo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<title>유저목록</title>
<style>
body {
  background-image:url('b.JPG');
  background-size: 100%;
	width: 100%;
	height: 100%;
}
a {
	text-decoration: none;
	font-weight: bold;
	color: navy;
}
.dd:hover {
	background-color: silver;
}
div {
  font-family: serif;
	width: 45%;
	margin-top: 3%;
	margin-left: 31%;
	text-align: center;
}
th {
	border-radius: 15px;
	text-align: center;
	background-color: aqua;
	width: 100px;
}
td {
	border-radius: 15px;
	text-align: center;
	background-color: #ff5566;
	height: 30px;
	font-weight: bold;
}
h1 {
	text-align: center;
}
#ds {
	width: 200px;
}
.go {
  color: maroon;
  margin: 10px;
  font-size: x-large;
}
</style>
</head>
<body>
	<div>
		<table>
			<h1>사용자 목록</h1>
			<tr>
				<th>No</th>
				<th>Email</th>
				<th>Password</th>
				<th>Name</th>
				<th>Tel</th>
				<th>Detail</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="users" items="${list}">
			<tr>
				<td>${users.uno}</td>
				<td>${users.email}</td>
				<td>${users.password}</td>
				<td>${users.name}</td>
				<td id='ds'>${users.tel}</td>
				<td class='dd'><a href='detail.bit?no=${users.uno}'>View</a></td>
				<td class='dd'><a href='update.bit?no=${users.uno}'>Update</a></td>
				<td class='dd'><a href='delete.bit?no=${users.uno}'>Delete</a></td>
			</tr>
		</c:forEach>
		</table>
		<a class='go' href='/sems/insertForm/form.html'>Insert</a>
		<a class='go' href='/sems/index.html'>Menu</a>
	</div>
</body>
</html>
