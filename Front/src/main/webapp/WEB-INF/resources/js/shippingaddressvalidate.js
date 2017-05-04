function shippingaddressvalidate()
{
	var userid=document.getElementById('userid');
var username=document.getElementById('username');
var mobilenumber=document.getElementById('mobilenumber');
var email=document.getElementById('email');
var address = document.getElementById('address');
if (notEmpty(userid, "UserId Should not be empty")) {
	if (isNumeric(userid, "Please enter only letters for UserId")) {
	
if (notEmpty(username, "Username Should not be empty")) {
	if (isAlphabet(username, "Please enter only letters for Username")) {

		if(notEmpty(mobilenumber,"mobilenumber should not be empty")){
			if(isNumeric(mobilenumber,"Please enter only number of mobilenumber")){
				
		
if(notEmpty(email,"EmailId should not be empty")){
	if(emailValidator(email,"EmailId should be in format of abc@xyz.com")){
    
	if (notEmpty(address,"Address Should not be empty")) {
		if (isAlphabet(address,"Please enter Letters Only for address")) {
			return true;
		}
	}
    }
}
	}
}
			}
		}
	}
}
return false;
	}		



function notEmpty(elem, helperMsg) {
	if (elem.value.length == 0) {
		alert(helperMsg);
		elem.focus(); // set the focus to this input
		return false;
	}
	return true;
}


function isNumeric(elem, helperMsg) {
	var numericExpression = /^[0-9]+$/;
	if (elem.value.match(numericExpression)) {
		return true;
	} else {
		alert(helperMsg);
		elem.focus();
		return false;
	}
}



function emailValidator(elem, helperMsg) {
	var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if (elem.value.match(emailExp)) {
		return true;
	} else {
		alert(helperMsg);
		elem.focus();
		return false;
	}
}


function isAlphabet(elem, helperMsg) {
	var alphaExp = /^[a-z A-Z]+$/;
	if (elem.value.match(alphaExp)) {
		return true;
	} else {
		alert(helperMsg);
		elem.focus();
		return false;
	}
}
