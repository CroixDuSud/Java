// ==========================================================================
// CreationVersement : Creation du fichier des versements (versements.dat)
// --------------------------------------------------------------------------
// Ce fichier binaire est cree en lisant le fichier texte versements.txt
// ==========================================================================

import java.io.*;
import java.text.*;
import utilitairesMG.divers.*;
import java.util.*;

public class CreationVersement
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
      FichierVersement fv;
      Versement versement;

// --------------------------------------------------------------------------
// Vecteur pour trier les versements par date avant creation du fichier :
// --------------------------------------------------------------------------
      Vector<Comparable> vVersements = new Vector<Comparable>();
      
// --------------------------------------------------------------------------
// Ouverture des fichiers et debut de la boucle de lecture/ecriture :
// --------------------------------------------------------------------------
      entree = new BufferedReader(new FileReader("versements.txt"));
      
// --------------------------------------------------------------------------
// Remplissage du vecteur d'objets Versement :
// --------------------------------------------------------------------------
      try
      {
         ligne = entree.readLine();
         
         while (ligne != null)
         {
               
// --------------------------------------------------------------------------
// Creation du contact correspondant a la ligne lue
// --------------------------------------------------------------------------
            versement = new Versement();
         
// --------------------------------------------------------------------------
// Traitement de la ligne lue :
// --------------------------------------------------------------------------
            token = new StringTokenizer(ligne, ";");

// --------------------------------------------------------------------------
// Extraction des proprietes du Contact :
// --------------------------------------------------------------------------
            mot = token.nextToken();
            n = Integer.parseInt(mot);
            versement.setNumero(n);
            
            mot = token.nextToken();
            try
            {
               DateFr dateFr = new DateFr(mot);
               versement.setDate(dateFr.getTime());
            }
            catch(ParseException e)
            {
            }
            
            mot = token.nextToken();
            versement.setMontant(Conversion.chaineDouble(mot));
            
            mot = token.nextToken();
            n = Integer.parseInt(mot);
            versement.setNumeroContact(n);
               
// --------------------------------------------------------------------------
// Ajout du Versement au vecteur :
// --------------------------------------------------------------------------
            System.out.println(versement);
            vVersements.addElement(versement);
        
            ligne = entree.readLine();
         }   
           
// --------------------------------------------------------------------------
// Tri du vecteur :
// --------------------------------------------------------------------------
         TriBulleVecteur.trier(vVersements);
           
// --------------------------------------------------------------------------
// Recopie du vecteur de Versements dans le fichier binaire :
// --------------------------------------------------------------------------
         fv = new FichierVersement("versements.dat", "rw");
         
         try
         {
            for(int i = 0; i < vVersements.size(); i++)
            {
               fv.ecrire((Versement)vVersements.elementAt(i));
            }
         }
         finally
         {
            fv.close();
         }
      }
      finally
      {
         entree.close();
      }
      
      Clavier.readString();
   }
}