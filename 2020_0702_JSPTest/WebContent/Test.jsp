<%@page import="java.util.Random"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>

<%!
    //선언부 기록
    int count = 0;
    Random rand = new Random(); 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  요청횟수:
  <%
     count++;
  %>
  <%= count %> <!-- 표현식 -->
  
  <table border="1">
     <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
     </tr>
     
     <tr>
     	<td>1</td>
     	<td>오늘은 목요일</td>
     	<td>홍길동</td>
     </tr>
  </table>

</body>
</html>