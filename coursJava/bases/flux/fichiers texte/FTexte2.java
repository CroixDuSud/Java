// ==========================================================================
// FTexte2 : classes FileReader et FileWriter
// --------------------------------------------------------------------------
// Recopie d'un fichier.
// --------------------------------------------------------------------------
// Les classes FileReader et FileWriter permettent de lire et d'ecrire des
// fichiers textes en utilisant le codage par defaut de la plateforme. Sous
// Windows c'est le codage CP1252 (ISO-8859-1 plus quelques caracteres
// speciaux (€ : 80).
// ==========================================================================

import java.io.*;

public class FTexte2
{
   public static void main(String args[]) throws IOException
   {

// --------------------------------------------------------------------------
// "dossierEntree" indique l'emplacement du fichier a lire.
// --------------------------------------------------------------------------
// "fichierEntree" indique le nom du fichier a lire.
// --------------------------------------------------------------------------
// "dossierSortie" indique l'emplacement du fichier a ecrire.
// --------------------------------------------------------------------------
// "fichierSortie" indique le nom du fichier a ecrire. Ce fichier sera mis
// sur le repertoire courant.
// --------------------------------------------------------------------------
// "entree" est la reference d'un flux d'entree de fichier texte.
// --------------------------------------------------------------------------
// "sortie" est la reference d'un flux de sortie de fichier texte.
// --------------------------------------------------------------------------
// "caractere" est le caractere lu par la methode read() de InputStreamReader
// qui retourne un entier. On ecrira cet entier par la methode write() de
// OutputStreamWriter.
// --------------------------------------------------------------------------
      File dossierEntree;
      File fichierEntree;
      File dossierSortie;
      File fichierSortie;
      FileReader entree;
      FileWriter sortie;

      int caractere;

// --------------------------------------------------------------------------
// Ouverture des flux
// --------------------------------------------------------------------------
      dossierEntree =
        //new File("R:\\java\\cours\\bases\\flux\\fichiers texte\\fichiers");
        new File("..\\fichiers");
      fichierEntree = new File(dossierEntree, "texteCP1252.txt");

      dossierSortie = new File("..\\fichiers");

      fichierSortie = new File(dossierSortie, "copieTexteCP1252.txt");

      System.out.println("Entree : " + fichierEntree.getAbsolutePath());
      System.out.println("Sortie : " + fichierSortie.getAbsolutePath());

// --------------------------------------------------------------------------
// L'ouverture du flux FileReader peut provoquer une FileNotFoundException.
// Cette exception herite de IOException.
// --------------------------------------------------------------------------
// L'ouverture du flux FileWriter peut provoquer une IOException.
// --------------------------------------------------------------------------
      try
      {
         entree = new FileReader(fichierEntree);
         sortie = new FileWriter(fichierSortie);

// --------------------------------------------------------------------------
// Boucle de recopie.
// --------------------------------------------------------------------------
         try
         {
            System.out.println("\nDebut de la recopie du fichier " +
                               fichierEntree.getName());

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

         System.out.println("\nFin de la recopie du fichier " +
                            fichierEntree.getName() + "\n" +
                            fichierSortie.length() + " octets recopies");
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Le fichier " + fichierEntree.getAbsolutePath() +
                            " n'existe pas");
      }
   }
}