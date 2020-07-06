<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
  
<%
     List<PersonVo>  p_list = new ArrayList<PersonVo>();
     p_list.add(new PersonVo("일길동",21,"010-111-1234"));
     p_list.add(new PersonVo("이길동",22,"010-211-1234"));
     p_list.add(new PersonVo("삼길동",23,"010-311-1234"));
     p_list.add(new PersonVo("사길동",24,"010-411-1234"));
     p_list.add(new PersonVo("오길동",25,"010-511-1234"));

     //request binding(연결)
     request.setAttribute("p_list", p_list);
    

%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <table border="1">
      <!-- title  -->
      <tr>
      	   <th>번호</th>
      	   <th>이름</th>
      	   <th>나이</th>
      	   <th>주소</th>
      </tr>
      
      <!-- data -->
      <!--  for(PersonVo p : p_list) 와 동일 -->
      <c:forEach var="p" items="${ p_list }"  varStatus="i">
	      <tr>
	          <td>${ i.index + 1 }</td>
	          <td>${ p.name }</td>
	          <td>${ p['age'] }</td>
	          <td>${ p.tel }</td>
	      </tr>
      </c:forEach>
  </table>




</body>
</html>








