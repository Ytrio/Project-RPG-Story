var reverse = true;
function loadingAbout(){
    var xmlhttp;
    var url = "about.html";
    if(window.XMLHttpRequest){
       //código para IE7+,Firefox,Chrome,Opera,Safira
       xmlhttp = new XMLHttpRequest(); 
    } else {
        //Código para IE5,IE6..
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    //função anônima para verificar o status atual da requisição.
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if (reverse == true) document.getElementById("msgSobre").style.display='block';
            else document.getElementById("msgSobre").style.display='none';
            document.getElementById("msgSobre").innerHTML=xmlhttp.responseText;
            reverse=!reverse;
        }
        
    }
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}

