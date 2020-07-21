<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Library  -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
   #box{
      width: 800px;
      margin: auto;
      margin-top: 50px;
   }
</style>
  
</head>
<body>

<div id="box">
   <table class="table table-hover">
   		<tr>
   		    <th>고객번호</th>
   		    <th>고객이름</th>
   		    <th>주소</th>
   		    <th>주민번호</th>
   		    <th>고객담당사원</th>
   		</tr>
   		
   		<!-- Data -->
   		<!-- for(GogekVo vo : list)  -->
   		<c:forEach var="vo"  items="${ list }">
   		   <tr>
   		      <td>${ vo.gobun}</td>
   		      <td>${ vo.goname }</td>
   		      <td>${ vo.goaddr }</td>
   		      <td>${ vo.gojumin }</td>
   		      <td>${ vo.godam }</td>
   		       
   		   </tr>
   		</c:forEach>
   		
   </table>
</div>





</body>
</html>