<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var regular_num = /^[0-9]{1,5}$/;

	function send(f) {

		var su1 = f.su1.value.trim();
		var su2 = f.su2.value.trim();

		if (regular_num.test(su1) == false) {
			alert('1~5자리 숫자만 입력하세요');
			f.su1.value = '';
			f.su1.focus();
			return;
		}

		if (regular_num.test(su2) == false) {
			alert('1~5자리 숫자만 입력하세요');
			f.su2.value = '';
			f.su2.focus();
			return;
		}

		//전송 : action을 생략하면 자신에게 전송
		f.submit();

	}
</script>

</head>
<body>
	<form>
		수1:<input name="su1"><br> 수2:<input name="su2"><br>
		<input type="button" value="+ - * / %" onclick="send(this.form);">
	</form>

	<hr>
	<%
		//java Code 작성
	// Test_Parameter .jsp
	%>


</body>
</html>