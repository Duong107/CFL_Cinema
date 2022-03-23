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
<script>
	function removebox() {
		document.getElementById('gaga').style = "display:none";
	}

	function showbox() {
		document.getElementById('gaga').style = "display:block";
	}
</script>
</head>

<body onload="active('${active}'),loadoption()">
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
				<button formaction="/AssimentJava4/Profile" value="${idacc}"
					name="ssvip" class="ddts">
					<img src="/AssimentJava4/Style/profile.png" width="40px">
				</button>
			</form>
		</div>
	</header>
	<nav id="navadmin">
		<div class="boxselect2">
			<div class="option2" id="product">
				<a href=""><img src="/AssimentJava4/Style/product.png"
					width="40px" alt=""></a>
			</div>
			<div class="option2" id="usermanager">
				<a href=""><img src="/AssimentJava4/Style/usermanager.png"
					width="40px" alt=""></a>
			</div>
		</div>
	</nav>
	<div>
		<img src="/AssimentJava4/Style/downactive.png" id="reac"
			onclick="reactive()" alt="">
	</div>
	<article id="art">
		<div class="showpanel">
			<h2 class="xt">PRODUCT MANAGER</h2>
			<div class="onbox">
				<div class="uuus">
					<form enctype="multipart/form-data" method="post">
						<h3>Tên Sản Phẩm:</h3>
						<input type="text" name="name" class="input-text" id="a1">
						<h3>Giá Tiền:</h3>
						<input type="number" name="price" class="input-text" id="a2">
						<h3>Mô Tả 1:</h3>
						<textarea name="detail1" id="a3" cols="30" rows="10"></textarea>
						<h3>Kích Cỡ:</h3>
						<input type="text" name="size" class="input-text" id="a4">
						<h3>Hiển Thị:</h3>
						<input type="text" name="display" class="input-text" id="end-of">
						<div class="flef">
							<h3>Tối Đa Buồng Chứa:</h3>
							<input type="text" name="maxsizeml" class="input-text" id="a5">
							<h3>Dung Lượng Pin:</h3>
							<input type="text" name="pin" class="input-text" id="a6">
							<h3>Mô Tả 2:</h3>
							<textarea name="detail2" id="a7" cols="1000" rows="17"></textarea>
							<h3>Cổng Sạc:</h3>
							<input type="checkbox" value="1" name="uxi" class="" id=""><b>Type-C</b><input
								type="checkbox" value="0" name="uxi" class="" id=""><b>Micro-USB</b>
							<h3>Thương Hiệu:</h3>
							<select class="input-text" name="sds" id="kds">

							</select>
							<button class="addelement" type="button" onclick="showbox()">+</button>
						</div>
						<div class="flef-1">
							<h3>Khối Lượng:</h3>
							<input type="text" name="weight" class="input-text" id="a8">
							<h3>Hình ảnh:</h3>
							<br> <input type="file" name="igu" class="input-text domamu"
								id="of"> <label for="of" class="lbf">Select
								Image</label> <br> <br>
							<button class="btn-uis" formaction="/AssimentJava4/admin/insert">Thêm
								Mới</button>
							<button class="btn-uis" formaction="/AssimentJava4/admin/update">Cập Nhật</button>
					</form>

				</div>
			</div>
		</div>
		</div>
		<button class="list-product" onclick="showlist()">
			<img class="img-list"
				src="https://img.icons8.com/material-outlined/48/ffffff/list.png" />
		</button>
		<div class="cr-br" id="gaga">
			<h3>Tên Thương Hiệu</h3>
			<input type="text" id="newbrand"> <br> <br>
			<button onclick="addoption()">Thêm</button>
			<button onclick="removebox()">Hủy</button>
		</div>
	</article>
</body>
<script>
	function names() {
		alert(document.getElementById("kds").value)
	}
	function loadoption() {
		$.ajax({
			url : "/AssimentJava4/Loadoption",
			type : "get",
			success : function(data) {
				var row = document.getElementById("kds");
				row.innerHTML = data;
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function addoption() {
		$.ajax({
			url : "/AssimentJava4/addbrand",
			type : "get",
			data : {
				namebrand : document.getElementById("newbrand").value
			},
			success : function(data) {
				alert(data)
				loadoption()
				removebox()
				document.getElementById("newbrand").value = ""
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function select(id) {
		$.ajax({
			url : "/AssimentJava4/select",
			type : "get",
			data : {
				id : id
			},
			success : function(data) {
				const t = data.split('|');
				document.getElementById("a1").value = t[0]
				document.getElementById("a2").value = t[1]
				document.getElementById("a3").value = t[2]
				document.getElementById("a4").value = t[3]
				document.getElementById("end-of").value = t[4]
				document.getElementById("a5").value = t[5]
				document.getElementById("a6").value = t[6]
				document.getElementById("a7").value = t[7]
				document.getElementById("a8").value = t[8]
				removex()
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function deletes(id) {
		$.ajax({
			url : "/AssimentJava4//admindeletepro",
			type : "get",
			data : {
				id : id
			},
			success : function(data) {
				removex()
				showlist()
				alert(data)
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	}
	function showlist() {
		$.ajax({
			url : "/AssimentJava4/LoadTableProduct",
			type : "get",
			success : function(data) {
				var row = document.getElementById("art");
				row.innerHTML += data;
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