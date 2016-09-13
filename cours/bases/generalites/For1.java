// ==========================================================================
// For1 : boucle for
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class For1
{
   public static void main(String argv[]) throws IOException
   {
      int i;
      
      for (i = 1; i <= 10; i++)
      {
         System.out.println("Etape " + i);
      }      
      
      Clavier.readString();
   }
}