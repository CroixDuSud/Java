// ==========================================================================
// APPLICATION Carres : classe Fenetre
// --------------------------------------------------------------------------
// Ecran avec composants graphiques, vecteurs de dessins
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

// ==========================================================================
// Classe Fenetre
// ==========================================================================

public class Fenetre extends JFrame implements ActionListener
{
   private PanneauDessin monPanneau;
   private JScrollPane defileur;

   private JMenuBar barreMenu;

   private JMenu menuJeu;
   private JMenuItem effacerItem;
   private JMenuItem aideItem;

   private JMenu menuCouleur;
   private JCheckBox rougeItem;
   private JCheckBox vertItem;
   private JCheckBox bleuItem;

   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());

// --------------------------------------------------------------------------
// Creation de l'objet monPanneau :
// --------------------------------------------------------------------------
      monPanneau = new PanneauDessin();
      defileur = new JScrollPane(monPanneau);
      getContentPane().add(defileur);

// --------------------------------------------------------------------------
// Creation de la barre de menu :
// --------------------------------------------------------------------------
      barreMenu = new JMenuBar();

      menuJeu = new JMenu("Jeu");
      menuJeu.setMnemonic('J');
      effacerItem = new JMenuItem("Effacer", 'E');
      aideItem = new JMenuItem("Aide", 'A');

      effacerItem.addActionListener(this);
      aideItem.addActionListener(this);

      menuJeu.add(effacerItem);
      menuJeu.add(aideItem);
      barreMenu.add(menuJeu);

      menuCouleur = new JMenu("Couleur");
      menuCouleur.setMnemonic('C');
      rougeItem = new JCheckBox("Rouge");
      vertItem  = new JCheckBox("Vert");
      bleuItem  = new JCheckBox("Bleu");

      rougeItem.addActionListener(this);
      vertItem.addActionListener(this);
      bleuItem.addActionListener(this);

      menuCouleur.add(rougeItem);
      menuCouleur.add(vertItem);
      menuCouleur.add(bleuItem);
      barreMenu.add(menuCouleur);

      setJMenuBar(barreMenu);

      pack();
      setVisible(true);
   }

// --------------------------------------------------------------------------
// Méthode de l'interface ActionListener
// --------------------------------------------------------------------------

   public void actionPerformed(ActionEvent e)
   {
      Object source = e.getSource();
      int r, v, b;

      if (source == effacerItem)
      {
         monPanneau.videPanneau();
      }
      else
      {
         if (source == aideItem)
         {
            JOptionPane.showMessageDialog(this,
                                "Clic gauche : ajout et déplacement\n" +
                                "Clic droit : suppression\n" +
                                "Roulette : dimension carré",
                                "Fonctionnement du jeu",
                                JOptionPane.INFORMATION_MESSAGE,
                                new ImageIcon("terre.gif"));
         }
         else
         {
            r = 0;
            v = 0;
            b = 0;
            if (rougeItem.isSelected()) r = 255;
            if (vertItem.isSelected())  v = 255;
            if (bleuItem.isSelected())  b = 255;
            monPanneau.changeCouleurCourante(new Color(r, v, b));
         }
      }
   }
}