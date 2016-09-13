// ==========================================================================
// CLASSE TestContacts                                        Projet Contacts
// --------------------------------------------------------------------------
// Lecture d'un fichier texte, tri et ecriture formatee dans un autre.
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestContacts
{
   public static void main(String args[]) throws IOException
   {
      String ligne;
      BufferedReader entree;
      PrintWriter sortie;
      
      Vector<Comparable> vecteur = new Vector<Comparable>();
      Contact contact;
      
      StringTokenizer token;
      String mot;
      int n;
      
      entree = new BufferedReader(new FileReader("contacts.csv"));
      sortie = new PrintWriter(new FileWriter("contactsTries.txt"));
      ligne = entree.readLine();
      
      while (ligne != null)
      {
// --------------------------------------------------------------------------
// Creation du contact correspondant a la ligne lue
// --------------------------------------------------------------------------
         contact = new Contact();
         
// --------------------------------------------------------------------------
// Traitement de la ligne lue
// --------------------------------------------------------------------------
         token = new StringTokenizer(ligne, ";");

// --------------------------------------------------------------------------
// Extraction des proprietes du Contact et modification du Contact
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
// Ajout au vecteur
// --------------------------------------------------------------------------
         vecteur.addElement(contact);
         ligne = entree.readLine();
      }

// --------------------------------------------------------------------------
// Affichage
// --------------------------------------------------------------------------
      System.out.println("Contacts avant tri : \n");
      TriBulleVecteur.afficher(vecteur);

      System.out.println("\n\nContacts apres tri : \n");
      TriBulleVecteur.trier(vecteur);
      TriBulleVecteur.afficher(vecteur);

// --------------------------------------------------------------------------
// Ecriture dans le fichier texte
// --------------------------------------------------------------------------
      for (int i = 0; i < vecteur.size(); i++)
      {
         sortie.println(vecteur.elementAt(i)); 
      }

      entree.close();
      sortie.close();
   }
}