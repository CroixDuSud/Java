// ==========================================================================
// package daoServeurJdbcMapping
// --------------------------------------------------------------------------
// CLASSE SecteurDAO
// ==========================================================================

package daoServeurJdbcMapping;

import java.io.*;
import java.util.*;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;
import metierMapping.*;

public class SecteurDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================


// --------------------------------------------------------------------------
// Reference de la machine (adresse IP) et du port du serveur (objet de type
// PriseServeurJdbc).
// --------------------------------------------------------------------------
   private static PriseServeurJdbc priseServeur;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table contact et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
   private static JeuResultat jeuResultat;



// ==========================================================================
// METHODES
// ==========================================================================

// --------------------------------------------------------------------------
// Constructeur.
// --------------------------------------------------------------------------
   public SecteurDAO(PriseServeurJdbc priseServeur)
   {
      this.priseServeur = priseServeur;
   }

// --------------------------------------------------------------------------
// Lecture d'un objet Secteur (dont la clef est renseignee)
// --------------------------------------------------------------------------
   public void lire(Secteur secteur) throws IOException,
                                            ClassNotFoundException
   {
      int rowCount;

      String select;
      Vector<Object> ligne;

      select = "SELECT * FROM SECTEUR WHERE CODE = " + secteur.getCode();

      priseServeur.getConnection();

      try
      {
         jeuResultat = priseServeur.executeQuery(select);
      }
      finally
      {
         priseServeur.closeConnection();
      }

      rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------

      if(rowCount == 1)
      {
         ligne = (jeuResultat.getLignes()).elementAt(0);

         secteur.setLibelle((String)ligne.elementAt(1));
      }
      else
      {
         if (rowCount == 0)
         {
            throw new IOException("Secteur " + secteur.getCode() + " inconnu");
         }
         else
         {
            throw new IOException("Clef " + secteur.getCode() + " en double !");
         }
      }
   }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Secteur
// --------------------------------------------------------------------------
   public int creer(Secteur secteur) throws IOException,
                                            ClassNotFoundException
   {
      int rowCount;
      String insert;

      Integer code = secteur.getCode();
      String libelle = secteur.getLibelle();

      insert = "INSERT INTO SECTEUR VALUES(" +
                  code                            + ", "  +
                  Conversion.chaineSQL(libelle)   + ")";

      priseServeur.getConnection();

      try
      {
         rowCount = priseServeur.executeUpdate(insert);
      }
      finally
      {
         priseServeur.closeConnection();
      }
      return rowCount;
   }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Secteur
// --------------------------------------------------------------------------
   public int modifier(Secteur secteur) throws IOException,
                                               ClassNotFoundException
   {
      int rowCount;
      String update;

      Integer code = secteur.getCode();
      String libelle = secteur.getLibelle();

      update = "UPDATE SECTEUR SET " +
                  "LIBELLE = "    + Conversion.chaineSQL(libelle) + " " +
               "WHERE CODE = " + code;

      priseServeur.getConnection();

      try
      {
         rowCount = priseServeur.executeUpdate(update);
      }
      finally
      {
         priseServeur.closeConnection();
      }

      return rowCount;
   }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Secteur
// --------------------------------------------------------------------------
   public int detruire(Secteur secteur) throws IOException,
                                               ClassNotFoundException
   {
      int rowCount;
      String delete;

      Integer code = secteur.getCode();

      delete = "DELETE FROM SECTEUR WHERE CODE = " + code;

      priseServeur.getConnection();

      try
      {
         rowCount = priseServeur.executeUpdate(delete);
      }
      finally
      {
         priseServeur.closeConnection();
      }
      return rowCount;
   }

// --------------------------------------------------------------------------
// Lecture d'un Secteur, pour un Contact donne
// --------------------------------------------------------------------------
   public Secteur lireSecteur(Contact contact)
                  throws IOException, ClassNotFoundException
   {
      Secteur secteur = new Secteur();
      secteur.setCode(contact.getCodeSecteur());

      priseServeur.getConnection();

      try
      {
         lire(secteur);
      }
      finally
      {
         priseServeur.closeConnection();
      }
      return secteur;
   }

// --------------------------------------------------------------------------
// Liste des secteurs
// --------------------------------------------------------------------------
   public  Vector<Secteur> lireListe()
                           throws IOException, ClassNotFoundException
   {
      Vector<Secteur> listeSecteurs;
      Secteur secteur;

      String select = "SELECT * FROM SECTEUR";

      int nombreSecteurs;
      Vector ligne;
      int i;

      priseServeur.getConnection();

      try
      {
         jeuResultat = priseServeur.executeQuery(select);
       }
      finally
      {
         priseServeur.closeConnection();
      }

      listeSecteurs = new Vector<Secteur>();
      nombreSecteurs = (jeuResultat.getLignes()).size();

      for (i = 0; i < nombreSecteurs; i++)
      {
         ligne = (jeuResultat.getLignes()).elementAt(i);

         secteur = new Secteur();
         secteur.setCode((Integer)ligne.elementAt(0));
         secteur.setLibelle((String)ligne.elementAt(1));

         listeSecteurs.addElement(secteur);
      }
      return listeSecteurs;
   }

// --------------------------------------------------------------------------
// Liste des colonnes de la table SECTEUR
// --------------------------------------------------------------------------
   public Vector<Colonne> getListeColonnes()
   {
      return jeuResultat.getColonnes();
   }
}
