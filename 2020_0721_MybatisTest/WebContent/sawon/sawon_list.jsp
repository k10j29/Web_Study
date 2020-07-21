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
   		    <th>사번</th>
   		    <th>이름</th>
   		    <th>직위</th>
   		    <th>성별</th>
   		    <th>부서번호</th>
   		    <th>입사일자</th>
   		    <th>상사번호</th>
   		    <th>년봉</th>
   		</tr>
   		
   		<!-- Data -->
   		<!-- for(SawonVo vo : list)  -->
   		<c:forEach var="vo"  items="${ list }">
   		   <tr>
   		      <td>${ vo.sabun }</td>
   		      <td>${ vo.saname }</td>
   		      <td>${ vo.sajob }</td>
   		      <td>${ vo.sasex }</td>
   		      <td>${ vo.deptno }</td>
   		      <td>${ fn:substring(vo.sahire,0,10) }</td>
   		      <td>${ vo.samgr }</td>
   		      <td>
   		       
   		        <!-- \40,000,000 -->
   		        <fmt:formatNumber type="currency" 
   		                          value="${ vo.sapay*10000 }"/>
   		       
   		       </td>
   		       
   		   </tr>
   		</c:forEach>
   		
   </table>
</div>





</body>
</html>