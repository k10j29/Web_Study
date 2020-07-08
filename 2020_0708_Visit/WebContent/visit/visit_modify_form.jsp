<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap library -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#input_box {
	width: 400px;
	margin: auto;
	margin-top: 70px;
}
</style>



<script type="text/javascript">
	/* <!-- 자바스크립트 클라이언트 부분 --> */

	function send(f) {

		var idx = f.idx.value.trim();
		var content = f.content.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			f.name.vlaue = ''; //입력안한사람
			f.name.focus(); //포커스 원위치
			return;

		}

		//전송하기
		//   현위치 /sung/insert_form.do
		f.action = "modify.do";
		//지정된 action 으로 전송
		f.submit();

	}
</script>


</head>
<body>
	<div id="input_box">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>
					성적수정폼
					<h3>
			</div>
			<div class="panel-body">
				<form>
					<table class="table">


						<tr>
							<th>내용</th>
							<td><input name="no" value="${vo.no}"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input class="btn-primary"
								type="button" value="수정하기" onclick="send(this.form);"> <input
								class="btn-success" type="button" value="목록보기"
								onclick="location.href='list.do'"></td>
						</tr>




					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>