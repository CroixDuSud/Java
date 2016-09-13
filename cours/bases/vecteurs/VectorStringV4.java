// ==========================================================================
// APPLICATION VectorStringV4
// --------------------------------------------------------------------------
// Vecteur ne contenant que des String
// ==========================================================================

import java.util.*;  // Pour la classe Vector


public class VectorStringV4
{
   public static void main(String argv[])
   { 
      int i; 
      
// --------------------------------------------------------------------------
// Instanciation d'un Vector :
// --------------------------------------------------------------------------
      Vector vecteur = new Vector();  

// --------------------------------------------------------------------------
// Création des postes du Vector :
// --------------------------------------------------------------------------
      vecteur.addElement("Fumier Infect !"); 
      vecteur.addElement("Ridicule"); 
      vecteur.addElement("Crapule");

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
         System.out.println(((String)vecteur.elementAt(i)).toUpperCase());     
      }
   }
}
