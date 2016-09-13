// ==========================================================================
// Classe PanneauDessin                            Application CarresPanneaux
// ==========================================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanneauDessin extends JPanel implements MouseListener
{
   private Color couleurCourante;
   private int   tailleCourante;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public PanneauDessin()
   {
      setBackground(new Color(200, 200, 200));
      setPreferredSize(new Dimension(400, 400));
      setLayout(null);

      couleurCourante = Color.black;
      tailleCourante = 25;

      addMouseListener(this);
   }

// --------------------------------------------------------------------------
// videPanneau
// --------------------------------------------------------------------------
   public void videPanneau()
   {
      removeAll();

      validate();
      repaint();
   }

// --------------------------------------------------------------------------
// changeCouleurCourante
// --------------------------------------------------------------------------
   public void setCouleurCourante(Color couleurCourante)
   {
      this.couleurCourante = couleurCourante;
   }

// --------------------------------------------------------------------------
// changeTailleCourante
// --------------------------------------------------------------------------
   public void changeTailleCourante(int increment)
   {
      tailleCourante += increment;
      if(tailleCourante < 10) tailleCourante = 10;
   }

// --------------------------------------------------------------------------
// Méthodes de l'interface MouseListener
// --------------------------------------------------------------------------

   public void mouseClicked(MouseEvent e)
   {
   }

   public void mousePressed(MouseEvent e)
   {
      if (e.getButton() == MouseEvent.BUTTON1)
      {
         int x;
         int y;
         CarreCouleur carre;
         Point p;

         p = e.getPoint();

         x = p.x - (tailleCourante / 2);
         y = p.y - (tailleCourante / 2);
         carre = new CarreCouleur(x, y, tailleCourante, couleurCourante);

         add(carre);
         validate();
         repaint();
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