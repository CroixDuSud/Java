// ========================================================================
// APPLICATION TabString1 : premiere etape
// ------------------------------------------------------------------------
// Erreur ArrayIndexOutOfBoundsException
// ========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TabString1
{
   public static void main(String argv[]) throws IOException
   {
      int i;
      String tab [] = new String[3];
      tab[0] = "Abruti";
      tab[1] = "Bandit";
      tab[2] = "Cretin";

      for (i = 0; i <= 4; i++)
      {
         System.out.println(tab[i]);
      }

      Clavier.readString();
   }
}