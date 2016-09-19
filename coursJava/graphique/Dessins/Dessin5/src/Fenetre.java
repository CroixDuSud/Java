// ==========================================================================
// Classe Fenetre                                         Application Dessin5
// ==========================================================================

import javax.swing.*;  
import java.awt.event.*; 
import java.awt.*;
import utilitairesMG.graphique.*;

public class Fenetre extends JFrame implements MouseListener
{
   private JPanel panneauFond;
   
   private Panneau panneauDessin1;
   private Panneau panneauDessin2;
   private Panneau panneauDessin3;

   public Fenetre(String s)
   {
      super(s);
      addWindowListener(new EcouteFenetre());
      
// --------------------------------------------------------------------------
// Création de l'objet panneauFond :
// --------------------------------------------------------------------------
      panneauFond = new JPanel();

// -------------------------------------------------------------------------- 
// Instanciation des objets Panneau :
// -------------------------------------------------------------------------- 
      panneauDessin1 = new Panneau();
      panneauDessin1.setBackground(Color.cyan);
      panneauDessin1.setForeground(Color.blue);
      panneauDessin1.setPreferredSize(new Dimension(100, 100));
      
      panneauDessin2 = new Panneau();
      panneauDessin2.setBackground(Color.yellow);
      panneauDessin2.setForeground(Color.red);
      panneauDessin2.setPreferredSize(new Dimension(100, 100));

      panneauDessin3 = new Panneau();
      panneauDessin3.setBackground(Color.pink);
      panneauDessin3.setForeground(Color.magenta);
      panneauDessin3.setPreferredSize(new Dimension(100, 100));
      
// -------------------------------------------------------------------------- 
// Ajout des ecouteurs de MouseEvent aux objets monPanneau
// -------------------------------------------------------------------------- 
      panneauDessin1.addMouseListener(this);
      panneauDessin2.addMouseListener(this);
      panneauDessin3.addMouseListener(this);
      
// -------------------------------------------------------------------------- 
// Ajout des panneaux a la fenetre
// -------------------------------------------------------------------------- 
      panneauFond.add(panneauDessin1);
      panneauFond.add(panneauDessin2);
      panneauFond.add(panneauDessin3);

      getContentPane().add(panneauFond);

      pack();
      setVisible(true);
   }
   
// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------

   public void mouseClicked(MouseEvent e)
   {
   }

   public void mousePressed(MouseEvent e)
   {
      Panneau source;
      
      source = (Panneau)e.getSource();
      
      source.setDessineRect();
      source.setCoordonnees(e.getX(), e.getY());
      source.repaint();
      
      if (source == panneauDessin2)
      {
         panneauDessin1.setCoordonnees(e.getX(), e.getY());
         panneauDessin1.repaint();
         panneauDessin3.setCoordonnees(e.getY(), e.getX());
         panneauDessin3.repaint();
      }
   }

   public void mouseReleased(MouseEvent e)
   {
   }

   public void mouseEntered(MouseEvent e)
   {
   }

   public void mouseExited(MouseEvent e)
   {
   }  
}