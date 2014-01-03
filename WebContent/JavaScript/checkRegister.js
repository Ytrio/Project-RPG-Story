function CheckRegisters(form) {
	
	/*Obtem o ID de todos os elementos*/
	styleP  = document.getElementById("erro1");
	styleP2 = document.getElementById("erro2");
	styleP3 = document.getElementById("erro3");

	/* verifica se o campo usuário está está preenchido! */
	if (form.InputUserName.value.trim() == "") {
		styleP.style.display = "block";
		document.getElementById("erro1").innerHTML = "Usuário Invalido";
		form.InputUserName.focus();
		return false;
		/* Verifica se a senha está preenchida */
	} else {
		styleP.style.display = "none";
	}

	/* Verifica se o comprimento do nome está incorreto */
	if (form.InputUserName.value.length <= 10) {
		styleP.style.display = "block";
		document.getElementById("erro1").innerHTML = "Comprimento do nome incorreto ";
		form.InputUserName.focus();
		return false;
		/* Verifica se o comprimento da senha está incorreto */
	} else {
		styleP.style.display = "none";
	}

	if (form.InputPassword.value.trim() == "") {
		styleP2.style.display = "block";
		document.getElementById("erro2").innerHTML = "O campo senha precisa ser preenchido!";
		form.InputPassword.focus();
		return false;
		/* Verifica se o campo confirm senha está preenchida */
	} else {
		styleP2.style.display = "none";
	}

	if (form.InputPassword.value.length <= 10) {
		styleP2.style.display = "block";
		document.getElementById("erro2").innerHTML = "Comprimento da senha incorreto";
		form.InputPassword.focus();
		return false;
		/* Verifica se o comprimento da contra senha está incorreto */
	} else {
		styleP2.style.display = "none";
	}


	if (form.InputConfirmPassword.value.trim() == "") {
			styleP3.style.display = "block";
			document.getElementById("erro3").innerHTML = "O campo confirma precisa ser preenchido!";
			form.InputConfirmPassword.focus();
		return false
	} else {
		styleP3.style.display = "none";
	}
	
	/* Verifica se o comprimento da contra senha está incorreto */
	if (form.InputConfirmPassword.value.length <= 10) {
			styleP3.style.display = "block";
			document.getElementById("erro3").innerHTML = "Comprimento da Contra Senha incorreto";
			form.InputConfirmPassword.focus();
		return false;
	} else {
		styleP3.style.display = "none";
	}

	/* verifica se as senhas são diferentes */;
	if (form.InputPassword.value != form.InputConfirmPassword.value) {
			styleP3.style.display = "block";
			document.getElementById("erro3").innerHTML = "Senhas Diferente!";
			form.InputConfirmPassword.focus();
		return false;
	}

	return true;
}