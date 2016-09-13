// ==========================================================================
// APPLICATION VOITURE : programme TestGarage (premiere etape)
// ==========================================================================

public class TestGarage
{
   public static void main(String argv[])
   {
      Garage g1, g2;
      
      g1 = new Garage("10, avenue des Champs Elysees 75008 PARIS");
      g2 = new Garage();
      
      System.out.println("Liste des garages de la marque " + 
                         Garage.getNomGarage() + "\n");
      
      System.out.println(g1);
      System.out.println(g2);
   }
}