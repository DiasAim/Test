
function getReg(){
		console.log($('#Fname').val());
		console.log($('#Lname').val());
	console.log($('#email').val());
		$.ajax  ({
			url : 'RegServlet',
			data:{
				Fname:$('#Fname').val(),
				Lname: $('#Lname').val(),
				Username:$('#Username').val(),
				password:$('#password').val(),
				email:$('#email').val()
			},
			type: "GET",
			success : function() {
				console.log("successful In get val");

			}
		});
	
}
