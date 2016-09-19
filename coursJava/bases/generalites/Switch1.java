// ==========================================================================
// Switch1 : switch
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class Switch1
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
            break;
         case 1  :
            System.out.println("un");
            break;
         case 2  :
            System.out.println("deux");
            break;
         default :
            System.out.println("incorrect");
      }
      
      System.out.println("\nAu revoir...");
      Clavier.readString();
   }
}