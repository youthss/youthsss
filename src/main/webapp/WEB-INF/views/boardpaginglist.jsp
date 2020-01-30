<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
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
<h1>글 목록</h1>
<table ><tr><th>번호</th><th>제목</th><th>작성자</th><th>작성시간</th><th>조회수</th></tr>
<c:forEach items="${paginglist}" var="paginglist"> 
<tr><td >${paginglist.seq }
</td><td><a href='/mybatis/boarddetail?seq=${paginglist.seq}'></a>${paginglist.title}
</td><td>${paginglist.writer}
</td><td>${paginglist.time}
</td><td>${paginglist.viewcount}
</td></tr>
</c:forEach>
</table> 

<input type=button value="글쓰기" onclick="location.href='/mybatis/boardwrite'">

</body>
</html>