
//Variaveis lógicas de validação
var verificFields = true;
var verificFields2 = true;
var changeColor;
var changeColor2;
//Função para validar campos vázios..
function checkingFieldsVoid(formCadastro) {
    
    //verifica se o campo nome está vazio!
    if (formCadastro.GetNome.value == '') {
            verificFields = false;
            //Pega o elemento HTML pelo seu ID:
            changeColor = document.getElementById("P_MudarCor");
            //Adiciona um texto ao elemento de ID especificado;
            changeColor.innerHTML = 'está informação é necessária!';
            //Mudar a cor do texto para azul
            changeColor.style.color = 'red';
            changeColor.style.marginLeft = '200px';
            changeColor.style.padding = '5px';
            document.focusForm.GetNome.focus();
            changeColor.style.display = 'block';
        return false;
        //verifica se o campo email está vazio!
    } else if(verificFields == false)
             changeColor.style.display = 'none';
    if (formCadastro.GetEmail.value == '' || formCadastro.GetEmail.value.indexOf(('@' && '.'), 0) == -1) {
             verificFields2 = false;
            //Pega o elemento HTML pelo seu ID:
            changeColor2 = document.getElementById("P_MudarCor2");
            //Adiciona um texto ao elemento de ID especificado;
            changeColor2.innerHTML = 'Seu e-mail está invalido ou campo está vázio!';
            //Mudar a cor do texto para azul
            changeColor2.style.color = 'red';
            changeColor2.style.marginLeft = '160px';
            changeColor2.style.padding = '5px';
            document.focusForm.GetNome.focus();
            changeColor2.style.display = 'block';
            // Manda o foco para o campo E-mail
            document.focusForm.GetEmail.focus();
        return false;
        //verifica se o campo senha está vazio!
        //caso o caractere não seja encontrado ele retorna (-1)..
    }  else if(verificFields2 == false)
              changeColor2.style.display = 'none';
    

    //veriifica se o campo de senha é vazio!.
    if (formCadastro.GetSenha.value == '') {
            alert("O campo senha é obrigatorio!");
            document.focusForm.GetSenha.focus();
        return false;
        //verifica se o campo confirma está vazio!
    } else if (formCadastro.GetConfirmaSenha.value == '') {
            alert("O campo confirma senha é obrigatorio!");
            document.focusForm.GetConfirmaSenha.focus();
        return false;
      // verifica se conteúdo das senha são iguais  
    } else if(formCadastro.GetSenha.value != formCadastro.GetConfirmaSenha.value) {
           alert("As senha está diferentes!");
        return false;
        
    }
    return true;
}
