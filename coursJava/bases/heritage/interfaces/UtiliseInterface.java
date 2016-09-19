// ==========================================================================
// APPLICATION : utilisation des INTERFACES
// ==========================================================================


public class UtiliseInterface
{
   public static void main(String argv[])
   {  
      Fumier fumier = new Fumier();
      fumier.afficheCode();
   }	
}

// ==========================================================================
// Interfaces :
// Définition de constantes
// ==========================================================================

interface Ascii
{
   final static int A = 65,
                    B = 66,
                    C = 67,
                    D = 68;
}

interface Ebcdic
{
   final static int A = 31,
                    B = 32,
                    C = 33,
                    D = 34;
}

interface Code extends Ebcdic //Ascii
{
}

class Fumier implements Code
{
   void afficheCode()
   {
      System.out.println("A : " + A);
   }
}
