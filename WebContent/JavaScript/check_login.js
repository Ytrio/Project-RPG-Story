/*  Espera a página ser carregada
    Para depois executa a função de 
    checagem de usuário
*/
    //função de checagem de login
    function checkLoginVoid() {
        
         /*cria as variávels [ID_login],[ID_Senha],[Div_login] que recebem respectivamente os valores dos elementos de mesmo nome*/
         ID_Login  = document.getElementById('id_login');
         ID_Senha  = document.getElementById('id_senha');
         Div_Login = document.getElementById('divLogin'); 
         
         /*verifica se o campo usuário ou senha estão vázio*/
         if(document.formlogin.userlogin.value== '' || 
            document.formlogin.usersenha.value== '') {
                Div_Login.style.height="140px";
         } 
         
         /*verifica se o campo login está vázio*/
         if(document.formlogin.userlogin.value=='') {
                ID_Login.innerHTML = "Informe um usuário!";
                document.formlogin.userlogin.focus();
              return false;
         } else ID_Login.innerHTML='';
         /*verifica se o campo senha está vázio*/
         if(document.formlogin.usersenha.value==''){
                ID_Senha.style.marginLeft='77px';
                ID_Senha.innerHTML = "Informe uma senha";
                document.formlogin.usersenha.focus();
              return false;  
         } else ID_Senha.innerHTML='';
         
        //em caso de sucesso retorna true!
        return true;
    }

