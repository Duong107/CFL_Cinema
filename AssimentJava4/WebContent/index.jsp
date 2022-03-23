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

<body onload="active('${active}'),loadproduct()">
	<header id="head">
		<a href="http://localhost:8080/AssimentJava4/Home"><img id="logo"
			src="/AssimentJava4/Style/logo.png" alt=""></a><b id="title">VAPOR
			CHÍNH HÃNG</b>
		<div class="inputbox">
			<input type="text" name="search" id="box-search"
				placeholder="Input Text" onkeydown="loadproductby()">
			<button class="btnser" onclick="loadproductby()">
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
	<article id="art"></article>
</body>
<script>
	function loadproduct() {
		var i = document.getElementsByClassName("product-view").length;
		$.ajax({
			url : "/AssimentJava4/Load",
			type : "get",
			data : {
				soluong : i
			},
			success : function(data) {
				var row = document.getElementById("art");
				if (i > 0) {
					row.innerHTML += data;
				} else {
					row.innerHTML = data;
				}
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function loadproductby() {
		$.ajax({
			url : "/AssimentJava4/Loadbyname",
			type : "get",
			data : {
				namesxs : document.getElementById("box-search").value
			},
			success : function(data) {
				var row = document.getElementById("art");
					row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function addtocart() {
		$.ajax({
			url : "/AssimentJava4/addtocart",
			type : "get",
			success : function(data) {
				alert(data)
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
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
</script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</html>