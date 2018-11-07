<%@page import="com.biz.board.BoardReplyVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.biz.board.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertBoard</title>
<!-- <style></style>
<link rel="stylesheet" href="/css/my.css"> -->
<script src="https://code.jquery.com/jquery-3.3.1.js?ver=1151"></script>
<script>
var bseq =0;
$(document).ready(getReplySelect);

function getReplySelect() {
//	var queryString = $("#replyList").serializa();
		bseq=$("#bseq").val();
		$.ajax({
			url:"/replyselect",  
			type:"post",  
			data: "bseq="+bseq ,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success: 
				successRun
 		});
	}
	
function successRun(res){
	console.log("ddddddd"+ res)
	$("#replyList").empty()
	//var jsonObject = JSON.parse(res);
	console.log(res);
	
	htmlStr = "";
	htmlStr += "<ul>";
	$.map(res, mapCallback);
	function mapCallback( v,  i) { 
		htmlStr += "<li><font size='1pt' color='#bbbbbb'>"+decodeURIComponent(v.userId)+"&nbsp:&nbsp&nbsp;</font>";
		htmlStr += ""+v.reply+"&nbsp&nbsp&nbsp&nbsp;";
		htmlStr += "<font size='1pt' color=''#bbbbbb'>"+v.regDate+"</font>";
		htmlStr += "<a href='#' onclick='reUpdate()'><font id="+v.rseq+" color='red'>[수정]</font></a>&nbsp&nbsp&nbsp;";
		htmlStr += "<a href='#' onclick=\"replyDelete(\'"+v.rseq+"\')\"><font color='red'>[삭제]</font></a></li>";
	}
	htmlStr += "</ul>";
	$("#replyList").html(htmlStr); 
}




function buttonClick(url){
	if(url=="list"){		
	location.href="/list";
	}else if(url=="update"){
	document.myForm.action="/boardUpdate";
//	document.myForm.method="get"
    document.myForm.submit();
	}else if(url=="delete"){
	document.myForm.action="/boardDelete";
    document.myForm.submit();
	}
}


function replyUpload(){
//	var bseq = ("#bseq").val();
	var replyText = $("#replyText").val();
	$.ajax({
		url:"/replyinsert",  
		type:"post",  
		data: "bseq="+bseq+"&replyText="+replyText ,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: 
				//alert("뎃글 등록이 완료되었습니다.");
				//getReplySelect
				//successRun(resObject);
				successRun
		
	}); 
	$("#replyText").val("");
}

function replyDelete(rseq){
	var checking = confirm("정말 삭제하시겠습니까?");
	if(checking){
	$.ajax({
		url:"/replydelete",  
		type:"post",  
		data: "bseq="+bseq+"&rseq="+rseq,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: 
				//alert("뎃글 등록이 완료되었습니다.");
				//getReplySelect
				//successRun(resObject);
				successRun
		
	});
	}
}

$('.formfield a').click(function() {         
    fieldType=$('.formfield a').fieldValue();
    alert(fieldType);
});

function reUpdateSend(){
	var replyText = $("#replyText").val(); 
	
}




</script>
<%-- <%
BoardVO vo = new BoardVO();
vo=(BoardVO)request.getAttribute("keybvo"); 
ArrayList<BoardReplyVO> rlist = new ArrayList<BoardReplyVO>();
rlist=(ArrayList<BoardReplyVO>)request.getAttribute("keyRlist");

String userId=vo.getUserid();
String regDate=vo.getRegdate();
String title=vo.getTitle();
String content = vo.getContents();

%> --%>
</head>
<body>
<h1>Board Form</h1>
<hr>
<form id="myForm" name="myForm" method="post" >
	<input type="hidden" id="bseq" name="bseq" value="${select.bseq}">
	<table class="darkTable" id="board" name="board">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>
					${select.bseq}
				</td>
				
				<td>
					글쓴이=${select.userid}
				</td>
				<td>
					작성일자=${select.regdate}
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title" value="${select.title}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents" cols="30" rows="5">${select.contents}</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input type="file" id="ufile" name="ufile"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<button type="button" id="update" onclick="buttonClick('update')">수정</button>
				<button type="button" id="delete" onclick="buttonClick('delete')">삭제</button>
				<button type="button" id="list" onclick="location.href='/list'">목록보기</button>
				<input type="reset" value="reset"></th>
			</tr>
			
		</tbody>
	</table>
</form>

<form id="replyinsert" class="formfield">
<br><hr>
	<input type="text" id="replyText" name="replyText">
	<%-- 	<input type="hidden" id="reBseq" name="reBseq" value=<%=vo.getBseq() %>> --%>
	<button type="button" id="replyUp" onclick="replyUpload()" >뎃글달기</button>  
	
<br><hr>

	  <div id="replyList">
	</div>       
</form>

</body>
</html>