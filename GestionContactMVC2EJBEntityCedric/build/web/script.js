
function checkWholeNumber()
{
    var numero = document.getElementById("numContact").value;
    var choice = document.querySelector("input[name='action']:checked").value;
    var regExp = /^[0-9]+$/;
    var envoi = true;
    
    if(!numero.match(regExp) && choice!=="list")
    {
        envoi = false;
        document.getElementById("numContact").focus();
        document.getElementsByTagName("footer")[0].innerHTML="<p>**numéro de contact invalide**</p>";
    }
    return envoi;
}