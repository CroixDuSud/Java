// ==========================================================================
// package utilitairesMG.jdbc
// --------------------------------------------------------------------------
// Classe BaseDeDonnees
// --------------------------------------------------------------------------
// Un objet BaseDeDonnees contient un nom de base de donnees (nomBase).
// Il possede une Connection et une seule (connexion).
// ==========================================================================

package utilitairesMG.jdbc;

import java.util.*;
import java.sql.*;

public class BaseDeDonnees
{

// ==========================================================================
// PROPRIETES
// --------------------------------------------------------------------------
// nomBase : nom de la base (adresse de connexion).
//    Exemple :
//    "jdbc:sqlserver://mars;user=UTIL_BIP;password=x;databasename=gnmi"
//
// connexion : connexion avec la base de donnees
// ==========================================================================
   private String nomBase;
   private Connection connexion;
   private String formatDate = "dd/MM/yyyy";
   private String url;
   private String user;
   private String password;

// ==========================================================================
// Constructeurs
// --------------------------------------------------------------------------
// Le constructeur prend comme parametre une chaine qui contient l'adresse de
// connexion (idem que la methode getConnection() de DriverManager.
//
// Exemple :
// "jdbc:sqlserver://mars;user=UTIL_BIP;password=x;databasename=gnmi"
//
// Remarque : le driver (ici com.microsoft.sqlserver.jdbc.SQLServerDriver)
// est charge en dehors de la classe BaseDeDonnees.
// --------------------------------------------------------------------------
// Le constructeur par defaut sert quand on utilise un Pool de Connexions,
// par exemple avec les EJB Session.
// ==========================================================================
   public BaseDeDonnees(String nomBase)
   {
      this.nomBase = nomBase;
   }

    public BaseDeDonnees(String url, String user, String password) 
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }
   
   public BaseDeDonnees()
   {
   }

// ==========================================================================
// Set du format des donnees 'DATE' (par defaut : "dd/MM/yyyy")
// ==========================================================================
   public void setFormatDate(String formatDate)
   {
      this.formatDate = formatDate;
   }

// ==========================================================================
// Get du format des donnees 'DATE'
// ==========================================================================
   public String getFormatDate()
   {
      return formatDate;
   }

// ==========================================================================
// Methode d'ouverture d'une connexion
// --------------------------------------------------------------------------
// Une connexion n'est ouverte que si elle n'est pas deja ouverte.
//
// Le return permet de recuperer la connexion pour utiliser des methodes de
// l'interface Connection...
// ==========================================================================
   public Connection getConnection() throws SQLException
   {
      if ((connexion == null) || (connexion.isClosed()))
      {
         DriverManager.setLoginTimeout(10);
         connexion = DriverManager.getConnection(nomBase);
      }
      return connexion;
   }

   public Connection getConnectionBis() throws SQLException
   {
      if ((connexion == null) || (connexion.isClosed()))
      {
         DriverManager.setLoginTimeout(10);
         connexion = DriverManager.getConnection(url, user, password);
      }
      return connexion;
   }

   public void setConnection(Connection connexion)
   {
      this.connexion = connexion;
   }

// ==========================================================================
// Methode de fermeture de la connexion
// --------------------------------------------------------------------------
// Une connexion n'est fermee que si elle n'est pas deja fermee.
// ==========================================================================
   public void closeConnection() throws SQLException
   {
      if ((connexion != null) && (!connexion.isClosed()))
      {
         connexion.close();
      }
   }

