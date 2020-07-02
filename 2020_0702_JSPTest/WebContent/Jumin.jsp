<%@page import="myutil.Jumin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 파라메터 받기
String jumin_no = request.getParameter("jumin_no");

// 주민번호-> 각각의 부가정보 추출
Jumin jumin = new Jumin();
jumin.setJumin_no(jumin_no);

// 각정보 추출
int year = jumin.getYear();
int age = jumin.getAge();
String tti = jumin.getTti();
String gender = jumin.getGender();
String local = jumin.getLocal();
String season = jumin.getSeason();

// 응답처리.....
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주민번호 확인</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>년</th>
			<td>year</td>
		</tr>

		<tr>
			<th>나이</th>
			<td>age</td>
		</tr>

		<tr>
			<th>띠</th>
			<td>tti</td>
		</tr>

		<tr>
			<th>성별</th>
			<td>gender</td>
		</tr>

		<tr>
			<th>지역</th>
			<td>local</td>
		</tr>

		<tr>
			<th>계정</th>
			<td>season</td>
		</tr>

		<tr>
			<td colspan='2' align='center'></td>

		</tr>
	</table>
	<a href='jumin.html'>다시하기</a>











</body>
</html>