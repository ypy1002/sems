<%@page import="sems2.vo.CourseVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
CourseVo course = (CourseVo) request.getAttribute("course");
%>

<!DOCTYPE html><html><head><meta charset='UTF-8'><title>과정 데이터 입력 폼</title>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js'></script>
<style>
body { width : 100%; height : 100%; background-color : black;}
input { border-radius : 5px;}
.aad { border-radius : 5px; width : 19.7%;}
a { text-decoration : none; color : yellow;}
div { width : 50%; margin-left : 24%; text-align : center; margin-left : 22%;}
h1 { text-align : center; color : gray; }
textarea { border-radius : 5px;}
</style>
</head><body><div><h1>과정 데이터 변경</h1>
<form action='/sems/course/update.bit' method='post' onsubmit='return re();'>
<input class='aad' type='text' name='cno' value='<%=course.getCno()%>' readonly><br>
<input class='aad' type='text' id='title' name='title' placeholder='Title' value='<%=course.getTitle()%>'><br>
<textarea name='description' placeholder='Description'><%=course.getDescription()%></textarea><br>
<input class='aad' type='text' name='hours' placeholder='hours' value='<%=course.getHours()%>'><br>
<input type='submit' value='변경' onclick=check();>
<input type='reset' value='취소'><br><br><a href='list.bit?pageNo=1&pageSize=10'>List</a>
</form></div>
<script>
var i = 0;
  function check(){
    if($('#title').val() == ''){
      alert('email은 필수 입력 항목입니다.');
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
</body></html>
