// ==========================================================================
// APPLICATION TestStringStringBuffer
// --------------------------------------------------------------------------
// Essais sur les classes String et StringBuffer
// ==========================================================================

public class TestStringStringBuffer
{
   public static void main(String argv[])
   {
// --------------------------------------------------------------------------
// String
// --------------------------------------------------------------------------
      String toto = "Fumier infect";
      
      System.out.println(toto.hashCode() + " " + toto);
      toto = toto + " CREVURE !";
      System.out.println(toto.hashCode() + " " + toto);
      
// --------------------------------------------------------------------------
// StringBuffer
// --------------------------------------------------------------------------
      StringBuffer tata = new StringBuffer("Fumier infect");
      System.out.println("Capacite tata : " + tata.capacity());
      
      System.out.println(tata.hashCode() + " " + tata);
      tata.append(" CREVURE PUANTE xxxxxxxxxxxxxxxxxxxxxxxxxxx!");
      System.out.println("Capacite tata : " + tata.capacity());
      System.out.println(tata.hashCode() + " " + tata);
   }
}