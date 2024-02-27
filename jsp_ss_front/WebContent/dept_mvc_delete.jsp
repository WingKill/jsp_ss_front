<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>삭제 페이지</h1>
<form action="${pageContext.request.contextPath}/dept/delete.do" method="post">
	부서번호 : <input type="text" name="deptno" size="10"><br>
	<input type="submit" value="전송">
	<input type="reset" value="초기화">
</form>
</body>
</html>