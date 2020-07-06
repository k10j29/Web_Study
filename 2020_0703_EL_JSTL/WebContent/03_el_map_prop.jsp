<%@page import="java.util.Properties"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   //Map & Properties 
   //Map
   Map map = new HashMap();
   //         key       value
   map.put("first_name","홍");
   map.put("last_name" ,"길동");
   map.put("tel"       ,"010-111-1234");
   
   //Properties
   Properties prop = new Properties();
   // put과 setProperty가 동일함
   //         key       value
   prop.put("driver", "oracle.jdbc.driver.OracleDriver");
   prop.put("url"   , "jdbc:oracle:thin:@localhost:1521:xe" );
   prop.setProperty("user", "scott");
   prop.setProperty("pwd" , "tiger");
       
   
   //PageContext영역에 저장:왜?(EL표현식으로 출력)
   //                        key  value
   pageContext.setAttribute("map", map);
   pageContext.setAttribute("prop", prop);
  
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL :맵의 Key를 이용한 값표현  
        1.객체명.key  
        2.객체명['key']
-->
<hr>
 Map출력
<hr>
성:   ${ pageScope.map.first_name }<br>
이름: ${           map.last_name }<br>
전화: ${ map['tel'] }<br>

<hr>
 Properties출력
<hr>
Driver: ${ prop.driver }<br>
Url   : ${ prop.url }<br>
User  : ${ prop['user'] }<br>
Pwd   : ${ prop["pwd"] }<br>




</body>
</html>


