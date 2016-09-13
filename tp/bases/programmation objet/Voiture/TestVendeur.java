// ==========================================================================
// APPLICATION VOITURE : programme TestVendeur (deuxieme etape)
// --------------------------------------------------------------------------
// Cette etape utilise les classes Garage et Vendeur
// ==========================================================================

public class TestVendeur
{
   public static void main(String argv[])
   {
      Garage g1, g2;
      Vendeur vendeur1, vendeur2, vendeur3;
      
      g1 = new Garage("10, avenue des Champs Elysees 75008 PARIS");
      g2 = new Garage();
      
      System.out.println("Liste des garages de la marque " + 
                         Garage.getNomGarage() + "\n");
      
      System.out.println(g1);
      System.out.println(g2);
      
      vendeur1 = new Vendeur("Michel", "GIROUD", g1);
      vendeur2 = new Vendeur("Michel", "GINESTE", g2);      
      vendeur3 = new Vendeur("Jean Pierre", "SIMARD", g1);

      System.out.println("\n\nListe des vendeurs"); 
      System.out.println(vendeur1);
      System.out.println(vendeur2);
      System.out.println(vendeur3);
   }
}