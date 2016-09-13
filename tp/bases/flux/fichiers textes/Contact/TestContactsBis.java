// ==========================================================================
// CLASSE TestContacts                                        Projet Contacts
// --------------------------------------------------------------------------
// Lecture d'un fichier texte, tri et ecriture formatee dans un autre.
// ==========================================================================

import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;

public class TestContactsBis
{
   public static void main(String args[]) throws IOException
   {
      String ligne;
      BufferedReader entree;
      PrintWriter sortie;
      
      Vector<Comparable> vecteur = new Vector<Comparable>();
      ContactBis contact;
      
      StringTokenizer token;
      String mot;
      int num, cs;
      String nom, adr, ville, cp;
      
      entree = new BufferedReader(new FileReader("contacts.csv"));
      sortie = new PrintWriter(new FileWriter("contactsTriesBis.txt"));
      ligne = entree.readLine();
      
      while (ligne != null)
      {
         
// --------------------------------------------------------------------------
// Traitement de la ligne lue
// --------------------------------------------------------------------------
         token = new StringTokenizer(ligne, ";");

// --------------------------------------------------------------------------
// Extraction des proprietes du Contact et modification du Contact
// --------------------------------------------------------------------------
         mot = token.nextToken();
         num = Integer.parseInt(mot);
         
         nom = token.nextToken();
         
         adr = token.nextToken();
         
         cp = token.nextToken();
         
         ville = token.nextToken();
         
         mot = token.nextToken();
         cs = Integer.parseInt(mot);

// --------------------------------------------------------------------------
// Creation du contact correspondant a la ligne lue
// --------------------------------------------------------------------------
         contact = new ContactBis(num, nom, adr, cp, ville, cs);

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