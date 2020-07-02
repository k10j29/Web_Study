<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//파라메터 수신
String name = request.getParameter("name");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gender = request.getParameter("gender");
String profile = request.getParameter("profile");

//동일한 parameter명이 여러개 있는경우 배열로 받는다
String[] hobby_array = request.getParameterValues("hobby");
//취미항목은 체크하지 않으면 안넘어온다 => 배열은 null
String hobby_list = "취미없음";
StringBuffer sb = new StringBuffer();

if (hobby_array != null) {
	//String [] hobby_array = {"독서","운동"};
	for (String hobby : hobby_array) {
		sb.append(hobby);
		sb.append(" ");
	}
	// sb = "독서 운동 " <=sb 내용
	//StringBuffer에 누적된 문자열을 옮겨놓는다
	hobby_list = sb.toString().trim();
}

//값의 여부와 상관없이 무조건 들어온다(무조건 배열 3개)	
String[] friend_array = request.getParameterValues("friend");

//String [] friend_array = {"","",""};
//String [] friend_array = {"일친구","이친구",""};

StringBuffer sb1 = new StringBuffer();
for (String friend : friend_array) {
	sb1.append(friend);
	sb1.append(" ");
}

//sb1 = "";             <=친구없는경우
//sb1 = "일친구 이친구";

String friend_list = "친구없음";

//비어있지 않으면
if (sb1.toString().trim().isEmpty() == false) {
	friend_list = sb1.toString().trim();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">

		<tr>
			<th>이름</th>
			<td>name</td>

		</tr>

		<tr>
			<th>아이디</th>
			<td>id</td>

		</tr>

		<tr>
			<th>성별</th>
			<td>gender</td>

		</tr>

		<tr>
			<th>자기소개</th>
			<td>profile</td>

		</tr>

		<tr>
			<th>취미</th>
			<td>hobby</td>

		</tr>




	</table>
	<a href="member_register.jsp">다시하기</a>
</body>
</html>






