window.onload = initPage;

function initPage() {
//	alert("start");
  var pictures =  document.getElementById("smallPic").getElementsByTagName("img");
  for (var i=0; i<pictures.length; i++) {
    var picture = pictures[i];
//    alert(picture)
    picture.onclick = showPicture;
  }
}

function showPicture() {
	  var selectedPic = this;
//	  alert(selectedPic);
	  
	  document.getElementById("bigPic").src = this.src;
	      
	}