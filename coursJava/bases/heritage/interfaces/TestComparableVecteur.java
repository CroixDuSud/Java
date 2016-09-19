// ==========================================================================
// APPLICATION TestComparableVecteur
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestComparableVecteur
{
   public static void main(String argv[]) throws IOException
   {

// --------------------------------------------------------------------------
// La methode trier(Vector<Comparable> vecteur) de la classe TriBulleVecteur 
// a pour parametre un vecteur type en Comparable. 
// Elle pourra donc trier n'importe quel vecteur d'objets d'une classe qui 
// implemente l'interface Comparable (qui possede donc la methode compareTo). 
// --------------------------------------------------------------------------
// C'est le cas des classes Integer et String.
// --------------------------------------------------------------------------
// ATTENTION !!!
// --------------------------------------------------------------------------
// Un vecteur type en String (Vector<String>) ne marchera pas. En effet, meme
// si String implemente Comparable, un Vector<String> n'est pas un 
// Vector<Comparable>. L'heritage et l'implementation ne marchent pas avec le
// typage. Meme Vector<Object> ne marche pas !
//
// Solution : mettre Vector<Comparable> ou simplement Vector (n'importe quel
// Vector type est un Vector). 
// --------------------------------------------------------------------------
      Vector<Comparable> vecteurString = new Vector<Comparable>();
      
      vecteurString.addElement("Martin");
      vecteurString.addElement("Jacques");
      vecteurString.addElement("Paul");
      vecteurString.addElement("Albert");
      vecteurString.addElement("Nathalie");
      vecteurString.addElement("Nadia");
      vecteurString.addElement("Ali");
      vecteurString.addElement("Morad");
      vecteurString.addElement("Albert");
      vecteurString.addElement("Jean");
      vecteurString.addElement("Louis");
      vecteurString.addElement("Jean");

      Vector<Comparable> vecteurInteger = new Vector<Comparable>();
      
      vecteurInteger.addElement(6);
      vecteurInteger.addElement(17);
      vecteurInteger.addElement(5);
      vecteurInteger.addElement(6);
      vecteurInteger.addElement(3);
      vecteurInteger.addElement(4);
      vecteurInteger.addElement(14);
      vecteurInteger.addElement(13);
      vecteurInteger.addElement(32);
      vecteurInteger.addElement(7);
      vecteurInteger.addElement(8);
                           
      System.out.println("Chaines a trier :");
      TriBulleVecteur.afficher(vecteurString);
      TriBulleVecteur.trier(vecteurString);
      System.out.println("\n\nChaines triees:");
      TriBulleVecteur.afficher(vecteurString);

      System.out.println("\n\n\nEntiers a trier :");
      TriBulleVecteur.afficher(vecteurInteger);
      TriBulleVecteur.trier(vecteurInteger);
      System.out.println("\n\nEntiers tries:");
      TriBulleVecteur.afficher(vecteurInteger);
      
      Clavier.readString();
   }
}