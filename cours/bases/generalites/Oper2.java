// ==========================================================================
// Oper2 : utilisation des operateurs de conversion (cast)
// --------------------------------------------------------------------------
// Calcul du ratio de deux nombres entiers.
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Oper2
{
   public static void main(String argv[]) throws IOException
   {
      int i, j;
      
      i = 10;
      j = 3;
      
      System.out.println("Le rapport est : " + (float) i / j);
      System.out.println("Le rapport est : " + (float) i / (float) j);
      System.out.println("Le rapport est : " + (float) (i / j));
      
      Clavier.readString();
   }
}