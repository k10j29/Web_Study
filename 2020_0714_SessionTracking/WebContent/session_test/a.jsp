<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!-- 세션 아이디 체크 -->


<!-- EL 식은 4개의 Scope 에서만 사용가능? scope -->

<%
	//HTTPSession session 이라는 객체는 내장 객체 (jsp 에 만들어져있음)
String session_id = session.getId();

//JSP 에서 Servlet 에게 전달한 method 

session.setAttribute("msg1", "Hi ~ Servlet!!!");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션ID :
	<%=session_id%><br> 전달받은 메시지: ${ empty msg ? 'no message' : sessionScope.msg }
	<br>


	<a href="/test_session.do"> 세션 테스트 서블릿 </a>
</body>
</html>