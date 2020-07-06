<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center">
   <!-- title -->
   <tr>
      <th>부서번호</th>
      <th>부서명</th>
      <th>위치</th>
   </tr>
   <!-- data -->
   <!--  for(DeptVo vo : list ) 동일 -->
   <c:forEach  var="vo" items="${ requestScope.list }">
	   <tr>
	   	  <td>${ vo.deptno }</td>
	   	  <td>${ vo.dname }</td>
	   	  <td>${ vo.loc }</td>
	   </tr>
   </c:forEach>

</table>


</body>
</html>