var _kategori = document.getElementById("_kategori")

function gizliYap (val) {
	val.style.display = "none"
}

function gorunurYap(val) {
	val.style.display = "block"
}

window.onload = function () {
	gizliYap(_kategori)
}

var _kategori_selectbox =document.getElementById("kategori-selectbox")

_kategori_selectbox.onchange = function () {
	
	if ( _kategori_selectbox.value == "diger" ) {
		gorunurYap(_kategori)
		gizliYap(_kategori_selectbox)
	}
}

