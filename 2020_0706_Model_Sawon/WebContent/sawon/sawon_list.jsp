<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<body>
	<div class="container">
		<table border="1" align="center" class="table table-striped">
			<!-- title -->

			<thead>
			<tbody>
				<tr>


					<th>사원번호</th>
					<th>사원이름</th>
					<th>사원성별</th>
					<th>부서번호</th>
					<th>직무이름</th>
					<th>입사일자</th>
					<th>상관번호</th>
					<th>연봉</th>

				</tr>
				<!-- data -->
				<!--  for(DeptVo vo : list ) 동일 -->
				<c:forEach var="vo" items="${ requestScope.list }">
					<tr>
						<td>${ vo.sabun }</td>
						<td>${ vo.saname }</td>
						<td>${ vo.sasex }</td>

						<td>${ vo.deptno }</td>
						<td>${ vo.sajob }</td>
						<td>${ vo.sahire }</td>
						<td>${ vo.samgr }</td>
						<td>${ vo.sapay }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>