// ==========================================================================
// package utilitairesMG.graphique.texte
// --------------------------------------------------------------------------
// Classe JTextFieldLong
// --------------------------------------------------------------------------
// Zone de saisie de texte de type Long
// ==========================================================================

package utilitairesMG.graphique.texte;

import javax.swing.*;
import utilitairesMG.divers.*;


public class JTextFieldLong extends JTextFieldMG
{

// --------------------------------------------------------------------------
// PROPRIETE
// --------------------------------------------------------------------------
// separ : separateur de milliers (par defaut aucun).
// --------------------------------------------------------------------------
   private char separ = '\0';

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
   public JTextFieldLong(int taille)
   {
      super(taille);
      setHorizontalAlignment(SwingConstants.RIGHT);
   }

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Lecture du texte ecrit dans le JTextField et conversion en Long
// --------------------------------------------------------------------------
   public Long getLong() throws NumberFormatException
   {
      Long retour;
      String texte = getText().trim();

      if (texte.length() == 0)
      {
         retour = null;
      }
      else
      {
         retour = Conversion.chaineLong(texte);
      }
      return retour;
   }

// --------------------------------------------------------------------------
// Modification du Long affiche dans la zone de texte
// --------------------------------------------------------------------------
   public void setLong(Long valeur)
   {
      String texte = Conversion.longChaine(valeur, separ);
      setText(texte);
   }

// --------------------------------------------------------------------------
// Modification du format du Long (separateur des milliers)
// --------------------------------------------------------------------------
   public void setFormat(char separ)
   {
      this.separ = separ;
   }
}
