<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Front Controller 예제입니다. </h1>
	<!-- <a href="insert.do">insert</a>
	<a href="/insert.do">insert</a> -->
	<a href="join.jsp">insert</a>
	<hr/>
	<%-- <a href="http://localhost:8282<%= request.getContextPath() %>/update.do">update</a> --%>
	<a href="http://localhost:8282<%= request.getContextPath() %>/modify.jsp">update</a>
	<hr>
	<a href="http://localhost:8282${pageContext.request.contextPath}/select.do">select</a>
	<hr>
	<%-- <a href="${pageContext.request.contextPath}/delete.do">delete</a> --%>
	<a href="${pageContext.request.contextPath}/member_delete.jsp">delete</a>
	<hr/>	
	<a href="list.do">list</a>
</body>
</html>