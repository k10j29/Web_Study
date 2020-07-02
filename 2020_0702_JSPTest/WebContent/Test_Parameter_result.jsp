<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   //Scriptlet : 코드영역 
   // _jspService(request,response)
   //{
   //     JspWriter      out;
   //     ServletContext application;
   //     HttpSession    session;
   //     PageContext    pageContext;
   //}
   // 위에 숨겨져있는 JSP객체 : JSP내장객체   


   // t/Test_Parameter_result.jsp?su1=111&su2=222
   
   String su1 = request.getParameter("su1");
   String su2 = request.getParameter("su2");
   //정수로 변환
   int s1 = Integer.parseInt(su1);
   int s2 = Integer.parseInt(su2);
   
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <ul>
      <%-- <%= n %> => out.print(n); --%>
      <li><%= String.format("%d + %d = %d",s1,s2,s1+s2) %></li>
      <li><%= String.format("%d - %d = %d",s1,s2,s1-s2) %></li>
      <li><%= String.format("%d * %d = %d",s1,s2,s1*s2) %></li>
      <%
      if(s2==0){
      %>
      
      	  <li><%= "0으로는 나눌수 없습니다" %></li>
      <%
      }else{
      %>
	      <li><%= String.format("%d / %d = %d",s1,s2,s1/s2) %></li>
	      <li><%= String.format("%d %% %d = %d",s1,s2,s1%s2) %></li>
      <%
      }
      %>
        
  </ul>
  <a href="Test_Parameter.jsp">다시하기</a>

</body>
</html>






