// ==========================================================================
// APPLICATION TestClavierInt :
// --------------------------------------------------------------------------
// Création d'une classe d'Exception personnelle
// ==========================================================================


import java.io.*;
import utilitairesMG.divers.*;

public class TestClavierInt
{
   public static void main(String argv[]) throws IOException
   {  
      int i;
      try
      {
         System.out.print("Saisir un entier : ");
         i = ClavierInt.readInt(150, 200);
         System.out.println("Valeur saisie : " + i);
      }
      catch (BorneException eb)
      {
         eb.printStackTrace();
      }
      catch (NumberFormatException eb)
      {
         eb.printStackTrace();
      }
      
      Clavier.readString();
   }     
}