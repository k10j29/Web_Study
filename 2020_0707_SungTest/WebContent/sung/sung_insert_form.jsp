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

	//숫자 정규식
	var regular_num = /^[0-9]{1,3}$/;

	function send(f) {

		var name = f.name.value.trim();
		var kor = f.kor.value.trim();
		var eng = f.eng.value.trim();
		var mat = f.mat.value.trim();

		if (name == '') {
			alert('이름을 입력하세요');
			f.name.vlaue = ''; //입력안한사람
			f.name.focus(); //포커스 원위치
			return;

		}

		//국어 점수 체크

		if (regular_num.test(kor) == false || kor<0 || kor>100) {
			alert('0 ~ 100 점 사이의 숫자만 입력하세요');
			f.kor.value = '';
			f.kor.focus();
			return;

		}

		//영어 점수 체크

		if (regular_num.test(eng) == false || eng<0 || eng>100) {
			alert('0 ~ 100 점 사이의 숫자만 입력하세요');
			f.eng.value = '';
			f.eng.focus();
			return;

		}

		//수학 점수 체크

		if (regular_num.test(mat) == false || mat<0 || mat>100) {
			alert('0 ~ 100 점 사이의 숫자만 입력하세요');
			f.mat.value = '';
			f.mat.focus();
			return;

		}

		//전송하기
		//   현위치 /sung/insert_form.do
		f.action = "insert.do";
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
					성적입력폼
					<h3>
			</div>
			<div class="panel-body">
				<form>
					<table class="table">

						<tr>
							<th>이름</th>
							<td><input name="name"></td>
						</tr>

						<tr>
							<th>국어</th>
							<td><input name="kor"></td>
						</tr>

						<tr>
							<th>영어</th>
							<td><input name="eng"></td>
						</tr>

						<tr>
							<th>수학</th>
							<td><input name="mat"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input class="btn-primary"
								type="button" value="등록하기" onclick="send(this.form);"> <input
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