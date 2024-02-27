<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 리스트</h1>
<a href="${pageContext.request.contextPath}/front_example.jsp">되돌아가기</a>
	<table border="1" style="border-color: black; background-color: yellow">
		<tr bgcolor="pink" style="text-align: center; font-weight: bold;">
			<td>부서번호</td>
			<td>부서명</td>
			<td>위치명</td>
		</tr>
	<c:forEach var="dto" items="${depts}">
		<tr align="center" style="background-color: white; ">
			<td> ${dto.deptno} </td>
			<td> ${dto.dname} </td>
			<td> ${dto.loc} </td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>