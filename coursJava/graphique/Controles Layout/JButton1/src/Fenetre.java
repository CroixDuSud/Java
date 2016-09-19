// ==========================================================================
// Classe Fenetre                                        Application JButton1
// --------------------------------------------------------------------------
// Cette classe implémente l'interface ActionListener (pour écouter
// l'évènement lié au bouton).
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
   private JPanel panneauFond;
   private JButton monBouton1;
   private JButton monBouton2;

   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setBackground(Color.red);

      monBouton1 = new JButton("FUMIER");
      monBouton1.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 40));

      monBouton2 = new JButton("CREVURE PUANTE");

      monBouton1.addActionListener(this);
      monBouton2.addActionListener(this);

      panneauFond.add(monBouton1);
      panneauFond.add(monBouton2);

      getContentPane().add(panneauFond);

      pack();
      setVisible(true);
   }

// --------------------------------------------------------------------------
// Méthode de l'interface ActionListener
// --------------------------------------------------------------------------
// La methode getActionCommand(), presente uniquement dans la classe
// ActionEvent, permet d'afficher le texte indique dans le bouton.
// --------------------------------------------------------------------------
// La methode getSource(), presente dans toutes les classes Event, donne la
// reference de l'objet qui a declenche l'evenement.
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      System.out.println("Action sur le bouton " + e.getActionCommand());

      if (e.getSource() == monBouton1)
      {
         System.out.println("FUMIER !");
      }
      else
      {
         System.out.println("CREVURE PUANTE !");
      }
   }
}