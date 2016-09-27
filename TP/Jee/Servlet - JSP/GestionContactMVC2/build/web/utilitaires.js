function cadre(chaine)
{
   var resultat ="";
   var longueur = chaine.length;
   var pc = 0;
   var dc;
   var i;

   while((chaine.charAt(pc) == ' ') && (pc < longueur))
   {
      pc++;
   }

   if (pc < longueur)
   {
      dc = longueur - 1;

      while (chaine.charAt(dc) == ' ')
      {
         dc--;
      }

      for (i = pc; i <= dc; i++)
      {
         resultat += chaine.charAt(i);
      }
   }
   return resultat;
}

/* -------------------------------------------------------------------------- */
/* La validation du formulaire consiste ici a chercher la liste des balises   */
/* de type <input>. On parcourt ensuite cette liste pour valider les zones    */
/* une a une.                                                                 */
/* -------------------------------------------------------------------------- */
/* La fonction retourne la variable booleenne retour qui sera vraie si tous   */
/* les champs sont bons.                                                      */
/* -------------------------------------------------------------------------- */
function validerForm()
{
   var retour = true;
   var expReg;
   var invalideTrouve;

   var listeBalises = document.getElementsByTagName("input");

/* -------------------------------------------------------------------------- */
/* iListe contient le numero de la zone "input" de type "text" ou "password". */
/* C'est le numero qui nous interesse pour lire dans le tableau des           */
/* expressions egulieres et des messages d'erreur.                            */
/* -------------------------------------------------------------------------- */
   var iListe = 0;

   for(var i = 0; i < listeBalises.length; i++)
   {

/* -------------------------------------------------------------------------- */
/* Les zones <input> doivent etre de type "test" ou "password".               */
/* -------------------------------------------------------------------------- */
      if ((listeBalises[i].type  == "text") ||
          (listeBalises[i].type  == "password"))
      {

/* -------------------------------------------------------------------------- */
/* Expression reguliere correspondant a la zone iListe.                       */
/* -------------------------------------------------------------------------- */
         expReg = new RegExp(tableauExpReg[iListe]);

         if (!expReg.test(cadre(listeBalises[i].value)))
         {

/* -------------------------------------------------------------------------- */
/* Ce test sert a verifier si cette zone est la premiere zone en erreur.      */
/* Si oui (retour est encore vrai), on donne le focus a cette zone, et on     */
/* affiche le message correspondant.                                          */
/* -------------------------------------------------------------------------- */
            if (retour)
            {
               listeBalises[i].focus();
               document.getElementById("message").innerHTML =
                  tableauMessages[iListe];
            }

            retour = false;

/* -------------------------------------------------------------------------- */
/* On change la classe de la zone en erreur en lui ajoutant la classe         */
/* " invalide", seulement si la zone n'a pas deja cette classe...             */
/* -------------------------------------------------------------------------- */
            invalideTrouve = listeBalises[i].className.indexOf("invalide");
            if (invalideTrouve == -1)listeBalises[i].className += " invalide";
         }
         else
/* -------------------------------------------------------------------------- */
/* La zone est bonne. Il faut lui enlever la classe " invalide".              */
/* -------------------------------------------------------------------------- */
         {
            listeBalises[i].className =
               listeBalises[i].className.replace(" invalide", "");
         }

         iListe++;
      }
   }

   return retour;
}

