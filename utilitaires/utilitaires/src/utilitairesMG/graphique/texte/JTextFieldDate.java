// ==========================================================================
// package utilitairesMG.graphique.texte
// --------------------------------------------------------------------------
// Classe JTextFieldDate
// --------------------------------------------------------------------------
// Zone de saisie de texte de type Date
// ==========================================================================

package utilitairesMG.graphique.texte;

import java.util.*;
import java.text.*;
import utilitairesMG.divers.*;


public class JTextFieldDate extends JTextFieldMG
{

// --------------------------------------------------------------------------
// PROPRIETE
// --------------------------------------------------------------------------
// Reference de type DateFr pour toutes les conversions (texte / Date)
// --------------------------------------------------------------------------
   private DateFr dateFr;

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
   public JTextFieldDate(int taille)
   {
      super(taille);

      dateFr = new DateFr();
   }

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Lecture du texte ecrit dans le JTextField et conversion en Date
// --------------------------------------------------------------------------
   public Date getDate() throws ParseException
   {
      Date retour;
      String texte = getText().trim();

      if (texte.length() == 0)
      {
         retour = null;
      }
      else
      {
         dateFr.set(texte);
         retour = dateFr.getTime();
      }
      return retour;
   }

// --------------------------------------------------------------------------
// Modification de la Date affichee dans la zone de texte
// --------------------------------------------------------------------------
   public void setDate(Date valeur)
   {
      dateFr.setTime(valeur);
      setText(dateFr.toString());
   }

// --------------------------------------------------------------------------
// Modification du format de la Date (par defaut : "dd/MM/yyyy")
// --------------------------------------------------------------------------
   public void setFormat(String nouveauFormat)
   {
      dateFr.setFormat(nouveauFormat);
   }
}
