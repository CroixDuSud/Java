// ==========================================================================
// Classe Point                                        Application TestPoint5 
// ==========================================================================

public class Point
{
   
// --------------------------------------------------------------------------
// Proprietes
// --------------------------------------------------------------------------
   private int x;
   private int y;
   
   private static int nombrePoints;
   
// --------------------------------------------------------------------------
// Constructeurs
// --------------------------------------------------------------------------
   public Point()
   {
      nombrePoints++;
   }
   
   public Point(int x, int y)
   {
      this.x = x;
      this.y = y;
      nombrePoints++;
   }
   
// --------------------------------------------------------------------------
// Methodes
// --------------------------------------------------------------------------
   public void setX(int x)
   {
      this.x = x;
   }

   public void setY(int y)
   {
      this.y = y;
   }

   public void afficheXY()
   {
      System.out.println("\nx : " + x + "\ny : " + y);
   }

   public void afficheXY(String titre)
   {
      System.out.print(titre);
      System.out.println("\nx : " + x + "\ny : " + y);
   }

   public static void afficheNombrePoints()
   {
      System.out.println("Nombre de points crees : " + nombrePoints);
   }
}
