<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- JSTL을 사용하려면.... -->
<%@ taglib  prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ taglib  prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib  prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions" %>
    
<%
    /*
       JSTL(JSP Standard Tag Library)
       :tag형식의 명령처리 언어
       1.Core Library : if , choose , forEach ...
       2.Fmt  Library : 날짜/숫자 출력형식
       3.Fn   Library : substring, indexOf, replace,..
       
       4.JSTL을 사용하려면(설정)
       		taglibs-standard-impl-1.2.5.jar
       		taglibs-standard-spec-1.2.5.jar
       	 
       	 C:\apache-tomcat-8.5.56\webapps\examples\WEB-INF\lib
       	 에 있는 2개화일을
       	 C:\apache-tomcat-8.5.56\lib 에 복사해놓는다		
    */
    
    //숫자:금전
    int money = 123450000;
       
    //날짜
    Date today = new Date();//현재시스템 날짜
    
    //문자열 날짜
    //                  01234567890123456789012 
    String str_today = "2020-07-03 15:43:50.001";
    
    int dan = 7;
    
    //JSTL내에서 출력되는 값의 표현은 EL식을 사용
    pageContext.setAttribute("money", money);/* new Integer(money)  */
    pageContext.setAttribute("today", today);
    pageContext.setAttribute("str_today", str_today);
    pageContext.setAttribute("dan", dan);

    
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
 fmt / fn Library
<hr>
내가 보유한 현금: <fmt:formatNumber type="currency" value="${ money }" /> <br>
현재날짜: <fmt:formatDate  pattern="YYYY년MM월dd일" value="${ today }"/> <br>
문자열 형식의 날짜: ${ fn:substring(str_today,0,16) } <br> 


<hr>
 Core Library
<hr>

<c:forEach  var="i" begin="1"  end="5" step="1">
   <c:if test="${ i%2 == 1 }">
   	 <font color=red>
	   	 ${ pageScope.i } :  안녕<br>
	 </font>
   </c:if>
   
   <c:if test="${ i%2 == 0 }">
     <font color=blue>
       	 ${ pageScope.i } :  안녕<br>
	 </font>
   </c:if>  
   
</c:forEach>  

<hr>
  ${ dan }단출력
<hr>

<table border='1'>
  
  <c:forEach var="i" begin="1"  end="9">
	  <tr>
	    <td>${ dan } x ${ i } = ${ dan*i }</td>
	  </tr>
  </c:forEach>

</table>

<hr>
  구구단 전체
<hr>

<table border="1">
   <c:forEach var="i"  begin="0"  end="9">
      <tr>
	      <c:forEach var="dan2" begin="2" end="9">
	             <!-- 제목: i==0  -->
		         <c:if test="${ i eq 0 }">  
		         	<th>${ dan2 }단</th>   
		         </c:if>
		         
		         <!-- 내용: i > 0 -->
		         <c:if test="${ i gt 0 }"> 
		            <td>${ dan2 } x ${ i } = ${ dan2*i }</td>
		         </c:if>
	      </c:forEach>
      </tr>
   </c:forEach>

</table>

  
</body>
</html>







