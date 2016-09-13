// ==========================================================================
// package utilitairesMG.jee
// --------------------------------------------------------------------------
// Classe Xhtml
// --------------------------------------------------------------------------
// Cette classe contient quelques methodes statiques pour generer des
// des morceaux de code Xhtml.
// ==========================================================================

package utilitairesMG.jee;

import java.util.Vector;

public class Xhtml
{
   
// --------------------------------------------------------------------------
// Constitution du DOCTYPE du programme html
// --------------------------------------------------------------------------
// pour xhtml, mettre :
//    retour = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" ";
//      retour += "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">";
// --------------------------------------------------------------------------
   public static String docType()
   {
      String retour;
      retour = "<!DOCTYPE html>";
      return retour;
   }

// --------------------------------------------------------------------------
// Constitution de l'entete du programme html (sans javascript)
// --------------------------------------------------------------------------
   public static String head(String titre)
   {
      String entete;

      entete =     "<head>";
      entete +=       "<title>" + titre + "</title>";
      entete +=       "<meta http-equiv=\"Content-Type\" ";
      entete +=             "content=\"text/html; charset=utf-8\" />";
      entete +=       "<link rel=\"stylesheet\" ";
      entete +=             "type=\"text/css\" ";
      entete +=             "href=\"miseEnPage.css\" />";
      entete +=    "</head>";

      return entete;
   }
   
// --------------------------------------------------------------------------
// Constitution de l'entete du programme html (avec javascript)
// --------------------------------------------------------------------------
   public static String head(String titre, String tabScript[])
   {
      String entete;
      
      entete =     "<head>";
      entete +=       "<title>" + titre + "</title>";
      entete +=       "<meta http-equiv=\"Content-Type\" ";
      entete +=             "content=\"text/html; charset=utf-8\" />";
      entete +=       "<link rel=\"stylesheet\" ";
      entete +=             "type=\"text/css\" ";
      entete +=             "href=\"miseEnPage.css\" />";

      for(int i = 0; i < tabScript.length; i++)
      {
         entete += "<script src=\"" + tabScript[i] +
                   "\" type=\"text/javascript\">";
         entete += "</script>";
      }

      entete +=    "</head>";

      return entete;
   }

// --------------------------------------------------------------------------
// Constitution d'un couple <label><input type="text"
// --------------------------------------------------------------------------
   public static String labelInputText(String texteLabel,
                                       String idInput,
                                       String nameInput,
                                       String valueInput,
                                       int sizeInput)
   {
      String sortie;
      sortie =  "<label for=\"" + idInput + "\">" + texteLabel + "</label>";
      sortie += "<input type=\"text\" ";
      sortie +=        "name=\"" + nameInput + "\" ";
      sortie +=        "value=\"" + valueInput + "\" ";
      sortie +=        "size=\"" + sizeInput + "\" ";
      sortie +=        "maxlength=\"" + sizeInput + "\" ";
      sortie +=        "id=\"" + idInput + "\" />";

      return sortie;
   }

// --------------------------------------------------------------------------
// Constitution d'un couple <label><select>
// --------------------------------------------------------------------------
   public static String labelSelect(String texteLabel,
                                    String idSelect,
                                    String nameSelect,
                                    Integer valueSelect,
                                    Vector<Integer> vSelect)
   {
      String sortie;

      sortie =  "<label for=\"" + idSelect + "\">" + texteLabel + "</label>";
      sortie += "<select name=\"" + nameSelect + "\" ";
      sortie +=         "id=\"" + idSelect + "\">";

      if (valueSelect == null)
      {
         sortie +=      "<option selected=\"selected\"></option>";
      }
      else
      {
         sortie +=      "<option></option>";
      }

      for(int i = 0; i < vSelect.size(); i++)
      {
         if ((valueSelect != null) &&
             (vSelect.elementAt(i).compareTo(valueSelect) == 0))
         {
            sortie +=  "<option selected=\"selected\">" + vSelect.elementAt(i);
            sortie += "</option>";
         }
         else
         {
            sortie +=  "<option>" + vSelect.elementAt(i);
            sortie += "</option>";
         }
      }
      sortie += "</select>";

      return sortie;
   }

// --------------------------------------------------------------------------
// Constitution d'un couple <label><input type="text"
// --------------------------------------------------------------------------
   public static String radioLabel(String texteLabel,
                                   String idRadio,
                                   String nameRadio,
                                   String valueRadio,
                                   boolean checked)
   {
      String sortie;
      sortie  = "<input type=\"radio\" ";
      sortie +=        "name=\"" + nameRadio + "\" ";
      sortie +=        "value=\"" + valueRadio + "\" ";
      sortie +=        "id=\"" + idRadio + "\" ";
      if (checked) sortie +=     "checked=\"checked\" ";
      sortie += "/>";

      sortie +=  "<label for=\"" + idRadio + "\">" + texteLabel + "</label>";
      return sortie;
   }
}
