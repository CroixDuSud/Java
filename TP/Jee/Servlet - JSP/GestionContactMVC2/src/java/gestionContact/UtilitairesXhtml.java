package gestionContact;

// ==========================================================================
// Classe UtilitairesXhtml
// --------------------------------------------------------------------------
// Utilitaires pour generer du code Xhtml specifique a l'application.
// ==========================================================================

public class UtilitairesXhtml
{

// --------------------------------------------------------------------------
// Constitution du pied de page du programme html
// --------------------------------------------------------------------------
   public static String piedPage(String message)
   {
      String sortie ="";
      sortie =  "<div>";
      sortie +=    "<br />";
      sortie +=    "<br />";
      sortie +=    "<br />";
      sortie +=    "<p id=\"message\">";
      sortie +=       message;
      sortie +=    "</p>";
      sortie += "</div>";

      return sortie;
   }
}
