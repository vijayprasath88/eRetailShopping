

function validate(){


var x = document.getElementById("username").value;
var y = document.getElementById("password").value;


if ( x.length < 6  )
{
alert ("username should be minimum 6 characters");
return false;
}
 if( y.length <6)
{
alert("password should be minimum 6 characters");
return false;
}
 

}

function validate2(){
	
	var a = document.getElementById("user").value;
	var b = document.getElementById("pass").value;
	var c = document.getElementById("Role").value;


	if ( a.length < 6  )
	 {
	 alert ("username should be minimum 6 characters ");
	 return false;
	 }
	  if( b.length <6)
	 {
		  alert ("password should be minimum 6 characters ");
	 return false;
	 }
	  if(c != "LO" && c != "OTM"){
		  alert("Invalid Role");
		  return false;
	  }
}