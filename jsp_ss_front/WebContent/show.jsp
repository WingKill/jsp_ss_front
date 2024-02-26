<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>show.jsp 입니다.</h1>
<hr>
	${pageScope.id} / ${requestScope.id} / ${sessionScope.id} / ${application.id}<br> 
	id : ${requestScope.id}<br>
	pw : ${pw}<br>
</body>
</html>