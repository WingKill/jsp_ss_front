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
	<hr>
	<hr>
	<hr>
	테스트 링크<br>
	<a href="${pageContext.request.contextPath}/dept/list.do">dept 리스트 보기</a>	
	<hr>
	<a href="${pageContext.request.contextPath}/dept_mvc_insert.jsp">dept 입력창 가기</a>
	<hr>
	<a href="dept_mvc_update.jsp">dept 수정창 가기</a>
	<hr>
	<a href="dept_mvc_delete.jsp">dept 삭제창 가기</a>	
</body>
</html>