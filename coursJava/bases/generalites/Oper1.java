// ==========================================================================
// Oper1 : utilisation des operateurs ++ --
// --------------------------------------------------------------------------
// Ce programme affiche :       9 6 5
//                             10 6 4
//                             10 5 4   ???
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Oper1
{
   public static void main(String argv[]) throws IOException
   {
      int i, j;
      
      i = 5;
      j = 4;
      
      System.out.print(++i + j--);
      System.out.print("  " + i--);
      System.out.println("  " + ++j);
      
      Clavier.readString();
   }
}