<%@ page import="sems3.vo.UsersVo" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
List<UsersVo> list = (List<UsersVo>) request.getAttribute("list");  
%>   
    
<!DOCTYPE html>
<html>
<head>
<title>유저목록</title>
<style>
body {
	width: 100%;
	height: 100%;
	background-color: black;
}

a {
	text-decoration: none;
	color: yellow;
	font-weight: bold;
}

.dd:hover {
	background-color: gray;
}

div {
	width: 50%;
	margin-left: 24%;
	text-align: center;
}

th {
	border-radius: 20px;
	text-align: center;
	background-color: gray;
	width: 100px;
}

td {
	border-radius: 20px;
	text-align: center;
	background-color: brown;
	height: 30px;
	font-weight: bold;
}

h1 {
	text-align: center;
	color: gray;
}

#ds {
	width: 200px;
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
			
			<%for(UsersVo users : list){%>
			<tr>
				<td><%=users.getUno()%></td>
				<td><%=users.getEmail()%></td>
				<td><%=users.getPassword()%></td>
				<td><%=users.getName()%></td>
				<td id='ds'><%=users.getTel()%></td>
				<td class='dd'><a href='detail.bit?no=15'>View</a></td>
				<td class='dd'><a href='update.bit?no=15'>Update</a></td>
				<td class='dd'><a href='delete.bit?no=15'>Delete</a></td>
			</tr>
		<%}%>	
		</table>
		<br>
		<br> <a href='/sems/insertForm/form.html'>Insert</a><br>
		<br>
		<a href='/sems/index.html'>Menu</a>
	</div>
</body>
</html>
