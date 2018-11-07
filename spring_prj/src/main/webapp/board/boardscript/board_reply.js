
function successRun(res){

	mapCallback(value, index);
	
}

function replyIsertBtn(replyText){
	if(replyText!=null || replyText.equals(replyText))
	$.ajax({
		url:"/replyinsert",  
		type:"get",  
		data: "reList="+reList ,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: successRun, 
	 	
		/*	success: function(){action}, try
		error:function(){action},	 catch
		complete:function(){action}  finally*/
	});
	
	
}




function reply () {
	var vGubun = $("#searchGubun").val();
	var vStr = $("#searchStr").val();

	$.ajax({
		url:"/boardreply",  
		type:"get",  
		data: "reList="+reList ,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: successRun, 
	 	
		/*	success: function(){action}, try
		error:function(){action},	 catch
		complete:function(){action}  finally*/

	});
}
function mapCallback(value, index) { 
	htmlStr +="<ul> <% for(int i=0; i<rlist.size(); i++) { %> <li>"
	htmlStr += "<font size='1pt' color='#bbbbbb'><%=rlist.get(i).getUserId()%></font>"
	htmlStr += "<font size='1pt' color='#bbbbbb'><%=rlist.get(i).getRegDate()%></font>"
	htmlStr += "<%=rlist.get(i).getReply()%> "
	htmlStr += "<font color='red'><b><a href=''>[수정]</a></b></font><font color='red'><b><a href=''>[삭제]</a></b></font>"
	htmlStr += "</li> <% } %> </ul>"	
}


