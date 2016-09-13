// ==========================================================================
// TestNotes1 : Test des lectures et des ecritures.
// ==========================================================================

import java.io.*;

public class TestNotes1
{
   public static void main(String args[]) throws IOException
   {
      File dossier;
      File fichierEntree;
      File fichierSortie;

      String ligne;

// --------------------------------------------------------------------------
// Ouverture des flux
// --------------------------------------------------------------------------
      dossier = new File("..\\fichiers");
      fichierEntree = new File(dossier, "notes.txt");
      fichierSortie = new File(dossier, "resultats.txt");

      try
      {
         BufferedReader entree = new BufferedReader(new FileReader(fichierEntree));
         PrintWriter    sortie = new PrintWriter(new FileWriter(fichierSortie));

         try
         {
            ligne = entree.readLine();

            while (ligne != null)
            {
               sortie.println("ligne lue : " + ligne);
               ligne = entree.readLine();
            }
         }
         finally
         {
            entree.close();
            sortie.close();
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Le fichier " + fichierEntree.getName() +
                            " est inconnu.");
      }
   }
}