// ==========================================================================
// executeQuery (SELECT)
// --------------------------------------------------------------------------
// Cette methode retourne le jeu de resultats obtenu par le Select
// --------------------------------------------------------------------------
// Principe de traitement d'une requete SQL :
//
//     creation du Statement,
//     execution de la requete,
//     fermeture du ResultSet (si Select)
//     fermeture du Statement,
//
// Les objets Connection, Statement, ResultSet sont perdus quand on les
// ferme... Le resultat d'une requete SELECT doit donc etre tranfere du
// ResultSet dans un objet de type JeuResultat.
// ==========================================================================
   public JeuResultat executeQuery(String select) throws SQLException
   {
      Statement traitement;
      ResultSet resultats;
      JeuResultat jeuResultat;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
// Losqu'on laisse passer un select vide, le executeQuery se plante, il
// y a envoi du message : "Il n'y a pas de donnees a transmettre" par
// SQL*Server. A partir de ce moment, tous les executeQuery se plantent avec
// le message : "Cette operation exige une seule connexion utilisateur".
// --------------------------------------------------------------------------
      if (select.compareTo("") == 0)
      {
         throw new SQLException("Requete vide");
      }

// --------------------------------------------------------------------------
// Creer le Statement, executer le SELECT.
// --------------------------------------------------------------------------
// Les try imbriques sont necessaires pour fermer correctement toutes les
// ressources qui ont ete ouvertes, meme en cas d'erreur (SQLException).
// Les exceptions sont renvoyees au programme appelant pour qu'il puisse a
// son tour les traiter.
// --------------------------------------------------------------------------
      traitement = connexion.createStatement();

      try
      {
         resultats = traitement.executeQuery(select);

         try
         {
            jeuResultat = new JeuResultat(resultats);
            return jeuResultat;
         }
         catch(SQLException e)
         {
            throw new SQLException("Erreur creation JeuResultat : " +
                                   e.getMessage());
         }
         finally
         {
            resultats.close();
         }
      }
      finally
      {
         traitement.close();
      }
   }

// ==========================================================================
// executeUpdate (INSERT, DELETE, UPDATE)
// --------------------------------------------------------------------------
// Cette methode retourne le nombre de lignes concernees par la requete
// ==========================================================================
   public int executeUpdate(String requete) throws SQLException
   {
      Statement traitement;
      int rowCount = 0;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
      if (requete.compareTo("") == 0)
      {
         throw new SQLException("Requete vide");
      }

// --------------------------------------------------------------------------
// Creer le Statement, executer la requete.
// --------------------------------------------------------------------------
      traitement = connexion.createStatement();

      try
      {
         rowCount = traitement.executeUpdate(requete);
      }
      finally
      {
         traitement.close();
      }

      return rowCount;
   }

// ==========================================================================
// getTables
// --------------------------------------------------------------------------
// Cette methode retourne la liste des tables de la base stockee dans un
// vecteur.
// ==========================================================================
   public Vector<String> getTables() throws SQLException
   {
      DatabaseMetaData meta;
      ResultSet rs;
      Vector<String> lTables = null;

// --------------------------------------------------------------------------
// Recuperer les MetaData de la base, remplir un ResultSet contenant les noms
// des tables, transferer dans un modele de liste (qui servira a initialiser
// une JList)
// --------------------------------------------------------------------------
      meta = connexion.getMetaData();

      rs = meta.getTables(null, null, null, new String[]{"TABLE"});
      lTables = new Vector<String>();

      try
      {
         while (rs.next())
         {
            lTables.addElement(rs.getString(3));
         }
      }
      finally
      {
         rs.close();
      }

      return lTables;
   }

// ==========================================================================
// executeQueryXML (SELECT)
// --------------------------------------------------------------------------
// Cette methode retourne le jeu de resultats obtenu par le Select, sous
// forme XML
// ==========================================================================
   public JeuResultatXML executeQueryXML(String select) throws SQLException
   {
      Statement traitement;
      ResultSet resultats;
      JeuResultatXML jeuResultat;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
// Losqu'on laisse passer un select vide, le executeQuery se plante, il
// y a envoi du message : "Il n'y a pas de donnees a transmettre" par
// SQL*Server. A partir de ce moment, tous les executeQuery se plantent avec
// le message : "Cette operation exige une seule connexion utilisateur".
// --------------------------------------------------------------------------
      if (select.compareTo("") == 0)
      {
         throw new SQLException("Requete vide");
      }

// --------------------------------------------------------------------------
// Creer le Statement, executer le SELECT.
// --------------------------------------------------------------------------
// Les try imbriques sont necessaires pour fermer correctement toutes les
// ressources qui ont ete ouvertes, meme en cas d'erreur (SQLException).
// Les exceptions sont renvoyees au programme appelant pour qu'il puisse a
// son tour les traiter.
// --------------------------------------------------------------------------
      traitement = connexion.createStatement();

      try
      {
         resultats = traitement.executeQuery(select);

         try
         {
            jeuResultat = new JeuResultatXML(resultats);
            return jeuResultat;
         }
         catch(SQLException e)
         {
            throw new SQLException("Erreur creation JeuResultatXML : " +
                                   e.getMessage());
         }
         finally
         {
            resultats.close();
         }
      }
      finally
      {
         traitement.close();
      }
   }
}
