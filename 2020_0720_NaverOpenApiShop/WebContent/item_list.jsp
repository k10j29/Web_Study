<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>








<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap Library  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


</head>
<body>



	<h2>검색상품 : ${ param.item_name }</h2>
	<table class="table table-hover">
		<tr>
			<th>이미지</th>
			<th>제품명</th>
			<th>최저가</th>
			<th>최고가</th>
			<th>판매처</th>
		</tr>

		<!-- Data  -->
		<!-- for(ShopVo vo : list)  -->
		<c:forEach var="vo" items="${ list }">
			<tr>
				<td><img src="${ vo.image }" width="80" height="100"></td>
				<td><a href="${ vo.link }" target="blank">${ vo.title }</a></td>
				<td><fmt:setLocale value="ko_KR" /> <fmt:formatNumber
						type="currency" value="${vo.lprice}" /></td>

					<td><fmt:setLocale value="ko_KR" /> <fmt:formatNumber
						type="currency" value="${vo.hprice}" /></td>
				<td>${ vo.mallname }</td>



			</tr>


		</c:forEach>


	</table>


</body>
</html>



