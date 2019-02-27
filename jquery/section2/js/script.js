$(function () {

	$("#form").submit(function(event){
		var name = $("#name").val();
		var password = $("#password").val();
		var message = $("#message").val();
		var checkbox = $("checkbox").is(":checked");

		validateName(name,event);
		validatePassword(password,event);
		validateMessage(message,event);


		if(!checkbox){
			$("#checkbox-feedback").text("please check the box");
			event.preventDefault();
		}else{
			$("#checkbox-feedback").text("");
		}
	});
		
});
function validateName(value,event){
	if(!isValidField(value)){
		$("#name-feedback").text("please enter a valid name");
		event.preventDefault();
	}else{
		$("#name-feedback").text("");
	}
}

function isValidField(value){
	return value.trim().length >3;
}
function validatePassword(value,event){
	if(!isValidPassword(value)){
		$("#password-feedback").text("please enter a valid password");
		event.preventDefault();
	}else{
		$("#password-feedback").text("");
	}
}
function isValidPassword(value){
	return value.trim().length >=5;
}
function validateMessage(value,event){
	if(!isValidField(value)){
		$("#message-feedback").text("please enter a valid message");
		event.preventDefault();
	}else{
		$("#message-feedback").text("");
	}
}

