/* -------------------------------------------------------------------------- */
/* Script specifique a l'ecran d'accueil                                      */
/* -------------------------------------------------------------------------- */

window.onload = initForm;
window.onunload = function(){};

/* -------------------------------------------------------------------------- */
/* Syntaxes alternatives pour la declaration du tableau des expressions       */
/* regulieres :                                                               */
/* -------------------------------------------------------------------------- */
/* var tableauExpReg =                                                        */
/*   new Array("^\\d{1,10}$",                                                 */
/*             "^.*$",                                                        */
/*             "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,6})+$",           */
/*             "^\\d{1,10}$",                                                 */
/*             "");                                                           */
/*                                                                            */
/* ou :                                                                       */
/*                                                                            */
/* var tableauExpReg = new Array(5);                                          */
/*                                                                            */
/* tableauExpReg[0] = new RegExp("^\\d{1,10}$");                              */
/* tableauExpReg[1] = new RegExp("^.*$");                                     */
/* tableauExpReg[2] =                                                         */
/*    new RegExp("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,6})+$");        */
/* tableauExpReg[3] = new RegExp("^\\d{1,10}$");                              */
/* tableauExpReg[4] = new RegExp("^.*$");                                     */
/* -------------------------------------------------------------------------- */



/* -------------------------------------------------------------------------- */
/* Declaration du tableau des expressions régulières de chaque zone de saisie */
/* de texte du formulaire (zones "text" ou "password")                        */
/* -------------------------------------------------------------------------- */
var tableauExpReg = new Array(1);
tableauExpReg[0] = "^\\d{1,10}$";

/* -------------------------------------------------------------------------- */
/* Declaration du tableau des messages d'erreur pour chaque zone de saisie    */
/* -------------------------------------------------------------------------- */
var tableauMessages = new Array(1);
tableauMessages[0] = "Le numéro est incorrect (ne taper que des chiffres).";

/* -------------------------------------------------------------------------- */
/* Le document html n'a qu'un formulaire. On n'utilise donc que la reference  */
/* 0 du tableau forms : document.forms[0]                                     */
/* -------------------------------------------------------------------------- */
/* Remarque : si on ecrit validerAccueil(), la fonction s'execute tout de     */
/*            suitesans attendre l'evenement onsubmit.                        */
/* -------------------------------------------------------------------------- */
function initForm()
{
   document.forms[0].onsubmit = validerAccueil;
}

function validerAccueil()
{
   var retour = true;
   var balise = document.getElementById("radio4");
   if(!balise.checked)
   {
      retour = validerForm();
   }
   return retour;
}