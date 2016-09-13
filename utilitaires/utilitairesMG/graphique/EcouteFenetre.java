// ==========================================================================
// package utilitairesMG.graphique
// --------------------------------------------------------------------------
// Classe EcouteFenetre
// -------------------------------------------------------------------------- 
// Cette classe qui herite de WindowAdapter se contente de surcharger la 
// methode windowClosing()
// ==========================================================================

package utilitairesMG.graphique;

import java.awt.event.*;    // Pour les �v�nements (WindowEvent)

public class EcouteFenetre extends WindowAdapter
{
   public void windowClosing(WindowEvent e)
   {
      System.exit(0);
   }
}