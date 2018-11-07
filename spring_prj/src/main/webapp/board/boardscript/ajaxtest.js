$(document).ready(function(){
	$("#gson").click(function(){
		$.ajax({
			url:"/gson_test",  
			type:"post",  
			//contentType: "application/json; charset=UTF8"
			//contentType:"string";,  내보낼 데이터
			//dataType:"json";,   받아드리는 데이터 타입
			data: "bseq=63",
			//data: JSON.stringfiy({"bseq":"63"}), 오브젝트 >>스트링으로 변경>>컨텐츠타입이 제이슨일경우
			success: function(res){
				alert("gson::"+res);
				console.log(res);
				var jsonObject = JSON.parse(res); //String >>>>> jsonObject
				console.log(jsonObject);	
				$.map(jsonObject, mapCallback);
				function mapCallback( v,  i) { 
					console.log(v.bseq+":::"+v.title);
				}
			}
		});
	});

	$("#resBody").click(function(){
		$.ajax({
			url:"/response_body",  
			type:"post",  
			data: "bseq=63",
			success: function(res){
				console.log(res);
				alert("Response_body"+res);
				//var jsonObject = JSON.parse(res); //String >>>>> jsonObject
				//console.log(jsonObject);	
				/* $.map(jsonObject, mapCallback);
				function mapCallback( v,  i) { 
					console.log(v.bseq+":::"+v.title); */
				//}
			}
		});
	});
});