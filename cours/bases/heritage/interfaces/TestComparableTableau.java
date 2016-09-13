// ==========================================================================
// APPLICATION TestComparableTableau
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestComparableTableau
{
   public static void main(String argv[]) throws IOException
   {  

// --------------------------------------------------------------------------
// La methode trier(Comparable tableau[]) de la classe TriBulleTableau a pour 
// parametre un tableau d'objets de type Comparable. 
// Elle pourra donc trier n'importe quel tableau d'objets d'une classe qui 
// implemente l'interface Comparable (qui possede donc la methode compareTo). 
// --------------------------------------------------------------------------
// C'est le cas des classes Integer et String.
// --------------------------------------------------------------------------
      String tabString[] =   {"Martin", 
                              "Albert", 
                              "Jacques", 
                              "Paul", 
                              "Albert", 
                              "Nathalie", 
                              "Nadia", 
                              "Ali", 
                              "Morad", 
                              "Nathalie", 
                              "Albert", 
                              "Jean", 
                              "Louis"};
                              
      Integer tabInteger[] = {new Integer(6),
                              new Integer(17), 
                              new Integer(5),
                              new Integer(6), 
                              new Integer(3),
                              new Integer(4),
                              new Integer(14),
                              new Integer(13),
                              new Integer(32),
                              new Integer(7),
                              new Integer(8)};
                              
                           
      System.out.println("Chaines a trier :");
      TriBulleTableau.afficher(tabString);
      TriBulleTableau.trier(tabString);
      System.out.println("\n\nChaines triees:");
      TriBulleTableau.afficher(tabString);
                              
      System.out.println("\n\n\nEntiers a trier :");
      TriBulleTableau.afficher(tabInteger);
      TriBulleTableau.trier(tabInteger);
      System.out.println("\n\nEntiers tries:");
      TriBulleTableau.afficher(tabInteger);
      
      Clavier.readString();
   }
}