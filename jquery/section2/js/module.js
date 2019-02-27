var people = [];
$(function(){
	$("#peopleModule").find("button").on("click",function(){
		var inputField = $("#peopleModule").find("input:text");
		var name = $(inputField).val();
		if(name.trim().length > 0){
			people.push(name);
			$("#peopleModule").find("ul").append("<li>"+name+"</li>");
		}	

		$(inputField).val("");
	})

	$("#peopleModule").delegate("ul li","click",function(){
		var index = $("#peopleModule").find("ul").find("li").index(this);
		people.splice(index,1);
		$(this).remove();
	})

})
