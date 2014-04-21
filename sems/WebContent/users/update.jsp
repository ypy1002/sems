<%@page import="sems3.vo.UsersVo"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% UsersVo vo = (UsersVo) request.getAttribute("vo"); %>
<!DOCTYPE html>
<html>
<head>



<meta charset='UTF-8'>
<title>사용자 데이터 입력 폼</title>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js'></script>

<style>
body { 
width : 100%; height : 100%; background-color : black;}
input { 
border-radius : 5px;
}
a { 
text-decoration : none; 
color : yellow;
}
div { 
width : 50%; 
margin-left : 24%; 
text-align : center; 
margin-left : 22%;
}
h1 { 
text-align : center; 
color : gray; 
}
</style>     
</head>
<body><div>
<h1>사용자 데이터 변경</h1>
<form action='/sems/users/update.bit' method='post' onsubmit='return re();'>
<input type='text' name='uno' value='<%=vo.getUno()%>' readonly><br>
<input type='text' id='email' name='email' placeholder='Email' value='<%=vo.getEmail()%>'><br>
<input type='password' id='password' name='password' placeholder='password' value='<%=vo.getPassword()%>'><br>
<input type='text' id='name' name='name' placeholder='name' value='<%=vo.getName()%>'><br>
<input type='text' id='tel' name='tel' placeholder='tel' value='<%=vo.getTel()%>'><br>
<input type='text' name='fax' placeholder='fax' value='<%=vo.getFax()%>'><br>
<input type='text' name='postNo' placeholder='postNo' value='<%=vo.getPostNo()%>'><br>
<input type='text' name='addr' placeholder='addr' value='<%=vo.getAddr()%>'><br>
<input type='text' name='photoPath' placeholder='photoPath' value='<%=vo.getPhoto()%>'><br><br>
<input type='submit' value='변경' onclick=check();>
<input type='reset' value='취소'><br><br>
<a href='list.bit?pageNo=1&pageSize=10'>List</a>
</form>
</div>
<script>

var i = 0;
      
function check(){
	  if($('#email').val() == ''){
		  alert('email은 필수 입력 항목입니다.');
		  i++;
    }else if($('#password').val() == ''){
      alert('password는 필수 입력 항목입니다.');
      i++;
    }else if($('#name').val() == ''){
      alert('name은 필수 입력 항목입니다.');
      i++;
    }else if($('#tel').val() == ''){
      alert('tel은 필수 입력 항목입니다.');
      i++;
     }
}

function re(){
  if(i == 0){
	  return true;
  }else{
    i = 0;
   return false;
  }
}

</script>
</body>
</html>