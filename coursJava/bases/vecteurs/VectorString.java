// ==========================================================================
// APPLICATION VectorString
// --------------------------------------------------------------------------
// Vecteur ne contenant que des String
// ==========================================================================

import java.util.*;  // Pour la classe Vector


public class VectorString
{
   public static void main(String argv[])
   { 
      int i; 
      
// --------------------------------------------------------------------------
// Instanciation d'un Vector :
// --------------------------------------------------------------------------
      Vector<String> vecteur = new Vector<String>();  

// --------------------------------------------------------------------------
// Création des postes du Vector :
// --------------------------------------------------------------------------
      vecteur.addElement("Fumier Infect !"); 
      vecteur.addElement("Ridicule"); 
      vecteur.addElement("Crapule");

// --------------------------------------------------------------------------
// Remarque :
//
// L'ajout d'un element d'un type different de String provoque une erreur de
// compilation :  
//    
//      vecteur.addElement(new StringBuffer("ORDURE !"));
//
// VectorString.java:27: addElement(java.lang.String) in 
// java.util.Vector<java.lang.String> cannot be applied to 
// (java.lang.StringBuffer)
//      vecteur.addElement(new StringBuffer("ORDURE !"));
//             ^
// 1 error
// --------------------------------------------------------------------------
      
// --------------------------------------------------------------------------
// Affichage du vecteur :
// --------------------------------------------------------------------------
      System.out.println("\nChaines : \n");

      for (i = 0; i < vecteur.size(); i++)
      {
         System.out.println("vecteur.elementAt(" + i + ") = " + 
                            vecteur.elementAt(i));     
      }
       
// --------------------------------------------------------------------------
// Affichage des chaines en majuscules :
// --------------------------------------------------------------------------
      System.out.println("\nChaines en majuscules : \n");

      for (i = 0; i < vecteur.size(); i++)
      {
         System.out.println(vecteur.elementAt(i).toUpperCase());     
      }
   }
}
