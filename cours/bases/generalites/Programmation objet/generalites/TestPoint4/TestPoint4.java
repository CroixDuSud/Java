// ==========================================================================
// Classe TestPoint4                                   Application TestPoint4
// --------------------------------------------------------------------------
// Encapsulation
// ==========================================================================

public class TestPoint4
{
   public static void main(String argv[])
   {
      Point p;

      p = new Point();
      System.out.println("p : " + p);
      
      p.afficheXY();
      
      p.setX(10);
      p.setY(20);
      p.afficheXY();
   }
}