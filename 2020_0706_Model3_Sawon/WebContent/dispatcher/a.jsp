<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
      //request 전송(보낸다) forward
      RequestDispatcher disp = 
         request.getRequestDispatcher("b.jsp");
       //b.jsp=>서버내부에서 전달받을 객체(Page) 
      disp.forward(request, response);
      
%>    