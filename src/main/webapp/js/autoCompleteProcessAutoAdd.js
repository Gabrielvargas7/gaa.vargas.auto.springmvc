window.onload = initPage;

function initPage() {
	var host = window.location.host
	var protocol = window.location.protocol;
   	var hostname = window.location.hostname;
   	// check is running on the local computer or server
   	if (hostname="localhost")
   	{
	   	var fullhostname = window.location.pathname;
		var end = fullhostname.search("/");
		if (end="0")
		{
			fullhostname = fullhostname.substring(1,fullhostname.length);
			end = fullhostname.search("/");
		}
		var start = 0;
		var extraurl =  fullhostname.substring(start, end);
	   	fullurl = protocol+ "//" +host+ "/"+extraurl+"/";
   	}else 
   	{
   		fullurl = protocol+ "//" +host+ "/";
   	}
	$("#brand").autocomplete(fullurl+"ajaxAutoCompleteAutoAdd.htm",{extraParams:{value:"brand"}});
	$("#model").autocomplete(fullurl+"ajaxAutoCompleteAutoAdd.htm",{extraParams:{value:"model"}});
	$("#year").autocomplete(fullurl+"ajaxAutoCompleteAutoAdd.htm",{extraParams:{value:"year"}});
	
	
    var brand = document.getElementById("brand");
    addEventHandler(brand,"blur",setBrandSession);
    brand.focus();

}

function setBrandSession(e)
{
    var me = getActivatedObject(e);
    var mytitile = me.title; // local variable
  
    brandrequest = createRequest(); // Global variable
    if (brandrequest == null)
        alert("Unable to create request");
    else
    {
	    var textvalue = document.getElementById(mytitile).value;
	    var url = fullurl+"ajaxAutoCompleteAutoAddSetSession.htm";
	   // alert(url);	
	    	
	    var thevalue = escape(textvalue);
	    brandrequest.onreadystatechange = showFirstnameStatus;
	    brandrequest.open("POST",url,true);
	    brandrequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    brandrequest.send("brand="+thevalue); //Posting txtname to Servlet
    }
}
function showFirstnameStatus() {
  if (brandrequest.readyState == 4) {
    if (brandrequest.status == 200) {
     //   alert(brandrequest.responseText);
    }
  }
}

