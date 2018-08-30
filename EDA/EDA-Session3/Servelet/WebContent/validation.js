function validate() {
	if (!nameValidate() || !emailValidate() || !ageValidate()) {
		return false;
	}
	return true;
}

function nameValidate() {
	var regex = /^[a-zA-Z]{2,}$/;
	var first_name = document.adddetailsform.first_name;
	var last_name = document.adddetailsform.last_name;
	if (!regex.test(first_name.value)) {
		alert("First Name length should be of minimum 2 and should contain only alphabets");
		first_name.focus();
		return false;
	} else if (!regex.test(last_name.value)) {
		alert("Last Name length should be of minimum 2 and should contain only alphabets");
		last_name.focus();
		return false;
	}
	return true;
}

function emailValidate() {
	var regex = /^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/;
	if (!regex.test(document.adddetailsform.email.value)) {
		alert("Invalid email Id");
		document.adddetailsform.email.focus();
		return false;
	}
	return true;
}

function ageValidate() {
	if (document.adddetailsform.age.value < 1) {
		alert("Age Should be greater than zero:");
		document.adddetailsform.age.focus();
		return false;
	}
	return true;
}