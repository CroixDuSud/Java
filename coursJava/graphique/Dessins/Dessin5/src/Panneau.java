// ==========================================================================
// Classe Panneau                                         Application Dessin5
// ==========================================================================

import javax.swing.*;  
import java.awt.*;

public class Panneau extends JPanel
{
   private int abs;
   private int ord;
   private boolean dessineRect = false;
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if (dessineRect) g.fillRect(abs, ord, 6, 6);
   }
   
   public boolean getDessineRect()
   {
      return dessineRect;
   }
   
   public void setDessineRect()
   {
      dessineRect = true;
   }
   
   public void setCoordonnees(int abs, int ord)
   {
      this.abs = abs;
      this.ord = ord;
   }
}