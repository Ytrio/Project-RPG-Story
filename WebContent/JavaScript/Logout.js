control = false;
newElement  = document.createElement('div');
newElement.style.height        = '80px';
newElement.style.width         = '120px';
newElement.style.background    = '#FFF';
newElement.style.marginLeft    = '25px';
newElement.style.border 	   = "1px solid #000";
function logOut() {

	control=!control;
	img    =   document.getElementById('ToolImg');
    link   =   document.getElementById('LinkConfig');  
    link2  =   document.getElementById('LinkAbout');
    link3  =   document.getElementById('LinkHelp');
    link4  =   document.getElementById('LinkLogOut');
    
	if(control==true)  
		newElement.style.display 	 = "block";
	
	if(control==false) 
		newElement.style.display     = "none";
	
	link.innerHTML    = "Config Acc"; 
	link2.innerHTML   = "About System";
	link3.innerHTML   = "Help  system";
	link4.innerHTML   = "Desconnect";
	
	newElement.appendChild(link);
	newElement.appendChild(link2);
	newElement.appendChild(link3);
	newElement.appendChild(link4);
	img.appendChild(newElement);

}



