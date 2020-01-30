<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <%String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/mybatis/resources/jquery-3.2.1.min.js"></script> 
<script>
$(document).ready(function() {
	var result = "${result}";
	if(result != null && result != "") {
		alert(result);
	}
});

</script>
</head>
<body>
<h2>글 수정 화면입니다.</h2>
<form id="boardform" action="<%=path %>/boardupdate" method="post">
<input type="hidden" name="seq" value=${detail.seq }>
제목 : <input type="text" name="title" value=${detail.title }><br>
내용 : <input type="text" name="contents" value=${detail.contents } style="width:200px;height:100px;"><br>
작성자 : <input type="text" name="writer" value=${detail.writer }><br>
비밀번호 : <input type="password" name="password" ><br>
<input type="button" value="수정 완료" onclick="document.getElementById('boardform').submit();">
<!-- <input type="submit" value="수정 완료"> -->
<input type=button value="이전 화면" onclick="location.href='/mybatis/boarddetail?seq=${detail.seq }'">
</form>
</body>
</html>