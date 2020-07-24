<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<style type="text/css">
  #main_box{
      width: 600px;
      margin: auto;
      margin-top: 20px;
  }
  
  #title{
      font-family: 휴먼옛체,궁서체,굴림체;
      text-align: center;
      font-size: 25pt;
      color: #3355cc;
      text-shadow: 1px 1px 1px black;
  }
  
  .content_type{
     /* width: 96%; */
     border: 1px solid #cccccc;
     min-height: 50px;
     height: auto; /* 내용에 따라서 늘어난다 */
     margin-bottom: 10px;
     
     box-shadow: 2px 2px 2px #888888;
     font-size: 12pt;
     padding: 10px;
  }

</style>

<script type="text/javascript">
  
  function del(f) {
	  
	  //사용자 입력 비번
	  var c_pwd	= f.c_pwd.value.trim();
	  
	  if(c_pwd==''){
		 alert('삭제비밀번호를 입력하세요');
		 f.c_pwd.value='';
		 f.c_pwd.focus();
		 return;
	  }
	  
	  //Ajax(Http통신)를 이용해서 서버에서  비번확인
	  $.ajax({
		  type:'GET',//요청방식(생략시 기본 GET)
		  url :'check_pwd.do',                       //VisitCheckPwdAction
		  data:{ 'idx': f.idx.value,'c_pwd': c_pwd },//parameter
		  dataType: 'json',                          //수신데이터 타입
		  success:function(res_data){
			  //res_data = {"result":true}
			  
			  //비번틀린경우
			  if(res_data.result==false){
				  alert('비밀번호가 틀립니다');
				  return;
			  }
			  
			  //맞는경우
			  
			  //최종 삭제 확인    
	          if(confirm("정말 삭제 하시겠습니까?")==false)return;
			  
	    	  //삭제요청코드  
	    	  location.href="delete.do?idx=" + f.idx.value;
			  
		  },
		  error:function(err){
			  alert(err.status);
			  alert(err.responseText);
		  }
	  });
	 
	  
	  
	  
	 
	  
	 
	 
  }

  function modify_form(f) {
	  
	  var pwd 	= f.pwd.value;//원래비번
	  var c_pwd	= f.c_pwd.value.trim();//사용자 입력 비번
	  
	  if(c_pwd==''){
		 alert('수정비밀번호를 입력하세요');
		 f.c_pwd.value='';
		 f.c_pwd.focus();
		 return;
	  }
	  
	  //비번 비교
	  if(pwd != c_pwd){
		  alert('비밀번호가 틀립니다');
		  f.c_pwd.value='';
		  f.c_pwd.focus();
		  return;
	  }
	  
	  
	  //방법1) 자바스크립트 이용한 전송
	  //             VisitModifyFormAction  
	  location.href="modify_form.do?idx=" + f.idx.value;
  }
  
  
  //jQuery초기화
  $(document).ready(function(){
	  
	  //검색메뉴 초기화
	  $("#search").val("${ (empty param.search) ? 'all' : param.search }");
	  //전체검색이면 검색어 지우기
	  if("${ param.search }"=="all"){
		  $("#search_text").val("");
	  }
	  
	  //검색버튼이 눌리면
	  $("#btn_find").click(function(){
		  
		  var search      = $("#search").val();
		  var search_text = $("#search_text").val();
		  
		  //검색카테고리 전체검색이 아닌데 검색어가 비어있으면
		  if(search!='all' && search_text==''){
			  alert('검색어를 입력하세요!!');
			  return;
		  }
		  
		  
		  
		  //조회요청
		  location.href="list.do?search=" + search +
				        "&search_text=" + 
				        encodeURIComponent(search_text,"utf-8");
	  });
	  
  });
  
</script>

</head>
<body>

<div id="main_box">
   <h1 id="title">::::방명록::::</h1>
   <div align="right">
      <input class="btn btn-primary" type="button"  value="방명록 쓰기"
             onclick="location.href='insert_form.do'">
   </div>
   <br>
   
   <!-- 검색메뉴 -->
   <div align="center">
       <select  id="search">
           <option value="all">전체보기</option>
           <option value="name">이름</option>
           <option value="content">내용</option>
           <option value="name_content">이름+내용</option>
       </select>
       
       <input id="search_text"  value="${ param.search_text }">
       <input id="btn_find"  type="button"  value="검색">
       
   </div>
   
   <br>
   
   <!-- 데이터가 없는 경우 -->
   <c:if test="${ empty list }">
      <div>게시물이 존재하지 않습니다</div> 
   </c:if>
   
   <!-- 데이터가 있는 경우 -->
   <!--  for(VisitVo vo : list) 동일 -->
   <c:forEach var="vo"  items="${ list }">
      <div class="panel panel-primary">
	      <!-- 작성자(IP) 작성일자 -->
	      <div class="panel-heading">
	         <h4>
	         ${ vo.name }(${ vo.ip })<br>
	         ${ fn:substring(vo.regdate,0,16) }
	         </h4> 
	      </div>
	      <!-- 
	           내용
	           비번      수정  삭제
	       -->
	      <div class="panel-body">
	        <div class="content_type">${ vo.content }</div>
	        
	        <form>
	            <input type="hidden"  name="idx" value="${ vo.idx }"> 
		        <div>
		           비밀번호(${ vo.pwd }):<input type="password"  name="c_pwd">
		                    <input class="btn btn-info"   type="button" value="수정"
		                           onclick="modify_form(this.form);">
		                    <input class="btn btn-danger" type="button" value="삭제"
		                           onclick="del(this.form);">
		        </div>
	        </form>
	        
	      </div>
	  </div>
   
   </c:forEach>

</div>


</body>
</html>






