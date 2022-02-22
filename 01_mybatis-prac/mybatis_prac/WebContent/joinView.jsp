<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form name="joinForm" action="join_db.jsp" method="post" onsubmit="return sendit();">
		<fieldset>
			<legend>회원가입</legend>		
			<span id = "result" style="color:red; font-weight:bold;"></span><br>
			<input name="userid" type="text" placeholder="아이디를 입력하세요">
			<input type="button" value="중복체크" onclick="checkId();">
			<br>
			<input name="userpw" type="password" placeholder="비밀번호를 입력하세요"><br>
			<input name="username" type="text" placeholder="이름을 입력하세요"><br>
			<input type="submit" value="가입하기">
		</fieldset>
	</form>
</body>
<script>
	let joinForm = document.joinForm;
	let idTag = joinForm.userid;
	let pwTag = joinForm.userpw;
	let nameTag = joinForm.username;
	let resultTag = document.getElementById("result");

	function sendit(){
		if(idTag.value == ""){
			alert("아이디를 입력하세요!");
			idTag.focus();
			return false;
		}
		
		if(resultTag.innerHTML == ""){
			alert("아이디 중복검사를 해주세요!");
			return false;
		}
		
		if(resultTag.innerHTML != "사용할 수 있는 아이디입니다." ){
			alert("아이디가 중복되었습니다.");
			idTag.focus();
			return false;
		}
		
		if(idTag.value.length<5 || idTag.value.length>12){
			alert("아이디는 5자 이상 12자 이하로 작성해주세요!");
			idTag.focus();
			return false;
		}
		
		if(pwTag.value.length == ""){
			alert("비밀번호를 입력하세요!");
			pwTag.focus();
			return false;
		}
		
		if(pwTag.value.length<8){
			alert("비밀번호는 8자 이상으로 작성해주세요!");
			pwTag.focus();
			return false;
		}
		
		if(nameTag.value == ""){
			alert("이름을 입력하세요!");
			nameTag.focus();
			return false;
		}
		return true;
	}
	
	function checkId(){
		let userid = idTag.value;
		let xhr = new XMLHttpRequest();
		xhr.open("POST","checkId_db.jsp",true);
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE){
				if(xhr.status == 200 || xhr.status == 201){
					let txt = xhr.responseText.trim();
					if(txt == "O"){
						resultTag.innerHTML = "사용할 수 있는 아이디입니다.";
					}else{
						resultTag.innerHTML = "이미 존재하는 아이디입니다.";
					}
				}
			}
		}
		xhr.send("userid="+userid)
	}
</script>
</html>