// ==========================================================================
// APPLICATION Exception05
// --------------------------------------------------------------------------
// Traitement separe de la saisie du numerateur et du denominateur
// ==========================================================================

import utilitairesMG.divers.*;
import java.io.*;

public class Exception05
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
         try
         {
            System.out.print("Entrez le denominateur : ");
            den = Clavier.readInt();
         
            f = new Fraction(num, den);
            System.out.println("\nBravo ! La fraction est instanciee !");
            System.out.println("Elle vaut : " + f);
         }
         catch (NumberFormatException e)
         {
            System.out.println("\nDenominateur incorrect !");
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

