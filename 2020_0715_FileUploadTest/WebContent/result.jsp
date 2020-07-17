<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- requestScope 생략가능 -->
	TITLE : ${ requestScope.title }
	<br> IP : ${ ip }
	<br>


	<img src="upload/${ filename }" width="150">
	<br>

	<a href="input.jsp">RE</a>
</body>
</html>