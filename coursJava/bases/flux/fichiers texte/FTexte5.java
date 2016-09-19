// ==========================================================================
// FTexte5 : classes BufferedReader et PrintWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier. Lecture en CP1252, ecriture en ISO-8859-1.
// ==========================================================================

import java.io.*;

public class FTexte5
{
   public static void main(String args[]) throws IOException
   {
      File dossier;
      File fichierEntree;
      File fichierSortie;

      BufferedReader entree;
      PrintWriter sortie;

      String chaine;

// --------------------------------------------------------------------------
// Ouverture des flux
// --------------------------------------------------------------------------
      dossier = new File("..\\fichiers");
      fichierEntree = new File(dossier, "texteCP1252.txt");
      fichierSortie = new File(dossier, "texteISO.txt");

      try
      {
         entree = new BufferedReader(
                     new InputStreamReader(
                        new FileInputStream(fichierEntree)));
         sortie = new PrintWriter(
                     new OutputStreamWriter(
                        new FileOutputStream(fichierSortie), "ISO-8859-1"));

// --------------------------------------------------------------------------
// Boucle de recopie.
// --------------------------------------------------------------------------
         try
         {
            System.out.println("\nDebut de la recopie du fichier");

            chaine = entree.readLine();

            while (chaine != null)
            {
               sortie.println(chaine);
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