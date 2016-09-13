// ==========================================================================
// APPLICATION TestStringStringBufferHexa
// --------------------------------------------------------------------------
// Essais sur les classes String et StringBuffer
// ==========================================================================

public class TestStringStringBufferHexa
{
   public static void main(String argv[])
   {
// --------------------------------------------------------------------------
// String
// --------------------------------------------------------------------------
      String toto = "Fumier infect";
      
      System.out.println(Integer.toHexString(toto.hashCode()) + " " + toto);
      toto = toto + " CREVURE !";
      System.out.println(Integer.toHexString(toto.hashCode()) + " " + toto);
      
// --------------------------------------------------------------------------
// StringBuffer
// --------------------------------------------------------------------------
      StringBuffer tata = new StringBuffer("Fumier infect");
      System.out.println("Capacite tata : " + tata.capacity());
      
      System.out.println(Integer.toHexString(tata.hashCode()) + " " + tata);
      tata.append(" CREVURE PUANTE xxxxxxxxxxxxxxxxxxxxxxxxxxx!");
      System.out.println("Capacite tata : " + tata.capacity());
      System.out.println(Integer.toHexString(tata.hashCode()) + " " + tata);
   }
}