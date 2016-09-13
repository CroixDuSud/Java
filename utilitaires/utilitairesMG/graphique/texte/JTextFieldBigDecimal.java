// ==========================================================================
// package utilitairesMG.graphique.texte 
// --------------------------------------------------------------------------
// Classe JTextFieldBigDecimal                           
// --------------------------------------------------------------------------
// Zone de saisie de texte de type BigDecimal
// ==========================================================================

package utilitairesMG.graphique.texte;

import javax.swing.*;
import java.math.*;
import utilitairesMG.divers.*;
 

public class JTextFieldBigDecimal extends JTextFieldMG
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
   public JTextFieldBigDecimal(int taille)
   {
      super(taille);
      setHorizontalAlignment(SwingConstants.RIGHT);
   }

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Lecture du texte ecrit dans le JTextField et conversion en BigDecimal
// --------------------------------------------------------------------------
   public BigDecimal getBigDecimal() throws NumberFormatException
   {
      BigDecimal retour;
      String texte = getText().trim();
      
      if (texte.length() == 0)
      {
         retour = null;
      }
      else
      {
         retour = new BigDecimal(Conversion.chaineDouble(texte));
      }
      return retour;
   }

// --------------------------------------------------------------------------
// Modification du BigDecimal affiche dans la zone de texte
// --------------------------------------------------------------------------
   public void setBigDecimal(BigDecimal valeur)
   {
      String texte = Conversion.doubleChaine(valeur.doubleValue(), ndec, zero, separ);
      setText(texte);
   }
   
// --------------------------------------------------------------------------
// Modification du format du BigDecimal
// --------------------------------------------------------------------------
   public void setFormat(int ndec, int zero, char separ)
   {
      this.ndec  = ndec;
      this.zero  = zero;
      this.separ = separ;
   }
}
