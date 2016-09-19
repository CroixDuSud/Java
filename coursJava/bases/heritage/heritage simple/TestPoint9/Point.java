// ==========================================================================
// Classe Point                                        Application TestPoint9
// ==========================================================================

public class Point
{
// --------------------------------------------------------------------------
// Proprietes
// --------------------------------------------------------------------------
   private int xPoint;
   private int yPoint;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public Point(int xPoint, int yPoint)
   {
      this.xPoint = xPoint;
      this.yPoint = yPoint;
   }
   
// --------------------------------------------------------------------------
// Methodes
// --------------------------------------------------------------------------
   public void affiche()
   {
      System.out.println("Affichage du point  : " + this);
   }

   public void efface()
   {
      System.out.println("Effacement du point : " + this);
   }

   public void deplace(int dx, int dy)
   {
      efface();
      xPoint += dx;
      yPoint += dy;
      affiche();
   }
   
   public String toString()
   {
      return xPoint + ", " + yPoint;
   }
}
