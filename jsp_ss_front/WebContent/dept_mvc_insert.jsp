<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>입력 페이지</h1>
<form action="${pageContext.request.contextPath}/dept/insert.do" method="post">
	부서번호 : <input type="text" name="deptno" size="10"><br>
	부서명 : <input type="text" name="dname" size="10"><br>
	부서위치 : <input type="text" name="loc" size="10"><br>
	<input type="submit" value="전송">
	<input type="reset" value="초기화">
</form>
</body>
</html>