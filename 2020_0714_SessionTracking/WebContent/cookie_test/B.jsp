<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   //현재 방문시 방문이력을 쿠키에 저장
   //                         key   value
   //                         name  value 
   Cookie cookie = new Cookie("B","B.jsp");

   //호출한 해당브라우져측에 저장
   response.addCookie(cookie);
   
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@include file="Menu.jsp" %>

B.jsp입니다<br>

<a href="C.jsp">C page로 이동</a>

</body>
</html>