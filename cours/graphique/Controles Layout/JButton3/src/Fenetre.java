// ==========================================================================
// Classe Fenetre                                        Application JButton3
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
   private JPanel panneauFond;
   private JButton boutonAjout;
   private int numeroBouton = 1;

// --------------------------------------------------------------------------
// Constructeur :
// --------------------------------------------------------------------------
   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// ---------------------------------------------------------------------
// Creation de l'objet panneauFond :
// ---------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setBackground(Color.blue);

// --------------------------------------------------------------------------
// Création de l'objet boutonAjout :
// --------------------------------------------------------------------------
      boutonAjout = new JButton("AJOUTE");
      boutonAjout.addActionListener(this);
      panneauFond.add(boutonAjout);

      getContentPane().add(panneauFond);

      pack();

// ---------------------------------------------------------------------
// Pour que la fenetre soit en taille maximale (tout l'ecran). Cela ne
// change rien a la taille calculee par le pack. Quand on reduit la
// fenetre, elle prend la taille preferee calculee par le pack.
// ---------------------------------------------------------------------
      setExtendedState(Frame.MAXIMIZED_BOTH);
      setVisible(true);
   }

// --------------------------------------------------------------------------
// Méthode de l'interface ActionListener
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {

// --------------------------------------------------------------------------
// getSource() retourne la reference d'un Object. Il faut convertir cette
// reference en reference de JButton (au moins de Component), pour pouvoir
// comparer cette reference a boutonAjout et utiliser la methode remove().
// --------------------------------------------------------------------------
      JButton source = (JButton)e.getSource();

      if (source == boutonAjout)
      {
         JButton nouveauBouton = new JButton("FUMIER " + numeroBouton);
         nouveauBouton.addActionListener(this);
         panneauFond.add(nouveauBouton);
         numeroBouton++;
      }
      else
      {
         panneauFond.remove(source);
      }

// --------------------------------------------------------------------------
// La methode validate() permet de recalculer les positions des composants
// de la zone de contenu de la fenetre (JPanel) et de les reafficher.
// Si on ne met pas cette instruction, le bouton n'apparait sur l'ecran que
// lorsque la fenetre est redessinee (changement de taille par exemple)
// --------------------------------------------------------------------------
      panneauFond.validate();

// --------------------------------------------------------------------------
// La methode repaint() redessine tout le panneau. Cela permet d'eviter les
// remanences d'un bouton enfonce lors du reaffichage.
// --------------------------------------------------------------------------
      panneauFond.repaint();
   }
}