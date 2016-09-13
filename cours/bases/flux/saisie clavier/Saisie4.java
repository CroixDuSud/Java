// ==========================================================================
// Saisie4 : essai de saisies au clavier
// ==========================================================================

import java.io.*;

public class Saisie4
{
   public static void main(String args[]) throws IOException
   {
      int codeCaractere;
      char caractere;
      String ligne;

      BufferedReader entree = 
         new BufferedReader(new InputStreamReader(System.in));

// --------------------------------------------------------------------------
// Appels de la méthode read() de la classe BufferedReader...
// --------------------------------------------------------------------------
      codeCaractere = entree.read();
      caractere = (char) codeCaractere;
      System.out.println("Vous venez de taper : " + caractere  
                                                  +  "  " 
                                                  + codeCaractere);
                                                  
      codeCaractere = entree.read();
      caractere = (char) codeCaractere;
      System.out.println("Vous venez de taper : " + caractere  
                                                  +  "  " 
                                                  + codeCaractere);
                                                  
// --------------------------------------------------------------------------
// Appel de la méthode readLine de la classe BufferedReader.
// --------------------------------------------------------------------------
      ligne = entree.readLine();                                            
      System.out.println("Vous venez de taper : " + ligne); 
      
// --------------------------------------------------------------------------
// la fermeture du flux, qui doit terminer l'utilisation du flux,
// est ici inutile, car il s'agit de System.in... 
// --------------------------------------------------------------------------
      entree.close();
   }
}