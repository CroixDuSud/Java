// ==========================================================================
// APPLICATION Exception04
// ==========================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exception04
{
   public static void main(String argv[]) throws IOException
   {
      Fraction f;
      int num;
      int den;

      try
      {
         System.out.print("Entrez le numerateur : ");
         num = Clavier.readInt();
         System.out.print("Entrez le denominateur : ");
         den = Clavier.readInt();
         f = new Fraction(num, den);
         System.out.println("\nBravo ! La fraction est instanciee !");
         System.out.println("Elle vaut : " + f);
      }
      catch (NumberFormatException e)
      {
         System.out.println("\nEntier incorrect !");
      }
      
      Clavier.readString();
   }
}
