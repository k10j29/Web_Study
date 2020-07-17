<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function send(f) {

		var title = f.title.value.trim();
		var photo = f.photo.value;

		if (title == '') {
			alert("제목을 입력하세요")
			f.title.value = '';
			f.title.focus();
			return;
		}

		if (photo == '') {
			alert("사진을 선택하세요")
			return;
		}

		f.action = "upload.do"; //FileUploadAction (upload.do)
		f.submit();
	}
</script>



</head>
<body>

	<!-- 클라이언트 처리 -->
	<!-- 파일 업로드시 고려사항 -->

	<!-- 

1 - 전송 방식은 *무조건* POST 방식 
(GET = 데이터를 Query 주소창에 붙여서 보냄 POST(전송 용량에 제한없음) = 요청 Header 에 숨겨서 보냄)
2 - 전송 인코딩은 enctype="multipart/form-data"
 -->


	<form method="POST" enctype="multipart/form-data">
		TITLE : <input name="title"><br> PHOTO : <input
			type="file" name="photo"><br> <input type="button"
			value="send" onclick="send(this.form);"><br>

	</form>


</body>
</html>