// ==========================================================================
// FTexte4 : classes BufferedReader et BufferedWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier. Lecture en CP1252, ecriture en UTF-16.
// ==========================================================================

import java.io.*;

public class FTexte4
{
   public static void main(String args[]) throws IOException
   {
      File dossier;
      File fichierEntree;
      File fichierSortie;

      BufferedReader entree;
      BufferedWriter sortie;

      String chaine;

// --------------------------------------------------------------------------
// Ouverture des flux
// --------------------------------------------------------------------------
      dossier = new File("..\\fichiers");
      fichierEntree = new File(dossier, "texteCP1252.txt");
      fichierSortie = new File(dossier, "texteUTF16.txt");

      try
      {
         entree = new BufferedReader(
                     new InputStreamReader(
                        new FileInputStream(fichierEntree)));
         sortie = new BufferedWriter(
                     new OutputStreamWriter(
                        new FileOutputStream(fichierSortie), "UTF-16"));

// --------------------------------------------------------------------------
// Boucle de recopie.
// --------------------------------------------------------------------------
         try
         {
            System.out.println("\nDebut de la recopie du fichier");

            chaine = entree.readLine();

            while (chaine != null)
            {
               sortie.write(chaine);
               sortie.newLine();
               chaine = entree.readLine();
            }
         }

// --------------------------------------------------------------------------
// Fermeture des fichiers.
// --------------------------------------------------------------------------
         finally
         {
            entree.close();
            sortie.close();
         }

         System.out.println("\nFin de la recopie du fichier");
      }
      catch(FileNotFoundException e)
      {
         System.out.println(e.getMessage());
      }
   }
}