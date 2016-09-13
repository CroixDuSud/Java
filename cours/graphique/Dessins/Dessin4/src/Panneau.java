// ==========================================================================
// Classe Panneau                                         Application Dessin4
// ==========================================================================

import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 

public class Panneau extends JPanel implements MouseListener
{
   private int xRect;
   private int yRect;
   private boolean afficheRect = false;
   
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Panneau()
   {
      addMouseListener(this);
   }
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if (afficheRect) g.fillRect(xRect, yRect, 8, 8);
   }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------

   public void mouseClicked(MouseEvent e)
   {
   }

// --------------------------------------------------------------------------
// Modifie la position du rectangle quand la souris est enfoncee
// --------------------------------------------------------------------------
   public void mousePressed(MouseEvent e)
   {
      xRect = e.getX();
      yRect = e.getY();
      afficheRect = true;
      repaint();
   }

   public void mouseReleased(MouseEvent e)
   {
   }

   public void mouseEntered(MouseEvent e)
   {
   }

// --------------------------------------------------------------------------
// Efface le rectangle quand la souris sort de la fenetre
// --------------------------------------------------------------------------
   public void mouseExited(MouseEvent e)
   {
      afficheRect = false;
      repaint();
   }        
}