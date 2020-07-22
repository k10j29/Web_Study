<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#input_box {
	width: 500px;
	margin: auto;
	margin-top: 50px;
}
</style>


<script type="text/javascript">
	function send(f) {

		var name = f.name.value.trim();
		var content = f.content.value.trim();
		var pwd = f.pwd.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			f.name.value = '';
			f.name.focus();
			return;
		}

		if (content == '') {
			alert('내용을 입력하세요');
			f.content.value = '';
			f.content.focus();
			return;
		}

		if (pwd == '') {
			alert('비밀번호를 입력하세요');
			f.pwd.value = '';
			f.pwd.focus();
			return;
		}

		//
		f.action = "modify.do"; // VisitModifyAction
		f.submit();//전송

	}
</script>

</head>
<body>

	<form>
		<input type="hidden" name="idx" value="${ vo.idx }">
		<div id="input_box">


			<div class="panel panel-success">
				<div class="panel-heading">
					<h3>방명록수정</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>작성자</th>
							<td><input name="name" value="${ requestScope.vo.name }"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea cols="50" rows="5" name="content">${ vo.content }</textarea></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input
								class="btn btn-primary" type="button" value="수정하기"
								onclick="send(this.form);"> <input
								class="btn btn-success" type="button" value="목록보기"
								onclick="location.href='list.do'"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
</html>