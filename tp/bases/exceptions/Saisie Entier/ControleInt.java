// ==========================================================================
// APPLICATION ControleInt :
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class ControleInt
{
// --------------------------------------------------------------------------
// Lecture d'un entier :
// --------------------------------------------------------------------------
   public static int saisieInt(int min, int max) throws IOException
   {
      int i = 0;
      boolean erreur;
      
      do
      {
         erreur = false;
         try
         {
            System.out.print("Saisir un entier : ");
            i = ClavierInt.readInt(min, max);
         }
         catch (BorneException e)
         {
            erreur = true;
            System.out.println(e.getMessage() + "\n");
         }
         catch (NumberFormatException e)
         {
            erreur = true;
            System.out.println("Nombre incorrect\n");
         }
      }
      while(erreur);

      return i;
   }
}