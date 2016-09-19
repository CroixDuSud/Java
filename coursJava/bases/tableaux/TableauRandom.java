// ==========================================================================
// APPLICATION TableauRandom : Tableaux, nombres aléatoires
// ==========================================================================

import java.util.*;  // Cette instruction est nécessaire pour l'utilisation
                     // de la classe Random qui se trouve dans le package
                     // java.util
                   

public class TableauRandom
{
   public static void main(String argv[])
   {  
      int i;
      int longueur;
      int tableau[];
      
// --------------------------------------------------------------------------
// Declaration de reference et instanciation necessaires a l'appel de 
// la methode nextInt(10) : cette methode retourne un entier compris entre
// 0 et 9.
// --------------------------------------------------------------------------
      Random r = new Random();
      longueur = r.nextInt(10) + 1;   // Longueur du tableau (entre 1 et 10)

// --------------------------------------------------------------------------
// Creation du tableau, contenu d'un poste (par defaut), longueur :
// --------------------------------------------------------------------------
      tableau = new int[longueur]; 
      
      System.out.println("tableau[0] = " + tableau[0]);
      System.out.println("Longueur du tableau : " + tableau.length + "\n");
      
// --------------------------------------------------------------------------
// Remplissage du tableau :
// --------------------------------------------------------------------------
      for (i = 0; i < tableau.length; i++)
      {
         tableau[i] = r.nextInt(100) + 1;
      } 

// --------------------------------------------------------------------------
// Affichage du tableau :
// --------------------------------------------------------------------------
      for (i = 0; i < tableau.length; i++)
      {
         System.out.println("tableau[" + i + "] = " + tableau[i]);     
      }
   }
}