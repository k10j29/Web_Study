<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
   //현재 방문시 방문이력을 쿠키에 저장
   //                         key   value
   //                         name  value 
   Cookie cookie = new Cookie("C","C.jsp");

   //쿠키 유효시간 설정(Persistance(지속성))
   cookie.setMaxAge(60);

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

C.jsp입니다<br>

<a href="A.jsp">A page로 이동</a>

</body>
</html>