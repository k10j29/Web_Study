<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/css/photo.css">

<script type="text/javascript">
  function photo_insert(){
	  
	  //로그인 상태 체크 : Session에 MemberVo user를 저장함
	  
	  //로그인 안되어 있으면
	  if('${ empty sessionScope.user }'=='true'){
		  
		  if(confirm("사진등록은 로그인하신후 가능합니다\n"+
				     "로그인 하시겠습니까?")==false)return;
		  
		  //현재경로 : /photo/list.do
		  //로그인 폼으로 이동 : action.member.MemberLoginFormAction
		  location.href="../member/login_form.do";
		  return;
	  }
  
      //로그인이 된 상태
      location.href="insert_form.do";//PhotoInsertFormAction
	    
  }
  
  
  function del(p_idx){
	  
	  if(confirm("정말 삭제하시겠습니까?")==false)return;
	  
	  //삭제        PhotoDeleteAction
	  location.href="delete.do?p_idx=" + p_idx;
  }
  
  
  
  function download(filename){
	  
	  //로그인 체크
	  
	  if('${ empty user}'=='true'){
		  alert('화일다운로드는 로그인 하신후\n이용가능합니다');
		  return;
	  }
	  
	  //alert("하나 둘 셋");
	  //alert(encodeURIComponent("하나 둘 셋"));
	  // ' ' -> 32 -> 0x20 -> %20
	  
	  //현재경로 : /photo/list.do
	  //화일다운로드  /FileDownload.do call
	  // Filedownload.do?dir=/upload/&filenam=a.jpg
      //주의)자바스크립트에서 특수문자 또는 한글 전송시
      //     encodeURIComponent로 인코딩해서 전송해야 된다
	  location.href="../FileDownload.do?dir=/upload/&filename=" 
			        + encodeURIComponent(filename,"utf-8");		  
  }
  
  function show_popup(p_idx){
	  
	  //document크기
	  var d_w = $(document).width();
	  var d_h = $(document).height();
	  //popup 크기
	  var p_w = $("#popup").width();
	  var p_h = $("#popup").height();
	  
	  var left_pos = d_w/2 - p_w/2;
	  var top_pos  = d_h/2 - p_h/2;
	  
	  //위치
	  $("#popup").css({left:left_pos,top:top_pos});
	  
	  
	  //Ajax처리
	  //alert(p_idx);
	  $.ajax({
		  url:"photo_one.do",//PhotoOneAction
		  data:{"p_idx":p_idx},
		  dataType: "json",
		  success:function(res_data){
			  //PhotoVo-> JSON으로 포장
			  //res_data = {"p_idx":"51","p_title":"dd",
			  //            "p_filename":"a.jpg",...}
			  $("#popup > img").attr("src","../upload/" + res_data.p_filename);
			  
			  $("#p_title").html("제목:" + res_data.p_title);
			  $("#p_content").html(res_data.p_content);
			  
			  //substr(시작인덱스,갯수)            
			  //substring(시작인덱스,라스트인덱스) <=자바와 동일
			  var str = "작성자:" + res_data.m_name +
			            "<br>작성일자:" + 
			                 //res_data.p_regdate.substring(0,16);
			                 res_data.p_regdate.substr(0,16);
			  $("#p_name").html(str);
		  },
		  error:function(err){
			  alert(err.responseText);
		  }
	  });
	  
	  
	  
	  
	  
	  $("#popup").fadeIn(1000);
	  
  }
  
  function hide_popup(){
	  $("#popup").fadeOut(1000);
  }


</script>





</head>
<body>

	<!-- popup 윈도우 -->
	<%@include file="popup.jsp"%>



	<div id="main_box">
		<h1 id="title">▦▦PhotoGallery▦▦</h1>
		<div align="right">
			<!-- Login이 안된경우
  	          MemberVo user  
  	      -->
			<c:if test="${ empty user }">
				<input class="btn btn-primary  mybutton_style" type="button"
					value="로그인" onclick="location.href='../member/login_form.do'">
			</c:if>

			<!-- Login이 된경우 -->
			<c:if test="${ not empty user }">
  	         ${ user.m_name }님 환영합니다 
  	         <input class="btn btn-primary mybutton_style" type="button"
					value="로그아웃" onclick="location.href='../member/logout.do'">
				<!-- action.member.MemberLogoutAction -->
			</c:if>
		</div>
		<br>
		<!--사진올리기  -->
		<div align="right">
			<input class="btn btn-primary mybutton_style" type="button"
				value="사진올리기" onclick="photo_insert();">
		</div>
		<br>

		<div id="photo_box">

			<!-- 데이터가 없을경우 -->
			<c:if test="${ empty list }">
				<div>사진자료가 없습니다</div>
			</c:if>

			<!-- 데이터가 있는경우  -->
			<!--  for(PhotoVo  vo : list) -->
			<c:forEach var="vo" items="${ list }">
				<div class="box_style">
					<img src="../upload/${ vo.p_filename }"
						onclick="show_popup('${ vo.p_idx }');">
					<div class="title_style">${ vo.p_title }</div>
					<div align="center">

						<input class="btn btn-info" type="button" value="받기"
							onclick="download('${ vo.p_filename }');">



						<!-- 삭제권한:소유주 또는 관리자 -->
						<c:if
							test="${ (user.m_idx eq vo.m_idx) or (user.m_grade eq '관리자') }">
							<input class="btn btn-danger" type="button" value="삭제"
								onclick="del('${ vo.p_idx }');">
						</c:if>

					</div>
				</div>


			</c:forEach>


		</div>

	</div>

</body>
</html>





