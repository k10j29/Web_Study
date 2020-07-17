<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<style type="text/css">
#login_box {
	width: 500px;
	margin: auto;
	margin-top: 50px;
}

.mybutton_style {
	width: 100px;
}
</style>

<script type="text/javascript">
	function login(f) {

		var m_id = f.m_id.value.trim();
		var m_pwd = f.m_pwd.value.trim();

		if (m_id == '') {
			alert('아이디를 입력하세요');
			f.m_id.value = '';
			f.m_id.focus();
			return;
		}

		if (m_pwd == '') {
			alert('비밀번호를 입력하세요');
			f.m_pwd.value = '';
			f.m_pwd.focus();
			return;
		}

		//Login처리를 Ajax로 함.

		$.ajax({
			type : "POST",
			url : "login.do",//MemberLoginAction
			data : {
				"m_id" : m_id,
				"m_pwd" : m_pwd
			},//parameter
			dataType : "json",//결과타입
			success : function(res_data) {
				// res_data={"result":"success"}
				// res_data={"result":"fail_id"}
				// res_data={"result":"fail_pwd"}
				if (res_data.result == 'fail_id') {
					alert('아이디가 존재하지 않습니다');
					return;
				}

				if (res_data.result == 'fail_pwd') {
					alert('비밀번호가 틀립니다');
					return;
				}

				//로그인 성공: 메인페이지로 이동
				location.href = "../photo/list.do";

			}

		});

	}
</script>

</head>
<body>
	<div id="login_box">
		<div class="panel panel-primary">
			<div class="panel-heading">로그인</div>
			<div class="panel-body">
				<form>
					<table class="table">
						<tr>
							<th>아이디</th>
							<td><input name="m_id"></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="m_pwd"></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input
								class="btn btn-primary mybutton_style" type="button" value="로그인"
								onclick="login(this.form);"> <input
								class="btn btn-info mybutton_style" type="button" value="회원가입"
								onclick="location.href='./insert_form.do'"> <input
								class="btn btn-success mybutton_style" type="button"
								value="목록보기" onclick="location.href='../photo/list.do'">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>

