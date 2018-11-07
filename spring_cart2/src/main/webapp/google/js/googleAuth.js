function myOnLoad(){
	//gapi.auth2.GoogleAuth <return Object type
	gapi.load('auth2', function() { 
		var googleAuth=gapi.auth2.init(
				{client_id: '478571279368-k78fvmdai327j2g9nr0agii41ioipola.apps.googleusercontent.com'}
				);
	googleAuth.then(success,fail);
	});
}

function success(){
	console.log("gapi.Load success");
}

function fail(){
	console.log("gapi.Load fail");
}