// =======================================================================
// APPLICATION Exception06
// ----------------------------------------------------------------------- 
// Appel d'une methode qui peut provoquer une ArithmeticException.
// Traitement de cette erreur.
// =======================================================================

import utilitairesMG.divers.*;
import java.io.*;


public class Exception06
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
            System.out.println("La partie entiere est : " + f.partieEntiere());
         }
         catch (NumberFormatException e)
         {
            System.out.println("\nDenominateur incorrect !");
         }
         catch (ArithmeticException e)
         {
            System.out.println("\nLe denominateur est nul ! ");
            System.out.println(
               "Message de l'ArithmeticException : " + e.getMessage());
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

