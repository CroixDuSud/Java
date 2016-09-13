// ==========================================================================
// APPLICATION TpStringEx1 : premier exercice sur les chaines de caracteres
// --------------------------------------------------------------------------
// Version elegante utilisant la classe Character
// Auteur : Philippe FRANZONE (21 septembre 2006)
// --------------------------------------------------------------------------
// A partir de la chaîne : "J'utilise JAVA avec brio !"
// Transformez les minuscules en majuscules et reciproquement.
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;


public class TpStringEx1
{ 
   public static void main (String arg [] ) throws IOException
   { 
      String chaine;                // Chaine a traiter
      int longueur;                 // Longueur de la chaine
      String chaineTravail;         // Chaine de travail
      char c;                       // Caractere examine
      int i;                        // Indice du caractere examine
      
      chaine = "J'utilise JAVA avec brio !";
		System.out.println("AU DEPART -> " + chaine + "\n");

// --------------------------------------------------------------------------
// Inversion des minuscules et des majuscules
// --------------------------------------------------------------------------
      chaineTravail ="";

      for (i = 0; i < chaine.length(); i++)
      {
         c = chaine.charAt(i);
         
         if (Character.isLetter(c))
         {
            if (Character.isLowerCase(c))
            {
               chaineTravail += Character.toUpperCase(c);
            }
            else
            {
               chaineTravail += Character.toLowerCase(c);
            }
         }
         else
         {
            chaineTravail += c;
         }
      }
      
      chaine = chaineTravail;
      System.out.println("A LA FIN  -> " + chaine);
      Clavier.readString();
   }
}