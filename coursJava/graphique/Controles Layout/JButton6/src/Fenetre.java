// ==========================================================================
// Classe Fenetre                                        Application JButton6
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
   
   private JScrollPane defileur;
   
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
      panneauFond.setBackground(Color.cyan);
      panneauFond.setLayout(new FlowLayoutMG());
      
// --------------------------------------------------------------------------
// Création de l'objet boutonAjout :
// --------------------------------------------------------------------------
      boutonAjout = new JButton("AJOUTE");
      boutonAjout.addActionListener(this);
      panneauFond.add(boutonAjout);
      
      defileur = new JScrollPane(panneauFond);
      getContentPane().add(defileur);

      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }
   
// --------------------------------------------------------------------------
// Méthode de l'interface ActionListener
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      JButton source = (JButton)e.getSource();
      
      if (source == boutonAjout)
      {
         JButton nouveauBouton = new JButton("CREVURE " + numeroBouton);
         nouveauBouton.addActionListener(this);
         panneauFond.add(nouveauBouton);
         numeroBouton++;
      }
      else
      {
         panneauFond.remove(source);
      }
      
// --------------------------------------------------------------------------
// validate() permet de recalculer les coordonnees des composants du panneau
// et du panneau lui-même, en particulier sa nouvelle taille preferee.
// revalidate() transmet une requete au Container du panneau, ici le 
// JScrollPane. Il se redessine, et si le panneau nouvellement modifie
// deborde, les barres de scrolling apparaissent
// --------------------------------------------------------------------------
      panneauFond.validate();
      panneauFond.revalidate();

// --------------------------------------------------------------------------
// La methode repaint() redessine tout le panneau. Cela permet d'eviter les
// remanences d'un bouton enfonce lors du reaffichage.
// --------------------------------------------------------------------------
      panneauFond.repaint();
   }
}