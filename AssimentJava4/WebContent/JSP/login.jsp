<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans&family=Josefin+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/AssimentJava4/Style/login.css">
</head>

<body>

	<div class="ctn" id="login-box">
		<div class="login-box">
			<form method="post">
				<h2>ĐĂNG NHẬP</h2>
				<h4>Tên đăng nhập:</h4>
				<input type="text" name="user" class="txtf">
				<h4>Mật khẩu:</h4>
				<input type="password" name="pass" class="txtf"> <br> <br>
				<input type="checkbox" name="" class="ckf" id=""><b>Ghi
					Nhớ Tài Khoản?</b> <br> <br> <br>
				<button class="btn-login" formaction="/AssimentJava4/Login/submit">Đăng
					Nhập</button>
				<br> <br> <a class="link-login" id="rxs" href="">Quên
					mật khẩu?</a> <br> <br> <br> <br> <br>
			</form>
			<button class="link-login" onclick="loadregister()">Bạn
				chưa có tài khoản ? Đăng Ký</button>
		</div>

	</div>
</body>
<script>
	function loadregister() {
		$.ajax({
			url : "/AssimentJava4/register",
			type : "get",
			success : function(data) {
				var row = document.getElementById("login-box");
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function registeruser() {
		$.ajax({
			url : "/AssimentJava4/submitregister",
			type : "get",
			data : {
				username : document.getElementById("us").value,
				password : document.getElementById("ps").value,
				fullname : document.getElementById("fn").value,
				email : document.getElementById("em").value,
				phone : document.getElementById("ph").value,
			},
			success : function(data) {
				alert(data);
				window.location.href ="/AssimentJava4/Profile"
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function loadlogin() {
		$.ajax({
			url : "/AssimentJava4/Profile",
			type : "get",
			success : function(data) {
				var row = document.getElementById("login-box");
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
</script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</html>