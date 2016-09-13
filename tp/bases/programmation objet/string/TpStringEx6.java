// ==========================================================================
// APPLICATION TpStringEx6 : sixieme exercice sur les chaines de caracteres
// --------------------------------------------------------------------------
// Version elegante utilisant la classe StringBuffer
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TpStringEx6
{
   public static void main(String argv[]) throws IOException
   {
      int i;                    // Indice du caractere examine
      char c;                   // Caractere examine
      int compteur;             // Nombre d'occurences du caractere
      
      StringBuffer chaine = new StringBuffer("JJJJ'AIME JJJAVA");

      while (chaine.length() > 0)
      {     
         c = chaine.charAt(0);
         compteur = 0;
         
         i = 0;
         
         while(i < chaine.length())
         {
            if (chaine.charAt(i) == c)
            {
               compteur++;
               chaine.deleteCharAt(i);
            }
            else
            {
               i++;
            }
         }
         
         System.out.println("Le caractere " + c + " est present " + compteur + " fois.");
      }
     
      Clavier.readString();
   }
}