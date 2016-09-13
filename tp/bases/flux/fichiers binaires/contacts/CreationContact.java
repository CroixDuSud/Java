// ==========================================================================
// CreationContact : Creation du fichier des contacts (contacts.dat)
// --------------------------------------------------------------------------
// Ce fichier binaire est cree en lisant le fichier texte contactsTries.txt
// ==========================================================================

import java.io.*;
import utilitairesMG.divers.*;
import java.util.*;

public class CreationContact
{
   public static void main(String args[]) throws IOException
   {

// --------------------------------------------------------------------------
// Variables pour la lecture et l'analyse du fichier texte en entree :
// --------------------------------------------------------------------------
      BufferedReader entree;
      String ligne;

      StringTokenizer token;
      String mot;
      int n;

// --------------------------------------------------------------------------
// Variables pour l'ecriture dans le fichier binaire en sortie :
// --------------------------------------------------------------------------
      FichierContact fc;
      Contact contact;
      
// --------------------------------------------------------------------------
// Ouverture des fichiers et debut de la boucle de lecture/ecriture :
// --------------------------------------------------------------------------
      entree = new BufferedReader(new FileReader("contactsTries.txt"));
      
      try
      {
         fc = new FichierContact("contacts.dat", "rw");
         
         try
         {
            ligne = entree.readLine();
            
            while (ligne != null)
            {
               
// --------------------------------------------------------------------------
// Creation du contact correspondant a la ligne lue
// --------------------------------------------------------------------------
               contact = new Contact();
         
// --------------------------------------------------------------------------
// Traitement de la ligne lue :
// --------------------------------------------------------------------------
               token = new StringTokenizer(ligne, ";");

// --------------------------------------------------------------------------
// Extraction des proprietes du Contact :
// --------------------------------------------------------------------------
               mot = token.nextToken();
               n = Integer.parseInt(mot);
               contact.setNumero(n);
               
               mot = token.nextToken();
               contact.setNom(mot);
               
               mot = token.nextToken();
               contact.setAdresse(mot);
               
               mot = token.nextToken();
               contact.setCodePostal(mot);
               
               mot = token.nextToken();
               contact.setVille(mot);
               
               mot = token.nextToken();
               n = Integer.parseInt(mot);
               contact.setCodeSecteur(n);
               
// --------------------------------------------------------------------------
// Ecriture dans le fichier binaire :
// --------------------------------------------------------------------------
               System.out.println(contact);
               fc.ecrire(contact);
      
               ligne = entree.readLine();
           }
         }
         finally
         {
            fc.close();
         }
      }
      finally
      {
         entree.close();
      }
      Clavier.readString();
   }
}