<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=DM+Sans&family=Josefin+Sans:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/AssimentJava4/Style/index.css">
<script src="/AssimentJava4/Style/index.js"></script>
</head>

<body onload="active('${active}')">
	<header id="head">
		<a href="http://localhost:8080/AssimentJava4/Home"><img id="logo"
			src="/AssimentJava4/Style/logo.png" alt=""></a><b id="title">VAPOR
			CHÍNH HÃNG</b>
		<div class="inputbox">
			<input type="text" name="search" id="box-search"
				placeholder="Input Text">
			<button class="btnser">
				<img id="iconsearch" src="/AssimentJava4/Style/search.png" alt="">
			</button>
		</div>
		<div>
			<form method="post" id="sps">
				<button formaction="/AssimentJava4/Profile" value="${idacc}" name="ssvip" class="ddts">
					<img src="/AssimentJava4/Style/profile.png" width="40px">
				</button>
			</form>
		</div>
	</header>
	<nav id="nav">
		<div class="boxselect">
			<div class="option" id="home">
				<a href="/AssimentJava4/Home"><img
					src="/AssimentJava4/Style/home.png" width="40px" alt=""></a>
			</div>
			<div class="option" onclick="showlist()" id="menu">
				<img src="/AssimentJava4/Style/menu.png" width="40px"
					alt="">
			</div>
			<div class="option" onclick="loadcart()" id="cart">
				<img src="/AssimentJava4/Style/cart.png" width="40px" alt="">
			</div>
			<div class="option" id="contact">
				<a href=""><img src="/AssimentJava4/Style/contact.png"
					width="40px" alt=""></a>
			</div>
			<div class="option" id="end" onclick="deactive()">
				<img src="/AssimentJava4/Style/down.png" width="40px" alt="">
			</div>
		</div>
	</nav>
	<div>
		<img src="/AssimentJava4/Style/downactive.png" id="reac"
			onclick="reactive()" alt="">
	</div>
	<article id="art">
	 <div class="profile">
            <h2>Your Profile</h2>
            <b>Fullname</b>
            <input type="text" name="fullname" placeholder="fullname" id="fn" value="${E.fullname}" class="input-text">
            <br>
            <br>
            <br>
            <b>Password</b>
            <input type="password" name="password" placeholder="password" id="ps" value="${E.password}" class="input-text">
            <br>
            <br>
            <br>
            <b>PhoneNumber</b>
            <input type="text" name="phonenumber" placeholder="phonenumber" id="ph" value="${E.phonenumber}" class="input-text">
            <br>
            <br>
            <br>
            <b>Email</b>
            <input type="text" name="emailxx" placeholder="" id="em" value="${E.email}" class="input-text">
            <br>
            <br>
            <br>
            <b>Address</b>
            <input type="text" name="locationdetail" id="ad" placeholder="address" value="${E.locationdetail}" class="input-text">
            <br>
            <br>
            <br>
            <br>
            <br>
            <button class="btngreen" onclick="update()">Cập Nhật</button>
            <br>
            <br>
           <form action="/AssimentJava4/logout" method="post">
            <button class="btnred">Đăng Xuất</button>
           </form>
        </div>
	</article>
</body>
<script>
	function loadproductdetail(id) {
		$.ajax({
			url : "/AssimentJava4/DetailProduct",
			type : "get",
			data : {
				prid : id
			},
			success : function(data) {
				var row = document.getElementById("art");
				row.innerHTML = data;

			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		document.getElementById("home").style.boxShadow = "none";
		document.getElementById("menu").style.boxShadow = "none";
		document.getElementById("cart").style.boxShadow = "none";
		document.getElementById("contact").style.boxShadow = "none";
	}
	
	function loadcart() {
		$.ajax({
			url : "/AssimentJava4/LoadCart",
			type : "get",
			success : function(data) {
				var row = document.getElementById("art");
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
		document.getElementById("home").style.boxShadow = "none";
		document.getElementById("menu").style.boxShadow = "none";
		document.getElementById("cart").style.boxShadow = "0 0 5px";
		document.getElementById("contact").style.boxShadow = "none";
	}
	function update() {
		$.ajax({
			url : "/AssimentJava4/UpdateUser",
			type : "get",
			data : {
				password : document.getElementById("ps").value,
				fullname : document.getElementById("fn").value,
				email : document.getElementById("em").value,
				phone : document.getElementById("ph").value,
				address: document.getElementById("ad").value
			},
			success : function(data) {
				alert(data);
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