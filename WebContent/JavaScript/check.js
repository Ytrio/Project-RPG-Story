function CheckDate(form) {
	styleP  = document.getElementById("erro1");
	if (form.GetName.value == "") {
			styleP.style.display = "block";
			document.getElementById("erro1").innerHTML = "Nome precisa ser preenchido";
			form.GetName.focus();
			return false;
	} else if (form.GetName.value.length <= 10) {
			styleP.style.display = "block";
			document.getElementById("erro1").innerHTML = "Min of 10 characteres";
			form.GetName.focus();
			return false;
	} else {
		styleP.style.display = "none";
	}

	return true;
}