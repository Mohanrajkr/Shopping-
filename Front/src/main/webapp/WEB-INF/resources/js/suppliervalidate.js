function suppliervalidate()
{
var suppliername=document.getElementById('suppliername');
var address=document.getElementById('address');
var mobilenumber=document.getElementById('mobilenumber');



if (notEmpty(suppliername, "Suppliername Should not be empty")) {
	if (isAlphabet(suppliername, "Please enter only letters for Suppliername")) {	
						if (notEmpty(address, "Address Should not be empty")) {
							if (isAlphabet(address, "Please enter only letters for Address")) {	
								if(notEmpty(mobilenumber,"Mobilenumber should not be empty")){
									if(isNumeric(mobilenumber,"Please enter only number of Mobilenumber")){
								return true;
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
	