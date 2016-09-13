// ==========================================================================
// LectureContact : Lecture d'un fichier "contacts" dont le nom est saisi au 
//                  clavier
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class LectureContact
{
   public static void main(String args[]) throws IOException
   {
      
// --------------------------------------------------------------------------
// Variables pour la lecture du fichier binaire :
// --------------------------------------------------------------------------
      String nomFichier;
      FichierContact fc;
      Contact contact;
      
      Vector<Contact> listeContacts;
      
// --------------------------------------------------------------------------
// Saisie du nom du fichier a lister
// --------------------------------------------------------------------------
      System.out.print("Entrer le nom du fichier a lister : ");
      nomFichier = Clavier.readString();
      
      try
      {
         fc = new FichierContact(nomFichier, "r");
         
         try
         {
            System.out.println("\n\nContenu du fichier " + 
                               nomFichier + "\n");
            listeContacts = fc.lireListe();
            
            for(int i = 0; i < listeContacts.size(); i++)
            {
               System.out.println(listeContacts.elementAt(i));
            }
         }
         finally
         {
            fc.close();
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Le fichier " + nomFichier + " est inconnu.");                            
      }
      
      Clavier.readString();
   }
}