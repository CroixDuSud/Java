// =======================================================================
// APPLICATION Exception07
// -----------------------------------------------------------------------
// Utilisation de DenominateurNulException
// =======================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exception07
{
   public static void main(String argv[]) throws IOException
   {
      FractionEx07 f;
      int num;
      int den;

      try
      {
         System.out.print("Entrez le numerateur : ");
         num = Clavier.readInt();
         try
         {
            System.out.print("Entrez le denominateur : ");
            den = Clavier.readInt();
         
            f = new FractionEx07(num, den);

            System.out.println("\nBravo ! La fraction est instanciee !");
            System.out.println("Elle vaut : " + f);
            System.out.println("Sa partie entiere est : " + f.partieEntiere());
         }
         catch (NumberFormatException e)
         {
            System.out.println("\nDenominateur incorrect !");
         }
         catch (DenominateurNulException e)
         {
            System.out.println("\n" + e.getMessage());
            System.out.println("La partie entiere ne peut etre calculee !");
         }
      }
      catch (NumberFormatException e)
      {
         System.out.println("\nNumerateur incorrect !");
      }
      finally
      {
         System.out.println("\n\nFin du programme...");
      }
      
      Clavier.readString();
   }
}

