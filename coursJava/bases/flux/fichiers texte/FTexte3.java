// ==========================================================================
// FTexte3 : classes InputStreamReader et OutPutStreamWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier. Lecture en CP1252, ecriture en UTF-8.
// --------------------------------------------------------------------------
// Les classes InputStreamReader et OutPutStreamWriter permettent de lire et
// d'ecrire des fichiers textes en choisissant le codage a utiliser.
// ==========================================================================

import java.io.*;

public class FTexte3
{
   public static void main(String args[]) throws IOException
   {
      File dossier;
      File fichierEntree;
      File fichierSortie;

      InputStreamReader entree;
      OutputStreamWriter sortie;

      int caractere;

// --------------------------------------------------------------------------
// Ouverture des flux
// --------------------------------------------------------------------------
      dossier = new File("..\\fichiers");
      fichierEntree = new File(dossier, "texteCP1252.txt");
      fichierSortie = new File(dossier, "texteUTF8.txt");

      try
      {

         entree = new InputStreamReader(
                     new FileInputStream(fichierEntree));
         sortie = new OutputStreamWriter(
                     new FileOutputStream(fichierSortie), "UTF-8");

// --------------------------------------------------------------------------
// Boucle de recopie.
// --------------------------------------------------------------------------
         try
         {
            System.out.println("\nDebut de la recopie du fichier");

            caractere = entree.read();

            while (caractere != -1)
            {
               sortie.write(caractere);
               caractere = entree.read();
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