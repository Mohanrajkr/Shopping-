function productvalidate()
{
var productname=document.getElementById('productname');
var prize=document.getElementById('prize');
var quantity=document.getElementById('quantity');
var description=document.getElementById('description');



if (notEmpty(productname, "Productname Should not be empty")) {
	if (isAlphabet(productname, "Please enter only letters for Productname")) {
		if(notEmpty(prize,"Prize should not be empty")){
			if(isNumeric(prize,"Please enter only number of Prize")){	
				if(notEmpty(quantity,"Quantity should not be empty")){
					if(isNumeric(quantity,"Please enter only number of Quantity")){	
						if (notEmpty(description, "Description Should not be empty")) {
							if (isAlphabet(description, "Please enter only letters for Description")) {	
								return true;
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