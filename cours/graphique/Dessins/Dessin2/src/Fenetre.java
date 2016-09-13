// ==========================================================================
// Classe Fenetre                                         Application Dessin2
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements ActionListener
{
   private JPanel panneauFond;
   
   private JButton boutonRect;
   private JButton boutonOval;
   private Panneau panneauDessin;
   
   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());
      
// --------------------------------------------------------------------------
// Création de l'objet panneauFond :
// --------------------------------------------------------------------------
      panneauFond = new JPanel();
      panneauFond.setLayout(new BorderLayout());
      panneauFond.setPreferredSize(new Dimension(300,150));
      
// --------------------------------------------------------------------------
// Création de l'objet panneauDessin, avec changement de la couleur de fond :
// --------------------------------------------------------------------------
      panneauDessin = new Panneau();
      panneauDessin.setBackground(Color.white);
      
// --------------------------------------------------------------------------
// Création des objets boutons :
// --------------------------------------------------------------------------
      boutonRect = new JButton("RECTANGLE");
      boutonOval = new JButton("OVALE");
      
// --------------------------------------------------------------------------
// Ajout des ecouteurs des objets boutons :
// --------------------------------------------------------------------------
      boutonRect.addActionListener(this);
      boutonOval.addActionListener(this);
      
// --------------------------------------------------------------------------
// Ajout des composants au panneau de fond :
// --------------------------------------------------------------------------
      panneauFond.add(panneauDessin);
      panneauFond.add(boutonRect, BorderLayout.NORTH);
      panneauFond.add(boutonOval, BorderLayout.SOUTH); 

// --------------------------------------------------------------------------
// Ajout du panneau de fond a la fenetre :
// --------------------------------------------------------------------------
      getContentPane().add(panneauFond);
      
      pack();
      setVisible(true);
   }
   
// --------------------------------------------------------------------------
// Ecouteur des actions sur les objets boutons
// --------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == boutonRect) panneauDessin.setRect();
      if (e.getSource() == boutonOval) panneauDessin.setOval();
      panneauDessin.repaint(); // Sans cette instruction, il faut attendre le
                               // reaffichage par paintComponent pour voir la
                               // modification du graphisme. Cela se produit
                               // par exemple en redimensionnant la fenetre.
   }
}