<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
   JSP Standard Tag Library
   JSTL을 사용하려면  -->
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>   
   

<!-- 여기부터 HTML Code -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/main_menu.css">
<link rel="stylesheet" href="css/sub_menu.css">

</head>
<body>

  <div id="main_box">
     <div id="header">
        <%@include file="header/header.jsp" %>
     </div>
     
     <div id="aside">
        <%@include file="menu/sub_menu_company.jsp" %>
     </div>
     
     <!--  
           main_company.jsp
           main_company.jsp?menu=intro
           
           main_company.jsp?menu=greeting
           main_company.jsp?menu=history
           main_company.jsp?menu=location
                           ?Query  <= URL요소중
                           ?menu => parameter를 전달
      -->
     <div id="content">
         <c:if test="${ (empty param.menu) or (param.menu eq 'intro') }">
             <%@include file="content/company/intro.jsp" %>
         </c:if>           
     
         <c:if test="${ param.menu eq 'greeting' }">
             <%@include file="content/company/greeting.jsp" %>
         </c:if> 
         
         <c:if test="${ param.menu eq 'history' }">
             <%@include file="content/company/history.jsp" %>
         </c:if> 
         
         <c:if test="${ param.menu eq 'location' }">
             <%@include file="content/company/location.jsp" %>
         </c:if> 
         
         
     </div>
     
     
     <div id="footer">
        <%@include file="footer/footer.jsp" %>
     </div>
  </div>

</body>
</html>