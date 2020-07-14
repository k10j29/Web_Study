<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //쿠키정보를 읽어오기
    Cookie [] cookie_array = request.getCookies();
    StringBuffer sb = new StringBuffer("[최근방문한페이지]<br>");
    if(cookie_array!=null){
    	
    	for(Cookie cookie1 : cookie_array){
    		
    		String name = cookie1.getName();
    		String value = cookie1.getValue();
    		
    		if(!name.equals("JSESSIONID")){
    		   //System.out.printf("%s : %s\n",name,value);
    		   sb.append(String.format("<a href='%s'>%s</a><br>",value,name));
    		}
    	}
    	
    }

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   #disp{
       position:absolute;
       right: 50px;
       
       width: 300px;
       height: 200px;
       padding: 20px;
       background-color: #cccccc;
       color: green;
       font-size: 20pt;
   }
</style>
</head>
<body>
<div id="disp"><%= sb.toString() %></div>
</body>
</html>