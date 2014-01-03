//------------------------------------------------------------------------------
/*Script para cria√ß√£o do avatar
 *      Usado quando o usu·rio for se cadastra
 *      @author: Ytrio salmito.
 *      @date: 9/04/2013
 *      @time: 20:28
 *      @version: 1.2v
 **/
//------------------------------------------------------------------------------
//FunÁ„o para carrega a imagem
function sendImage() {
    //Caminho e propiedade da imagem
    PathImage      =  formCadastro.Path_Image.value;
    LoadUserAvatar =  document.getElementById('Id_Img');
  //Carrega a imagem em disco
    //Verifica se a foto foi selecionada
    if (formCadastro.Path_Image.value != '') {
    	var ImgValue = "";
        var index = 0;
        /*Obtem o nome da completa*/ 
        while(PathImage[12 + index]!='.') ImgValue += PathImage[ (12) + (index++) ];
    	//Tamanho da imagem
        LoadUserAvatar.style.height = '180px';
        LoadUserAvatar.style.width  = '180px';
		        LoadUserAvatar.setAttribute('src', 'Imagens/' + ImgValue+'.'
				+ PathImage[PathImage.length - 3] 
                + PathImage[PathImage.length - 2] 
                + PathImage[PathImage.length - 1]);
		//bordas da imagem
        LoadUserAvatar.style.border = '10px solid #FFF';
        LoadUserAvatar.style.boxShadow = '5px 5px 10px #000';
    } else  {
    	window.alert("Selecione uma imagem");
    } 
    // fim do if
}//Fim da fun√ß√£o enviar imagem
//-----------------------------------------------------------------------------