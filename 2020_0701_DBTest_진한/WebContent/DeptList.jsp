<%@page import="dao.DeptDao"%>
<%@page import="vo.DeptVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//Java Code를 작성 할수있는 Area
List<DeptVo> list = DeptDao.getInstance().selectList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">

		<!-- title -->

		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>직위</th>
			<th>성별</th>
			<th>부서번호</th>
			<th>입사일자</th>
			<th>상사번호</th>
			<th>급여</th>
		</tr>
		
		<%
			for (DeptVo vo : list) {
		%>

		<tr>
			<td><%= vo.getSabun() %></td>
			<td><%=vo.getSaname()%></td>
			<td><%=vo.getSasex()%></td>
			<td><%=vo.getDeptno()%></td>
			<td><%=vo.getSajob()%></td>
			<td><%=vo.getSahire()%></td>
			<td><%=vo.getSamgr()%></td>
			<td><%=vo.getSapay()%></td>

		</tr>

		<%
			} //end for
		%>
	</table>

</body>
</html>