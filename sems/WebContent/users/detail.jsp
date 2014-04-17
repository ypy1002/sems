<%@page import="sems3.vo.UsersVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UsersVo users = (UsersVo) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	width: 100%;
	height: 100%;
	background-color: black;
}

a {
	text-decoration: none;
	color: yellow;
}

.dd:hover {
	background-color: gray;
}

div {
	width: 21%;
	margin-left: 40%;
	text-align: center;
}

th {
	border-radius: 20px;
	text-align: center;
	background-color: gray;
	width: 100px;
}

textarea{
border-radius: 20px;
background-color: brown;
}
td {
	border-radius: 20px;
	text-align: center;
	background-color: brown;
	height: 30px;
	font-weight: bold;
	width: 200px;
}

h1 {
	text-align: center;
	color: gray;
}
</style>
<meta charset="UTF-8">
<title>유저 상세정보</title>
</head>
<body>
	<h1>유저 상세정보(by JSP)</h1>
	<table border='1'>
		<tr>
			<th>번호</th>
			<td><%=users.getUno()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=users.getEmail()%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=users.getPassword()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=users.getName()%></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=users.getTel()%></td>
		</tr>
		<tr>
			<th>팩스번호</th>
			<td><%=users.getFax()%></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><%=users.getPostNo()%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=users.getAddr()%></td>
		</tr>
		<tr>
			<th>사진</th>
			<td><%=users.getPhoto()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows='5' cols='60'><%=users.getDescription()%></textarea></td>
		</tr>
	</table>
	<a href='list.bit?pageNo=1&pageSize=10'>목록</a>
	<a href='delete.bit?no=<%=users.getUno()%>'>삭제</a>
	<a href='update.bit?no=<%=users.getUno()%>'>변경</a>
	<br>
</body>
</html>
