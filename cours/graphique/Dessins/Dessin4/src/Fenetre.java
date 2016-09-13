// ==========================================================================
// Classe Fenetre                                         Application Dessin4
// ==========================================================================

import javax.swing.*;
import java.awt.*; 
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame
{
   private Panneau panneauFond;

   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());        

// -------------------------------------------------------------------------- 
// Creation de l'objet panneauFond :
// -------------------------------------------------------------------------- 
      panneauFond = new Panneau();
      panneauFond.setBackground(Color.white);
      panneauFond.setForeground(Color.magenta);
      panneauFond.setPreferredSize(new Dimension(300, 200));
      
// --------------------------------------------------------------------------
// Ajout du panneau de fond a la fenetre :
// --------------------------------------------------------------------------
      getContentPane().add(panneauFond);

      pack();
      setVisible(true);
   }
}