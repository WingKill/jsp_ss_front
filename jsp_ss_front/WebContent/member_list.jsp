<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 리스트</h1>
<%-- 	<c:forEach var="member" items="${memberList}">
		<hr>
		아이디 : ${member.id}<br>
		비밀번호 : ${member.pw}<br>
		이메일 : ${member.email}<br>
		주소 : ${member.address}<br>	
		<hr>
	</c:forEach> --%>
	<table border="1" style="text-align:center;">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>주소</td>
		</tr>
	<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.id}</td>
			<td>${member.pw}</td>
			<td>${member.email}</td>
		 	<td>${member.address}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>