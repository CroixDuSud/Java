// ==========================================================================
// APPLICATION TestClavier : test de la classe Clavier
// ==========================================================================

import java.io.*;

public class TestClavier
{
   public static void main(String argv[]) throws IOException
   {
      String chaine;
      int i;
      double f;
      
      System.out.print("Entrer une chaine de caracteres : ");
      chaine = Clavier.readString();
      System.out.println("Vous avez tape : " + chaine);
      
      System.out.print("\nEntrer un entier : ");
      i = Clavier.readInt();
      System.out.println("Vous avez tape : " + i);
      
      System.out.print("\nEntrer un reel : ");
      f = Clavier.readDouble();
      System.out.println("Vous avez tape : " + f);
      
      Clavier.readString();
   }
}