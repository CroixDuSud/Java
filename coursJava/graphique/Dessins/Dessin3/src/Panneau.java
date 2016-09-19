// ==========================================================================
// Classe Panneau                                         Application Dessin3
// ==========================================================================

import javax.swing.*;
import java.awt.*; 

public class Panneau extends JPanel
{
   private int xRect;
   private int yRect;
   private boolean afficheRect = false;
   
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      if (afficheRect) g.fillRect(xRect, yRect, 8, 8);
   }

   public void setCoordonneesRect(int xRect, int yRect)
   {
      this.xRect = xRect;
      this.yRect = yRect;
   }
   
   public void setAfficheRect(boolean afficheRect)
   {
      this.afficheRect = afficheRect;
   }
}