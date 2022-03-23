function active(id) {
    if(id!=""){
    	document.getElementById(id).style.boxShadow = "0px 0px 5px";
    }
}

function deactive() {
    document.getElementById('nav').style.animation = "down 0.4s ease";
    document.getElementById('nav').style.top = "930px";
    document.getElementById('reac').style.opacity = "1";
}

function reactive() {
    document.getElementById('nav').style.animation = "up 0.4s ease";
    document.getElementById('nav').style.top = "840px";
    document.getElementById('reac').style.opacity = "0";
}

function load(link) {
    document.getElementById('img').src = link;
}

function removex() {
    var ex = document.getElementById('xx-cl');
    if (ex != null) {
        ex.remove();
    } else {
        console.log(ex);
    }
}
function checkall() {
    var length = document.getElementsByClassName("product-element").length;
    for (let index = 0; index < length; index++) {
        var e = document.getElementById('x' + index).checked;
        if (e == false) {
            document.getElementById('x' + index).checked = true;
        } else {
            document.getElementById('x' + index).checked = false;
        }
    }
}