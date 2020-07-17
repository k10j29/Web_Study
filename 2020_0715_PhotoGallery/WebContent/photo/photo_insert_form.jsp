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
#insert_box {
	width: 500px;
	margin: auto;
	margin-top: 50px;
}

.mybutton_style {
	width: 100px;
}
</style>


<script type="text/javascript">
	function send(f) {

		var p_title = f.p_title.value.trim();
		var p_content = f.p_content.value.trim();
		var p_photo = f.p_photo.value;

		if (p_title == '') {
			alert('제목을 입력하세요');
			f.p_title.value = '';
			f.p_title.focus();
			return;
		}

		if (p_content == '') {
			alert('내용을 입력하세요');
			f.p_content.value = '';
			f.p_content.focus();
			return;
		}

		if (p_photo == '') {
			alert('사진을 선택하세요');
			return;
		}

		//전송  :  /photo/insert.do call
		f.action = "insert.do";//PhotoInsertAction

		f.submit();

	}
</script>


</head>
<body>
	<div id="insert_box">
		<div class="panel panel-primary">
			<div class="panel-heading">사진등록</div>
			<div class="panel-body">
				<!-- 화일업로드시 속성 -->
				<form method="POST" enctype="multipart/form-data">
					<table class="table">
						<tr>
							<th>제목</th>
							<td><input name="p_title"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="p_content" rows="5" cols="50"></textarea>
							</td>
						</tr>
						<tr>
							<th>사진</th>
							<td><input type="file" name="p_photo"></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input type="button"
								value="사진올리기" class="btn btn-primary mybutton_style"
								onclick="send(this.form);"> <input type="button"
								value="목록보기" class="btn btn-success mybutton_style"
								onclick="location.href='list.do'"></td>
						</tr>

					</table>
				</form>
			</div>
		</div>

	</div>



</body>
</html>