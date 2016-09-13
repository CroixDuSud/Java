// ==========================================================================
// APPLICATION Carres : classe PanneauDessin
// --------------------------------------------------------------------------
// Ecran avec composants graphiques, vecteurs de dessins
// ==========================================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



// ==========================================================================
// Classe PanneauDessin
// ==========================================================================

public class PanneauDessin extends JPanel implements MouseListener,
                                                     MouseMotionListener,
                                                     MouseWheelListener
{
   private Vector<CarreCouleur> vCarre = new Vector<CarreCouleur>();
   private Color couleurCourante;
   private int tailleCourante;

   private int dragged = -1;    // Numero du carre "dragge"
   private int debutDraggedX;   // Position de depart du curseur de draggage
   private int debutDraggedY;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public PanneauDessin()
   {
      setBackground(new Color(200, 200, 200));
      setPreferredSize(new Dimension(400, 400));
      couleurCourante = Color.black;
      tailleCourante = 25;

      addMouseListener(this);
      addMouseMotionListener(this);
      addMouseWheelListener(this);
   }

// --------------------------------------------------------------------------
// ajouteCarre
// --------------------------------------------------------------------------
   public void ajouteCarre(Point p)
   {
      int x;
      int y;
      CarreCouleur carre;

      x = p.x - (tailleCourante / 2);
      y = p.y - (tailleCourante / 2);

      carre = new CarreCouleur(x, y, tailleCourante, couleurCourante);
      vCarre.addElement(carre);

      repaint();
   }

// --------------------------------------------------------------------------
// enleveCarre
// --------------------------------------------------------------------------
   public void enleveCarre(int numCarre)
   {
      vCarre.removeElementAt(numCarre);
      repaint();
   }

// --------------------------------------------------------------------------
// deplaceCarre
// --------------------------------------------------------------------------
   public void deplaceCarre(int numCarre, int dx, int dy)
   {
      CarreCouleur carre;

      carre = vCarre.elementAt(numCarre);
      carre.deplace(dx, dy);

      repaint();
   }

// --------------------------------------------------------------------------
// videPanneau
// --------------------------------------------------------------------------
   public void videPanneau()
   {
      vCarre.removeAllElements();
      repaint();
   }

// --------------------------------------------------------------------------
// changeCouleurCourante
// --------------------------------------------------------------------------
   public void changeCouleurCourante(Color couleurCourante)
   {
      this.couleurCourante = couleurCourante;
   }

// --------------------------------------------------------------------------
// changeTailleCourante
// --------------------------------------------------------------------------
   public void changeTailleCourante(int increment)
   {
      if ((increment > 0) || (this.tailleCourante > 10))
      {
         this.tailleCourante += increment;
      }
   }

// --------------------------------------------------------------------------
// trouveCarre
// --------------------------------------------------------------------------
   public int trouveCarre(Point p)
   {
      int i;
      CarreCouleur carre;
      int carreTrouve = -1;

      i = 0;
      while ((carreTrouve == -1) && (i < vCarre.size()))
      {
         carre = vCarre.elementAt(i);
         if (carre.contains(p))
         {
            carreTrouve = i;
         }
         i++;
      }
      return carreTrouve;
   }

// --------------------------------------------------------------------------
// paintComponent
// --------------------------------------------------------------------------
   public void paintComponent(Graphics g)
   {
      int i;
      CarreCouleur carre;

      super.paintComponent(g);
      for (i = 0; i < vCarre.size(); i++)
      {
         carre = vCarre.elementAt(i);
         carre.affiche(g);
      }
   }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------

   public void mouseClicked(MouseEvent e)
   {
   }

   public void mousePressed(MouseEvent e)
   {
      int numeroCarre;

      dragged = -1;

      numeroCarre = trouveCarre(e.getPoint());

      if (numeroCarre == -1)
      {
         if (e.getButton() == MouseEvent.BUTTON1)
         {
            ajouteCarre(e.getPoint());
         }
      }
      else
      {
         if (e.getButton() == MouseEvent.BUTTON3)
         {
            enleveCarre(numeroCarre);
         }
         if (e.getButton() == MouseEvent.BUTTON1)
         {
            dragged = numeroCarre;
            debutDraggedX = e.getX();
            debutDraggedY = e.getY();
         }
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
      int dx;
      int dy;

      if (dragged != -1)
      {
         dx = e.getX() - debutDraggedX;
         dy = e.getY() - debutDraggedY;
         deplaceCarre(dragged, dx, dy);
         debutDraggedX = e.getX();
         debutDraggedY = e.getY();
      }
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
      int numeroCarre;
      CarreCouleur carre;
      int tailleCarre;

      numeroCarre = trouveCarre(e.getPoint());

      if (numeroCarre > -1)
      {
         carre = vCarre.elementAt(numeroCarre);
         tailleCarre = carre.getTaille() + e.getWheelRotation();
         if (tailleCarre <=10 ) tailleCarre = 10;
         carre.changeTaille(tailleCarre);

         repaint();
      }
      else
      {
         changeTailleCourante(e.getWheelRotation());
      }
   }
}