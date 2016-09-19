// ==========================================================================
// Classe Panneau                                         Application Dessin2
// ==========================================================================

import javax.swing.*;
import java.awt.*;

public class Panneau extends JPanel
{
   private boolean dessinRect = false;
   private boolean dessinOval = false;
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if (dessinRect) g.drawRect(80, 20, 120, 60);
      if (dessinOval) g.drawOval(80, 20, 120, 60);
   }
   
   public void setRect()
   {
      dessinRect = true;
      dessinOval = false;
   } 
   
   public void setOval()
   {
      dessinRect = false;
      dessinOval = true;
   } 
}