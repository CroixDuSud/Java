// ==========================================================================
// Switch1Err : switch avec oubli du break...
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Switch1Err
{
   public static void main(String argv[]) throws IOException
   {
      int n;
      
      System.out.print("Entrez un nombre entier compris entre 0 et 2 : ");
      n = Clavier.readInt();
      
      switch (n)
      {
         case 0  :
            System.out.println("nul");
         case 1  :
            System.out.println("un");
         case 2  :
            System.out.println("deux");
         default :
            System.out.println("incorrect");
      }
      
      System.out.println("\nAu revoir...");
      Clavier.readString();
   }
}