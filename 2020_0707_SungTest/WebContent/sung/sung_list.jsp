<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#box {
	width: 700px;
	height: auto;
	margin: auto;
}

#title {
	text-align: center;
	font-size: 22pt;
	font-weight: bold;
	color: tomato;
	text-shadow: 2px 2px 3px black;
}

#empty_message {
	color: red;
	font-size: 11pt;
}
</style>

<!-- bootstrap library -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function del(no) {
		//alert('삭제할 번호는=' + no);

		//삭제 확인작업 필요 <확인 true> <취소 false>
		if (confirm("정말 삭제할래?") == false)
			return;

		location.href = "delete.do?no=" + no;

	}
</script>



</head>
<body>


	<div id="box">
		<h1 id="title">□ □ □ 성적관리 □ □ □</h1>
		<div>
			<div align="right">
				<input class="btn btn-primary" type="button" value="성적등록"
					onclick="location.href='insert_form.do'">
				<!-- 8. 성적 등록하기 (연결)  onclick="location.href='insert_form.do'">-->
			</div>
		</div>

		<div>
			<!-- 내용출력 -->
			<table class="table table-striped  table-hover">
				<!-- title -->
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>국어</th>
					<th>영어</th>
					<th>수학</th>
					<th>총점</th>
					<th>평균</th>
					<th>등수</th>
					<th>편집</th>
				</tr>

				<!-- DATA -->
				<!-- 5. Data 가 없을경우 (JSP)   >>> Binding 하지 않은 경우 (주석처리)-->
				<c:if test="${ empty list }">
					<tr>
						<td colspan="9" align="center"><span id="empty_message">데이터가
								없습니다</span></td>
					</tr>
				</c:if>

				<!-- 6. Data 가 있는경우 -->
				<!-- for (SungVo vo : list 와 동일) -->

				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.no }</td>
						<td>${ vo.name }</td>
						<td>${ vo.kor }</td>
						<td>${ vo.eng }</td>
						<td>${ vo.mat }</td>
						<td>${ vo.tot }</td>
						<td>${ vo.avg }</td>
						<td>${ vo.rank }</td>


						<td><input class="btn btn-info" type="button" value="수정"
							onclick="location.href='modify_form.do?no=${ vo.no }'"> <input
							class="btn btn-danger" type="button" value="삭제"
							onclick="del('${ vo.no }');">
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>

</body>
</html>