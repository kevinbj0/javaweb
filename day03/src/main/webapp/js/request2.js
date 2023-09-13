

function hi(){
	let NameTag = document.getElementById("username");
	let name = NameTag.value;
	window.location.href="/day_03/hi?name="+ name;
}