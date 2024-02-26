<%@page import="edu.sejong.ex.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 페이지입니다.</h1>
	<!-- 테스트를 위해 readonly 속성 제거 -->
	<form action="${pageContext.request.contextPath}/delete.do" method="post">
		아이디 : <input type="text" name="id" size="20" value="${sessionScope.member.getId()}"><br>
		<input type="submit" value="삭제">
		<input type="reset" value="초기화">
	</form>
</body>
</html>