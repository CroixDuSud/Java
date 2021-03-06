// ==========================================================================
// APPLICATION TestVoitureCompos : synthese des generalites sur les classes
// --------------------------------------------------------------------------
// Meme programme que TestVoiture mais la classe Moteur est interne a Voiture
// ==========================================================================

public class TestVoitureCompos
{
   public static void main(String argv[])
   {
      Garage g1, g2;
      Vendeur vendeur1, vendeur2, vendeur3;
      Voiture v1, v2, v3, v4;
      
// --------------------------------------------------------------------------
// Creation et affichage des garages
// --------------------------------------------------------------------------
      System.out.println("LISTE DES GARAGES DE LA MARQUE " + 
                         Garage.getNomGarage() + "\n");

      g1 = new Garage("10, avenue des Champs Elysees 75008 PARIS");
      g2 = new Garage();
      
      System.out.println(g1);
      System.out.println(g2);

// --------------------------------------------------------------------------
// Creation et affichage des vendeurs
// --------------------------------------------------------------------------
      vendeur1 = new Vendeur("Michel", "GIROUD", g1);
      vendeur2 = new Vendeur("Michel", "GINESTE", g2);      
      vendeur3 = new Vendeur("Jean Pierre", "SIMARD", g1);

      System.out.println("\n\nLISTE DES VENDEURS"); 
      System.out.println(vendeur1);
      System.out.println(vendeur2);
      System.out.println(vendeur3);
   
// --------------------------------------------------------------------------
// Creation et affichage des voitures :
// --------------------------------------------------------------------------
      v1 = new Voiture();
      v2 = new Voiture(2004);
      v3 = new Voiture(vendeur1);
      v4 = new Voiture(3010, vendeur2);
     
      System.out.println("\n\nLISTE DES VOITURES :");
      System.out.println(v1);
      System.out.println(v2);
      System.out.println(v3);
      System.out.println(v4);
   }
}