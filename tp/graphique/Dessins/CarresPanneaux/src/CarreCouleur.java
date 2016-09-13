// ==========================================================================
// Classe CarreCouleur                             Application CarresPanneaux
// ==========================================================================

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CarreCouleur extends JPanel implements MouseMotionListener,
                                                    MouseListener,
                                                    MouseWheelListener
{
   private Point debutDragged;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public CarreCouleur(int x, int y, int taille, Color couleur)
   {
      setBounds(x, y, taille, taille);
      setBackground(couleur);

      addMouseListener(this);
      addMouseMotionListener(this);
      addMouseWheelListener(this);
   }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------

   public void mouseClicked(MouseEvent e)
   {
   }

   public void mousePressed(MouseEvent e)
   {
      Container cont = getParent();

      if (e.getButton() == MouseEvent.BUTTON1)
      {
         cont.setComponentZOrder(this, 0);
         debutDragged = e.getPoint();
      }

      if (e.getButton() == MouseEvent.BUTTON3)
      {
         cont.remove(this);
         cont.validate();
         cont.repaint();
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

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseMotionListener
// --------------------------------------------------------------------------

// --------------------------------------------------------------------------
// La souris est dragged
// --------------------------------------------------------------------------
   public void mouseDragged(MouseEvent e)
   {
      int dx, dy;
      dx = e.getX() - debutDragged.x;
      dy = e.getY() - debutDragged.y;

      setLocation(getLocation().x + dx, getLocation().y + dy);
}

// --------------------------------------------------------------------------
// La souris est bougee
// --------------------------------------------------------------------------
   public void mouseMoved(MouseEvent e)
   {
   }

// --------------------------------------------------------------------------
// Méthode de l'interface MouseWheelListener
// --------------------------------------------------------------------------
   public void mouseWheelMoved(MouseWheelEvent e)
   {
      int taille;

      taille = getSize().width  + e.getWheelRotation();
      if(taille < 10) taille = 10;

      setSize(new Dimension(taille, taille));
   }
}
