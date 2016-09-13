// ==========================================================================
// package utilitairesMG.graphique.texte 
// --------------------------------------------------------------------------
// Classe JTextFieldMG                            
// --------------------------------------------------------------------------
// Classe mere des JTextField controlables (Dates, valeurs numeriques)
// ==========================================================================

package utilitairesMG.graphique.texte;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import utilitairesMG.graphique.*;
import javax.swing.plaf.basic.BasicBorders.FieldBorder;
 

public class JTextFieldMG extends JTextField
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
// Bordures de zone de saisie par defaut
// --------------------------------------------------------------------------
   private static Border borderNormal = new FieldBorder(Color.gray, 
                                                        Color.black, 
                                                        Color.lightGray, 
                                                        Color.white);
                                                        
   private static Border borderErreur = new FieldBorder(Color.gray, 
                                                        Color.black, 
                                                        Color.red, 
                                                        Color.white);

// --------------------------------------------------------------------------
// Couleurs d'affichage normal et erreur
// --------------------------------------------------------------------------
   private Color couleurNormale;
   private static Color couleurErreur = Color.red;

// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
   public JTextFieldMG(int taille)
   {
      super(taille);
      
      setDocument(new DocumentSaisieLimitee(taille));
      
      couleurNormale = getForeground();
      setBorder(borderNormal);
   }

// --------------------------------------------------------------------------
// METHODES
// --------------------------------------------------------------------------
// Passage de la bordure et de l'ecriture en couleurs normales
// --------------------------------------------------------------------------
   public void affichageNormal()
   {
      setBorder(borderNormal);
      setForeground(couleurNormale);
   }

// --------------------------------------------------------------------------
// Passage de la bordure et de l'ecriture en couleurs 'erreur'
// --------------------------------------------------------------------------
   public void affichageErreur()
   {
      setBorder(borderErreur);
      setForeground(couleurErreur);
   }
   
// --------------------------------------------------------------------------
// Modification de la bordure normale
// --------------------------------------------------------------------------
   public static void setBorderNormal(Border border)
   {
      borderNormal = border;
   }
   
// --------------------------------------------------------------------------
// Modification de la bordure 'erreur'
// --------------------------------------------------------------------------
   public static void setBorderErreur(Border border)
   {
      borderErreur = border;
   }
   
// --------------------------------------------------------------------------
// Modification de la couleur 'erreur' (qui est rouge par defaut)
// --------------------------------------------------------------------------
   public static void setCouleurErreur(Color couleur)
   {
      couleurErreur = couleur;
   }
   
// --------------------------------------------------------------------------
// Modification de la couleur normale (qui est getForeground() par defaut)
// --------------------------------------------------------------------------
   public void setCouleurNormale(Color couleurNormale)
   {
      this.couleurNormale = couleurNormale;
      setForeground(couleurNormale);
   }
}
