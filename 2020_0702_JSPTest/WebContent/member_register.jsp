<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 선언적 방식으로 자바스크립트 처리 -->
<script type="text/javascript">
	document.title = "제목변경하기...";

	function send(f) {
		//alert('전송하기');
		//document:자바스크립트에서 문서(html)을 관리하는 객체
		//자바스크립트에서 변수선언:var 변수명;
		//var f = document.f;//<form>

		//입력된 이름값을 구한다->공백제거
		var name = f.name.value.trim();
		var id = f.id.value.trim();
		var pwd = f.pwd.value.trim();
		var profile = f.profile.value.trim();

		//이름이 비어있으면
		if (name == '') {
			alert('이름을 입력하세요');
			f.name.value = '';//값비우기
			f.name.focus(); //포커스지정
			return;
		}

		if (id == '') {
			alert('아이디를 입력하세요');
			f.id.value = '';//값비우기
			f.id.focus(); //포커스지정
			return;
		}

		if (pwd == '') {
			alert('비밀번호를 입력하세요');
			f.pwd.value = '';//값비우기
			f.pwd.focus(); //포커스지정
			return;
		}

		if (profile == '') {
			alert('자기소개를 입력하세요');
			f.profile.value = '';//값비우기
			f.profile.focus(); //포커스지정
			return;
		}

		f.action = "member_register_result.jsp"; // MemberRegisterAction

		//f.method = "POST";//생략시 기본값 GET

		//<form>요소의 모든항목을 전송한다
		f.submit();//<form> : submit()

	}
</script>

</head>
<body>

	<!--  form : 데이터를 묶어서 서버로 전송하는 기능 
      form 속성(attribute)
       1.action : 전송대상(생략시 자신에게 전송) 
       2.method : 전송방식(생략시 기본 GET)
                  *** GET : QueryString방식
                           (전달데이터는 URL에 붙여서 전송)
       
        URL
        http://localhost:9090/2020_0611_HtmlTest/member_register.jsp?name=홍길동&id=hong
                                              ?변수명=값&변수=값..                         
        (protocol) host:port/path/content(jsp)?name=홍길동&id=hong
                                              ?Query   
                  *** POST: 요청헤더에 숨겨서 전송
                            주소창에 안보인다                        
       
       
-->
	<form name="f" action="" method="">
		*이름 : <input type="text" name="name" value=""><br> *아이디:
		<input type="text" name="id"><br> *비밀번호:<input
			type="password" name="pwd"><br>
		<!-- 성별 : 라디오 버튼  name속성명을 동일하게 해야됨-->
		성별: <input type="radio" name="gender" value="남자" checked="checked">남자
		<input type="radio" name="gender" value="여자">여자 <br>
		<!-- 취미 : 체크박스 
              체크된 항목만 서버로 전송된다  
   -->
		취미: <input type="checkbox" name="hobby" value="독서">독서 <input
			type="checkbox" name="hobby" value="운동">운동 <input
			type="checkbox" name="hobby" value="영화">영화 <input
			type="checkbox" name="hobby" value="낚시">낚시 <br> 친구1:<input
			type="text" name="friend"><br> 친구2:<input type="text"
			name="friend"><br> 친구3:<input type="text" name="friend"><br>

		<!-- 혈액형 : 콤보박스  -->
		혈액형:<select name="blood">
			<option value="A">A형</option>
			<option value="B">B형</option>
			<option value="O">O형</option>
			<option value="AB">AB형</option>
		</select> <br> *자기소개:<br>
		<!-- 여러줄 입력시  -->
		<textarea name="profile" rows="5" cols="50"></textarea>
		<br>

		<!-- <input type="submit" value="전송하기"> -->
		<input type="button" value="전송하기" onclick="send(this.form);">

		<input type="reset" value="취소하기">

	</form>









</body>
</html>