<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
		<h2>XML Test</h2>
		<p>시간이 남았으니 부트스트랩까지</p>
		<table class="table table-hover" border = "50" >

			<!-- 테이블 타이틀 -->

			<tr class="warning">
				<th>이름</th>
				<th>별명</th>
				<th>나이</th>
				<th>번호</th>
				<th>집번호</th>
			</tr>

			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${ vo.name }</td>
					<td>${ vo.nickname }</td>
					<td>${ vo.age }</td>
					<td>${ vo.tel }</td>
					<td>${ vo.hometel }</td>
				</tr>


			</c:forEach>



		</table>
	</div>
</body>
</html>