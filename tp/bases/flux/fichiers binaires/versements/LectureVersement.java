// ==========================================================================
// LectureVersement : Lecture d'un fichier "versements" dont le nom est saisi 
//                    au clavier
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class LectureVersement
{
   public static void main(String args[]) throws IOException
   {
      
// --------------------------------------------------------------------------
// Variables pour la lecture du fichier binaire :
// --------------------------------------------------------------------------
      String nomFichier;
      FichierVersement fv;
      Versement versement;
      
      Vector<Versement> listeVersements;
      
// --------------------------------------------------------------------------
// Nom du fichier a lister
// --------------------------------------------------------------------------
      nomFichier = "versements.dat";
      
      try
      {
         fv = new FichierVersement(nomFichier, "r");
         
         try
         {
            System.out.println("\n\nContenu du fichier " + 
                               nomFichier + "\n");
            listeVersements = fv.lireListe();
            
            for(int i = 0; i < listeVersements.size(); i++)
            {
               System.out.println(listeVersements.elementAt(i));
            }
         }
         finally
         {
            fv.close();
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Le fichier " + nomFichier + " est inconnu.");                            
      }
      
      Clavier.readString();
   }
}