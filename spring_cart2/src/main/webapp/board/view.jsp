<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style></style>
<link rel="stylesheet" href="/css/my.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>

//$(document).ready(function() {}); 	//DOM 생성 후 실행  
//$(window).load(function() {}); 		//페이지 로딩 완료 후 실행
//$(function() {}); 					//로딩될때

$(document).ready(function() {	
	
	//------------ 페이지 로딩 시 댓글 목록 가져와 보여주기 ------------ 
	//alert("AJAX 통신 : info=reply_list&bseq=${keybvo.bseq}");
	//var bseq = ${keybvo.bseq};
	var jsonObj = {"bseq":${keybvo.bseq}};
	
	/*
	//@ResponseBody + @RequestBody
	$.ajax({
		url:"/reply_list",
		type:"post", 
		contentType: 'application/json',
	    data: JSON.stringify(jsonObj),
	    dataType: 'json',
	    success:function(resJson){
			console.log(resJson);
	    	var jsonObject = resJson;
			replyListHTML(jsonObject);
		}
	});  */
	
	
	//@ResponseBody
	$.ajax({
		url:"/reply_list",
		type:"post", 
		dataType: 'json',
		data: jsonObj,
	    success:function(resJson){
	    	console.log(resJson);
	    	var jsonObject = resJson;
			replyListHTML(jsonObject);
		}
	}); 
	
	
	//------------ 댓글입력 버튼 클릭 ------------------
	$("#replyBtn").click(function(){
		var queryString = $("#replyForm").serialize()
		console.log(queryString);  //bseq=7&reply=dddd
		$.ajax({
			url:"/reply_insert",
			type:"post",
			data: queryString,
			success:function(resJson){
				$("#ajaxReplyDiv").empty();
				var jsonObject = resJson;
				console.log(jsonObject);
				replyListHTML(jsonObject);
			}
		});
	});	
	
	//------------ 댓글삭제 버튼 클릭 ------------------
	$(document).on("click", ".replyDelSpan", function() {	//동적			
		var idStr = $(this).attr('id'); 
		alert(idStr);   //rseq=40&bseq=7
		$.ajax({
			url:"/reply_delete",
			type:"post",
			data:idStr ,
			success:function(resJson){
				$("#ajaxReplyDiv").empty();
				var jsonObject = resJson;
				console.log(jsonObject);
				replyListHTML(jsonObject); 
			}
		});
	});
	
	

 	/* $.ajax({
		url:"/reply_list",
		type:"post",  
		data:jsonObj,
	    success:function(resString){
	    	var jsonObject = JSON.parse(resString);
			console.log(jsonObject);
			replyListHTML(jsonObject);
		}
	}); 
 	
 	//------------ 댓글입력 버튼 클릭 ------------------
	$("#replyBtn").click(function(){
		var queryString = $("#replyForm").serialize()
		console.log(queryString);  //bseq=7&reply=dddd
		$.ajax({
			url:"/reply_insert",
			type:"post",
			data: queryString,
			success:function(resString){
				var jsonObject = JSON.parse(resString);
				console.log(jsonObject);
				replyListHTML(jsonObject);
			}
		});
	});	
	
	//------------ 댓글삭제 버튼 클릭 ------------------
	$(document).on("click", ".replyDelSpan", function() {	//동적			
		var idStr = $(this).attr('id'); 
		alert(idStr);   //rseq=40&bseq=7
		$.ajax({
			url:"/reply_delete",
			type:"post",
			data:idStr ,
			success:function(resString){
				$("#ajaxReplyDiv").empty();
				var jsonObject = JSON.parse(resString);
				console.log(jsonObject);
				replyListHTML(jsonObject); 
			}
		});
	});

	*/
    
	
	//------------ 수정/삭제 버튼 클릭 ------------------
	$("#updateBtn").click(function(){
		$("#boardForm").attr('method', 'post');
		$("#boardForm").attr('action', '/update');
		$("#boardForm").submit();
	});
	$("#deleteBtn").click(function(){
		$("#boardForm").attr('method', 'post');
		$("#boardForm").attr('action', '/delete');
		$("#boardForm").submit();
	});
	$("#listBtn").click(function(){
		$(location).attr('href', '/list');
	});	
	
	
	
	
	
	
});	

//------------------------------------
//댓글목록 HTML 만들기	
//------------------------------------
function replyListHTML(res) {
	var jsonObject = res; //JSON.parse(res);
	console.log(jsonObject);
	var htmlStr = "";
	htmlStr += "<ul>";
	$.map(jsonObject, mapCallback);
	function mapCallback( v,  i) { 
		htmlStr += "<li>";
		htmlStr += "<font size='1pt' color='#bbbbbb'>"+v.userid+"</font>";
		htmlStr += "<font size='1pt' color='#bbbbbb'>"+v.regdate+"</font>";
		htmlStr += decodeURIComponent(v.reply);
		htmlStr += "<font color='red'><b>";
		//htmlStr += "<a onClick=replyDelFunc('"+v.rseq+"','"+v.bseq+"')>[X]</a>
		htmlStr += "<span style='cursor:hand' class='replyDelSpan' id='rseq="+v.rseq+"&bseq="+v.bseq+"'>[X]*</span>";
		htmlStr += "</b></font>";
		htmlStr += "</li>";
	
	}
	htmlStr += "</ul>";
	$("#ajaxReplyDiv").html(htmlStr);
}
</script>
</head>
<body>

<h1>Board view</h1>
<hr>
<form id="boardForm" name="boardForm">
	<input type="hidden" name="bseq" value="${keybvo.bseq}">
	<table class="blueTable">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>
					${keybvo.bseq}
				</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>
					${keybvo.userid}
				</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>
					${keybvo.regdate}
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					${keybvo.ufileName} 
<a href="/download?down=${keybvo.ufilePath}/${keybvo.ufileSysName}">[다운로드]</a>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title" value="${keybvo.title}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents" cols="30" rows="5">${keybvo.contents}</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" id="ufile" name="ufile"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<input type="button" id="updateBtn" value="글수정">
				<input type="button" id="deleteBtn" value="글삭제">
				<a href="/list"><input type="button" id="listBtnddd" value="글목록"></a>
				<input type="reset" value="reset"></th>
			</tr>
		</tbody>
	</table>
</form>
<hr>

<!--  -------- 댓글 보여질 영역 ---------- -->
<div id="ajaxReplyDiv"></div>


<!--  ----------- 댓글 입력 폼 ---------- -->
<form method="post" id="replyForm">
<input type="hidden" name="bseq" value="${keybvo.bseq}">
<input type="text" name="reply" id="reply">
<input type="button" id="replyBtn" value="댓글저장">
</form>


<br><br><br>
</body>
</html>



