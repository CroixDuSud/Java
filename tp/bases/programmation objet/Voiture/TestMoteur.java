// ==========================================================================
// APPLICATION VOITURE : programme TestMoteur (troisieme etape)
// ==========================================================================

public class TestMoteur
{
   public static void main(String argv[])
   {
      Moteur m1, m2, m3;
      
      m1 = new Moteur();
      m2 = new Moteur(2000);
      m3 = new Moteur(); 
           
      System.out.println("Liste des moteurs\n");
      
      System.out.println(m1);
      System.out.println(m2);
      System.out.println(m3);
   }
}