// ==========================================================================
// package animationMG      (interfaces, classes abstraites pour l'animation)
// --------------------------------------------------------------------------
// Classe Fenetre
// ==========================================================================

package animationMG;

import javax.swing.*;       // Pour JFrame, JPanel
import utilitairesMG.graphique.*;     // Pour EcouteFenetre

// ==========================================================================
// Classe Fenetre
// ==========================================================================

public class Fenetre extends JFrame
{
   private Panneau monPanneau;

   public Fenetre(String s, Animable dessin, String imageFond)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

      monPanneau = new Panneau(dessin, imageFond);
      getContentPane().add(monPanneau);

      pack();
      setLocationRelativeTo(null);
      setVisible(true);

// --------------------------------------------------------------------------
// L'ecran est affiche : on lance l'animation...
// --------------------------------------------------------------------------
      Thread animation = new Thread(monPanneau);
      animation.setPriority(Thread.MAX_PRIORITY);
      animation.start();
   }
}