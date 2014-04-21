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
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style>
body { 
width : 100%; 
height : 100%; 
background-image: url(d.jpg); 
font-family: serif;
background-size: cover;
}
input { 
border-radius : 5px;
}
a { 
text-decoration : none; 
font-size: large;
color : black;
}
div { 
padding: 7px;
border-radius : 10px;
background-color: #8888ff;
opacity: 0.8;
width : 25%; 
margin-left : 35%; 
text-align : center; 
}
h1 { 
text-align : center; 
}
.insec{
}
</style>     
</head>
<body><div>
<h1>사용자 데이터 변경</h1>
<form action='/sems/users/update.bit' method='post' onsubmit='return re();'>
번호<br> <input class='insec' type='text' name='uno' value='<%=vo.getUno()%>' readonly><br>
메일<br><input class='insec' type='text' id='email' name='email' placeholder='Email' value='<%=vo.getEmail()%>'><br>
암호<br><input class='insec' type='password' id='password' name='password' placeholder='password' value='<%=vo.getPassword()%>'><br>
이름<br><input class='insec' type='text' id='name' name='name' placeholder='name' value='<%=vo.getName()%>'><br>
전화<br><input class='insec' type='text' id='tel' name='tel' placeholder='tel' value='<%=vo.getTel()%>'><br>
팩스<br><input class='insec' type='text' name='fax' placeholder='fax' value='<%=vo.getFax()%>'><br>
우편번호<br><input class='insec' type='text' name='postNo' placeholder='postNo' value='<%=vo.getPostNo()%>'><br>
주소<br><input class='insec'type='text' name='addr' placeholder='addr' value='<%=vo.getAddr()%>'><br>
사진<br><input class='insec' type='text' name='photoPath' placeholder='photoPath' value='<%=vo.getPhoto()%>'><br><br>
<input type='submit' value='변경' onclick=check(); class="btn btn-info">
<input type='reset' value='취소' class="btn btn-info"><br><br>
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