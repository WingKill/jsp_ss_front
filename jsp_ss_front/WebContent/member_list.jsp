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
	<c:forEach var="member" items="${memberList}">
		<hr>
		아이디 : ${member.id}<br>
		비밀번호 : ${member.pw}<br>
		이메일 : ${member.email}<br>
		주소 : ${member.address}<br>	
		<hr>
	</c:forEach>
</body>
</html>