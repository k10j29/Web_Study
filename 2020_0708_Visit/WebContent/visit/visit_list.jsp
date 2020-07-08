<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main_box {
	width: 600px;
	border: 1px solid gray;
	margin: auto;
	margin-top: 20p;
	font-size: 10pt;
}

#title {
	font-family: d2coding;
	text-align: center;
	font-size: 23pt;
	color: tomato;
	text-shadow: 1px 1px 2px black;
}

.content_type {
	width: 95%;
	border: 1px solid gray;
	min-height: 50px;
	margin-bottom: 10px;
	height: auto;
	box-shadow: 1px 1px black;
	padding: 10px;
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
	function del(f) {

		var pwd = f.pwd.value;//원래비번
		var c_pwd = f.c_pwd.value.trim();//사용자 입력 비번

		if (c_pwd == '') {
			alert('삭제비밀번호를 입력하세요');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		//비번 비교
		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		//최종삭제확인

		if (confirm("정말 삭제할래?") == false)
			return;

		//방법1) 자바스크립트 이용한 전송
		location.href = "delete.do?idx=" + f.idx.value;

		//방법2) form data 전송
		//f.action = "delete.do";
		//f.submit();

	}

	function modi(f) {

		var pwd = f.pwd.value;//원래비번
		var c_pwd = f.c_pwd.value.trim();//사용자 입력 비번

		if (c_pwd == '') {
			alert('수정비밀번호를 입력하세요');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		//비번 비교
		if (pwd != c_pwd) {
			alert('비밀번호가 틀립니다');
			f.c_pwd.value = '';
			f.c_pwd.focus();
			return;
		}

		//최종삭제확인

		if (confirm("수정하시겠습니까?") == false)
			return;

		//방법1) 자바스크립트 이용한 전송
		location.href = "modify_form.do?idx=" + f.idx.value;
		
		

	}
</script>


</head>
<body>

	<div id="main_box">

		<h1 id="title">♬ 방명록 작성 ♬ ~ ♬ ~</h1>
		<div align="right">
			<input class="btn btn-success" type="button" value="방명록 쓰기"
				onclick="location.href='insert_form.do'">
		</div>

		<br>


		<!-- 데이터가 없는경우 -->
		<c:if test="${ empty list }">
			<div>게시물이 존재하지 않습니다.</div>
		</c:if>


		<!-- 데이터가 있는경우 -->
		<!-- for 문이 도는것과 동일 -->

		<c:forEach var="vo" items="${ list }">
			<div class="panel panel-success class">
				<!-- 작성자(IP) 작성일자 -->
				<div class="panel-heading">
					${ vo.name }(${ vo.ip }) <br> ${ fn:substring(vo.regdate,0,16) }
				</div>



				<!-- 
	           내용
	           비번      수정  삭제
	       -->
				<div class="panel-body">
					<div class="content_type">${ vo.content }</div>

					<form>
						<input type="hidden" name="idx" value="${ vo.idx }"> <input
							type="hidden" name="pwd" value="${ vo.pwd }">
						<div>
							비밀번호(${ vo.pwd }):<input type="password" name="c_pwd"> 
							
							
							<input class="btn btn-info" type="button" value="수정"
								onclick="modi(this.form);" >
								
								
								<input class="btn btn-danger" type="button" value="삭제"
								onclick="del(this.form);">



						</div>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>