// ==========================================================================
// Classe Point                                        Application TestPoint4
// ==========================================================================

public class Point
{
   
// --------------------------------------------------------------------------
// Proprietes
// --------------------------------------------------------------------------
   private int x;
   private int y;
   
// --------------------------------------------------------------------------
// Methodes
// --------------------------------------------------------------------------
   public void afficheXY()
   {
      System.out.println("\nx : " + x + "\ny : " + y);
   }
   
   public void setX(int ix)
   {
      x = ix;
   }
   
   public void setY(int iy)
   {
      y = iy;
   }
}