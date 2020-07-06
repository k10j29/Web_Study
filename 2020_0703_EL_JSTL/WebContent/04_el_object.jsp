<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    //Custom Object
    PersonVo p = new PersonVo("홍길동",30,"010-111-1234");

    //pageContext binding(연결)=>저장
    pageContext.setAttribute("p", p);		
    
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- EL객체속성(property) 표현방법 :  
     1.객체명.속성명 
     2.객체명['속성명']
-->
이름: ${ pageScope.p.name } <br> <!-- 결과적으로 p.getName() call -->
나이: ${ p['age'] }<br>
전화: ${ p.tel }<br>

</body>
</html>





