// ==========================================================================
// APPLICATION TestComparableErreur
// --------------------------------------------------------------------------
// Exemple d'utilisation de l'interface Comparable pour faire un tri.
// Pour pouvoir utiliser la methode trier() de la classe TriBulle,
// le tableau doit etre un tableau de references d'objets d'une classe
// implementant l'interface Comparable.
// --------------------------------------------------------------------------
// Essai avec un tableau d'objets n'implementant pas l'interface Comparable.
// Remarque : c'est la reference du tableau (de type Object) qui est prise
// en compte par le compilateur, et non les instances (de type Integer).
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;

public class TestComparableErreur
{
   public static void main(String argv[]) throws IOException
   {  
      Object tabObject[] = {new Integer(21),
                            new Integer(3)};
                              
      System.out.println("\n\n\nObjets a trier :");
      TriBulleTableau.afficher(tabObject);
      TriBulleTableau.trier(tabObject);
      System.out.println("\n\nObjets tries:");
      TriBulleTableau.afficher(tabObject);
   }
}