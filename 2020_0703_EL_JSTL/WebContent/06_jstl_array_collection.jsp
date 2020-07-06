<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
   
<%
    //배열
    String [] fruit_array = {"사과","참외","수박","딸기"};
    //for(String fruit: fruit_array){}
    
    //ArrayList
    List<String> sido_list = new ArrayList<String>();
    sido_list.add("서울");//0
    sido_list.add("경기");//1
    sido_list.add("인천");//2
    sido_list.add("대전");//3
    sido_list.add("강원");//4
    
    //Set : 순서없이 저장/중복값 허용안함
    Set<String> bookSet = new HashSet<String>();
    bookSet.add("Java");
    bookSet.add("Oracle");
    bookSet.add("JSP");
    bookSet.add("Html");
    bookSet.add("CSS");
    bookSet.add("Javascript");
    
    //JSTL(EL)에서 사용하려면..scope에 등록
    pageContext.setAttribute("fruit_array",fruit_array);
    pageContext.setAttribute("sido_list", sido_list);
    pageContext.setAttribute("bookSet", bookSet);
  

%>   
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<hr>
  Array 출력(forEach)
<hr>
 <ul>
    <!-- 배열 또는 Collection사용하려면 items을 이용 -->
    <!--  for(String fruit : fruit_array) 동일함     -->
    <c:forEach var="fruit" items="${ fruit_array  }">
        <li>${ pageScope.fruit }</li>
    </c:forEach>
 </ul>
 
 <hr>
   ArrayList 출력(forEach)
 <hr>
  <ul>
     <!-- for(String sido : sido_list)와 동일  -->
     <c:forEach var="sido"  items="${ sido_list }" varStatus="i">
       
        <c:if test="${ i.index%2==0 }">
        	<li><font color=red>${ i.index } : ${ sido }</font></li>
        </c:if>
        <c:if test="${ i.index%2==1 }">
        	<li><font color=blue>${ i.index } : ${ sido }</font></li>
        </c:if>
     </c:forEach>
  </ul>
  
  <hr>
    Set출력(forEach)
  <hr>
    <ul>
       <c:forEach var="book"  items="${ bookSet }" varStatus="i">
       
          <c:choose>
             <c:when test="${ i.index%3==0 }">
                <li><font color=green>${ i.index } : ${ book }</font></li>
             </c:when>
             
             <c:when test="${ i.index%3==1 }">
                <li><font color=yellow>${ i.index } : ${ book }</font></li>
             </c:when>
             
             <c:when test="${ i.index%3==2 }">
                <li><font color=cyan>${ i.index } : ${ book }</font></li>
             </c:when>
             
          </c:choose>
          
       </c:forEach>
    </ul>
   
  
  
  
  


</body>
</html>




