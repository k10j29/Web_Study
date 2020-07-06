<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   //EL 값을 표현
   //1.EL표현식으로 값을 표현하려면
   //  : 4개영역의 저장된값 또는 param영역만 출력할수있다
   //    pageScope/requestScope/sessionScope/applicationScope
   //    param/paramValues
   
   //각영역에 값을 저장(JSP내장객체를 이용)
   pageContext.setAttribute("hello", "page: 안녕");
   request.setAttribute("hello", "request: 안녕");
   session.setAttribute("hello", "session: 안녕");
   application.setAttribute("hello", "application: 안녕");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- EL표현    ${ 영역명.객체명 }      --%>
pageContext => ${ pageScope.hello } <br>
request     => ${ requestScope.hello } <br> 
session     => ${ sessionScope.hello } <br>
application => ${ applicationScope.hello } <br>

<!-- 변수의 참조순서
     pageScope > requestScope > sessionScope > applicationScope
 -->

영역명생략  => ${ hello } <br>

<!-- 
    02_el_test2.jsp
    02_el_test2.jsp?message=안녕하세요 
-->
현재페이지 호출시 전달된 메시지 : ${ (empty param.message) ? '없음' : param.message }<br>



</body>
</html>




