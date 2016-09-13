// ==========================================================================
// FTexte1 : class File
// ==========================================================================

import java.io.*;

public class FTexte1
{
   public static void main(String args[]) throws IOException
   {
      File dossier;
      File fichier;

      dossier =
         new File("R:\\java\\cours\\bases\\flux\\fichiers texte\\fichiers");

      System.out.println(dossier.getAbsolutePath() + "\n");

      fichier = new File(dossier, "texteCP1252.txt");
      System.out.println(fichier.getAbsolutePath() + "\n");

      System.out.println("Taille du fichier " + fichier.getName() +
                         " : " + fichier.length() + " octets");
   }
}