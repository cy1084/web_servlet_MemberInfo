/**
 * 
 */
window.onload = function() {
	document.querySelector("input[type=submit]").onclick = function(event) {
		event.preventDefault();
		return false;
	}
	var inputText = document.querySelectorAll("input[type=text],input[type=password]");
	console.log(inputText.length);
	for (let i = 0; i < inputText.length; i++) {
		inputText[i].onclick = idConfirm;
	}

}

var idConfirm = function() {
	var idChecked = document.getElementsByName("id")[0];
	if (idChecked.title == "n") {
		alert("아이디 중복검사를 먼저 진행해주세요");
		idChecked.focus();

	}
}

function idCheck() {
	var id = document.getElementsByName("id")[0];
	console.log("입력된 id값: " + id);
	if (id.value == "") {
		alert("아이디를 반드시 입력해주신 후 중복체크해주세요");
		id.focus();
		return;
	}
	window.open("/duplicateId.do?id="+id.value, "", "width=500pxm height=600px");
}