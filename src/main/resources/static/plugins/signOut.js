function signOut(){
	$.ajax({
		type: "GET",
		url: "/logout",
		error: function(request) {
			alert("connect failed!");
		}
	});
}