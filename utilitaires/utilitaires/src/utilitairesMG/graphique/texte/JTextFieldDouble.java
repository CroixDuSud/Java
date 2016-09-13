// ==========================================================================
// package utilitairesMG.graphique.texte
// --------------------------------------------------------------------------
// Classe JTextFieldDouble
// --------------------------------------------------------------------------
// Zone de saisie de texte de type Double
// ==========================================================================

package utilitairesMG.graphique.texte;

import javax.swing.*;
import utilitairesMG.divers.*;


public class JTextFieldDouble extends JTextFieldMG
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
// ndec : nombre de decimales affichees (par defaut 2)
// zero : afficher (1) ou pas (0) les zeros non significatifs (par defaut 1)
// separ : separateur de milliers (par defaut aucun).
// --------------------------------------------------------------------------
   private int ndec = 2;
   private int zero = 1;
   private char separ = '\0';

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
   public JTextFieldDouble(int taille)
   {
      super(taille);
      setHorizontalAlignment(SwingConstants.RIGHT);
   }

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Lecture du texte ecrit dans le JTextField et conversion en Double
// --------------------------------------------------------------------------
   public Double getDouble() throws NumberFormatException
   {
      Double retour;
      String texte = getText().trim();

      if (texte.length() == 0)
      {
         retour = null;
      }
      else
      {
         retour = Conversion.chaineDouble(texte);
      }
      return retour;
   }

// --------------------------------------------------------------------------
// Modification du Double affiche dans la zone de texte
// --------------------------------------------------------------------------
   public void setDouble(Double valeur)
   {
      String texte = Conversion.doubleChaine(valeur, ndec, zero, separ);
      setText(texte);
   }

// --------------------------------------------------------------------------
// Modification du format du Double
// --------------------------------------------------------------------------
   public void setFormat(int ndec, int zero, char separ)
   {
      this.ndec  = ndec;
      this.zero  = zero;
      this.separ = separ;
   }
}
