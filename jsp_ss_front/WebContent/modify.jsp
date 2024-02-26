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
	<form action="${pageContext.request.contextPath}/modify.do" method="post">
		아이디 : <input type="text" name="id" size="20" value="${sessionScope.member.getId()}"><br>
		패스워드 : <input type="password" name="pw" size="20" value="${sessionScope.member.getPw()}"><br>
		이메일 : <input type="text" name="email" size=20 value="${sessionScope.member.getEmail()}"><br>
		주소 : <input type="text" name="address" size=20 value="${sessionScope.member.getAddress()}"><br>	
		<input type="submit" value="수정">
		<input type="reset" value="초기화">
	</form>
</body>
</html>