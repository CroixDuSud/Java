// ==========================================================================
// Classe TestPoint5                                   Application TestPoint5 
// --------------------------------------------------------------------------
// Proprietes 'static' ou non 'static'
// Méthodes 'static' ou non 'static'
// --------------------------------------------------------------------------
// Constructeurs, surcharge.
// ==========================================================================

public class TestPoint5
{
   public static void main(String argv[])
   {
      Point p1, p2;
      
      Point.afficheNombrePoints();
      
      p1 = new Point();
      Point.afficheNombrePoints();
      p2 = new Point(5, 2);
      Point.afficheNombrePoints();
      
      System.out.println("\nPoints crees :");
      p1.afficheXY();
      p2.afficheXY();
      
      p2.afficheXY("\nCoordonnees de p2 :");
   }
}