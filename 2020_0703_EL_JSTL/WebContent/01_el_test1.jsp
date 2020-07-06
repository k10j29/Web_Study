<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //EL(Expression Language):표현언어
    //형식: ${ 표현식 또는 값 } 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
  EL 연산자
<hr>
<h3>산술연산자</h3>
\${ 1 + 1 } : ${ 1 + 1 } <br>
\${ 1 - 1 } : ${ 1 - 1 } <br>
\${ 1 * 1 } : ${ 1 * 1 } <br>
\${ 1 / 1 } : ${ 1 / 1 } <br>
\${ 1 % 1 } : ${ 1 % 1 } <br>


<h3>관계연산자</h3>
\${ 3 > 2 }  : ${ 3 > 2 } <br>
\${ 3 gt 2 } : ${ 3 gt 2 }<br> <!-- greater then  -->

\${ 3 >= 2 }  : ${ 3 >= 2 } <br>
\${ 3 ge 2 } : ${ 3 ge 2 }<br> <!-- greater equal -->

\${ 3 < 2 }  : ${ 3 < 2 } <br>
\${ 3 lt 2 } : ${ 3 lt 2 }<br> <!-- less then -->

\${ 3 <= 2 }  : ${ 3 <= 2 } <br>
\${ 3 le 2 } : ${ 3 le 2 }<br> <!-- less equal -->

\${ 3 == 2 }  : ${ 3 == 2 } <br>
\${ 3 eq 2 } : ${ 3 eq 2 }<br> <!-- equal  -->

\${ 3 != 2 }  : ${ 3 != 2 } <br>

<!-- EL형식의 내용을 주석처리하려면 JSP주석으로 처리해라 -->
<%-- \${ 3 ne 2 } : ${  }<br> --%> <!-- not equal  -->

\${ '파리'=='새' } : ${ '파리'=='새' }

<!-- HTML주석 : JSP->Servlet코드변환시 그냥 넘어간다 -->
<%-- JSP주석  : JSP->Servlet코드변환시 안 넘어간다  ${ }  --%>

<h3>일반논리연산자</h3>
\${ true and true } : ${ true and true }<br>
\${ true or false } : ${ true or false }<br>

\${ (2020%400==0) or (2020%4==0 and 2020%100 != 0)} : 
 ${ (2020%400==0) or (2020%4==0 and 2020%100 != 0)} <br> 

\${ not true } : ${ not true }<br>
\${ not (2>3) } : ${ not (2>3) }<br>

</body>
</html>