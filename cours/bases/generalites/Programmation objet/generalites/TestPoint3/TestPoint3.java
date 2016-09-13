// ==========================================================================
// Classe TestPoint3                                   Application TestPoint3
// --------------------------------------------------------------------------
// Encapsulation
// ==========================================================================

public class TestPoint3
{
   public static void main(String argv[])
   {
      Point p;

      p = new Point();
      System.out.println("p : " + p);
      System.out.println("\np.x : " + p.x + "\np.y : " + p.y);
      
      p.x = 10;
      p.y = 20;
      System.out.println("\np.x : " + p.x + "\np.y : " + p.y);
   }
}