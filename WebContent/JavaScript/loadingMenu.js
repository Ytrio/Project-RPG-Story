//Função para fazer o menu "flutuar".
var reverse = true;
function loadingFloatMenu() {
    var ActionAjax;
    var url = "login.html";
    //código para IE7+,Firefox,Chrome,Opera,Safira
    if (window.XMLHttpRequest) {
        ActionAjax = new XMLHttpRequest();
    }
    //código para IE5,IE6..
    else {
        ActionAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }

    //Função anônima para verificar se tudo está ok..
    ActionAjax.onreadystatechange = function() {
        //Verifica o status atual da requisição
        if (ActionAjax.readyState == 4 && ActionAjax.status == 200) {
            if (reverse == true)
                document.getElementById("floatLogin").style.display = "block";
            else
                document.getElementById("floatLogin").style.display = "none";
                document.getElementById("floatLogin").innerHTML = ActionAjax.responseText;
                //Inverte..
                reverse = !reverse;
        }
    }

    ActionAjax.open("GET", url, true);
    ActionAjax.send();

}
