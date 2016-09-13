// ==========================================================================
// CLASSE PriseServeurXML
// --------------------------------------------------------------------------
// Un objet de cette classe reference un serveur de type XML.
// Le constructeur recoit l'adreese IP et le port du serveur.
// ==========================================================================

import java.net.*;
import java.io.*;
import java.util.*;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class PriseServeurXML
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
   private String nomMachine;
   private int numeroPort;
   private String formatDate = "dd/MM/yyyy";

   private Socket socketReseau;
   private InputStreamReader entree;
   private InputSource sourceXml;
   private PrintWriter sortie;

// ==========================================================================
// Constructeur
// --------------------------------------------------------------------------
// Le constructeur prend deux parametres :
//
// nomMachine : nom (ou adresse IP) de la machine distante
// numeroPort : numero de port de l'application distante
// ==========================================================================
   public PriseServeurXML(String nomMachine, int numeroPort)
   {
      this.nomMachine = nomMachine;
      this.numeroPort = numeroPort;
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
// Methode d'ouverture d'une connexion avec le serveur
// --------------------------------------------------------------------------
// Une connexion n'est ouverte que si elle n'est pas deja ouverte.
//
// Le return permet de recuperer la Socket pour utiliser des methodes de
// la classe Socket...
// ==========================================================================
   public Socket getConnection() throws IOException
   {
      if ((socketReseau == null) || (socketReseau.isClosed()))
      {
         socketReseau = new Socket(nomMachine, numeroPort);

         sortie = new PrintWriter(
                     new OutputStreamWriter(
                        socketReseau.getOutputStream(), "utf-8"), true);

         entree = new InputStreamReader(
                     socketReseau.getInputStream(), "utf-8");

         sourceXml = new InputSource(entree);
      }

      return socketReseau;
   }

// ==========================================================================
// Methode de fermeture de la connexion
// --------------------------------------------------------------------------
// Une connexion n'est fermee que si elle n'est pas deja fermee.
// ==========================================================================
   public void closeConnection() throws IOException
   {
      if ((socketReseau != null) && (!socketReseau.isClosed()))
      {
         entree.close();
         sortie.close();
         socketReseau.close();
      }
   }

// ==========================================================================
// executeQuery (SELECT)
// --------------------------------------------------------------------------
// Cette methode retourne le jeu de resultats obtenu par le Select
// ou une exception si le select n'est pas correct
// ==========================================================================
   public JeuResultat executeQuery(String requete)
                      throws ParserConfigurationException,
                             SAXException,
                             IOException
   {
      JeuResultat jeuResultat;
      Vector<Colonne> colonnes;
      Vector<Vector<Object>> lignes;

// --------------------------------------------------------------------------
// Parseur du document XML qui sera recu et Ecouteur des evenements SAX
// --------------------------------------------------------------------------
      SAXParserFactory usineParseurXml;
      SAXParser parseurXml;
      EcouteurSAXQuery ecouteur;

// --------------------------------------------------------------------------
// Creation de l'objet parseurXml et de l'ecouteur.
// --------------------------------------------------------------------------
      usineParseurXml = SAXParserFactory.newInstance();
      parseurXml = usineParseurXml.newSAXParser();
      ecouteur = new EcouteurSAXQuery();

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
      if (requete.compareTo("") == 0)
      {
         throw new SAXException("Requete vide");
      }

// --------------------------------------------------------------------------
// Ouverture de la connexion avec le serveur XML.
// --------------------------------------------------------------------------
// Il faut ouvrir (et fermer) la connexion a chaque appel (executeQuery ou
// executeUpdate), a cause de la conception du serveur XML...
// --------------------------------------------------------------------------
// En effet, dans le serveur, le thread client ouvre une socket a la
// reception de la requete (accept), exécute le requete, envoie le resultat,
// et FERME la socket.
// --------------------------------------------------------------------------
      getConnection();

      try
      {

// --------------------------------------------------------------------------
// Envoi de la requete vers le serveur.
// --------------------------------------------------------------------------
         sortie.println(requete);

// --------------------------------------------------------------------------
// Lecture de la reponse du serveur et creation du documentDom :
// --------------------------------------------------------------------------
// Le "protocole" utilise est le suivant :
//
// Un flux XML de racine RACINE si le select a ete execute correctement.
// Un flux XML de racine ERREUR s'il y a eu erreur d'execution de la requete.
// --------------------------------------------------------------------------
         parseurXml.parse(sourceXml, ecouteur);

// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre
// --------------------------------------------------------------------------
         if (ecouteur.getErreur() == true)
         {
            throw new SAXException(ecouteur.getTexteErreur());
         }
         else
         {

// --------------------------------------------------------------------------
// La requete s'est bien executee. On recupere les resultats "ecoutes"
// --------------------------------------------------------------------------
            colonnes = ecouteur.getColonnes();
            lignes = ecouteur.getLignes();

            jeuResultat = new JeuResultat();
            jeuResultat.setColonnes(colonnes);
            jeuResultat.setLignes(lignes);
         }
      }
      finally
      {
         closeConnection();
      }

      return jeuResultat;
   }

// ==========================================================================
// executeUpdate (INSERT, DELETE, UPDATE)
// --------------------------------------------------------------------------
// Cette methode retourne le nombre de lignes concernees par la requete
// ==========================================================================
   public Integer executeUpdate(String requete)
                  throws ParserConfigurationException,
                         SAXException,
                         IOException
   {
      Integer nombreLignes;

// --------------------------------------------------------------------------
// Parseur du document XML qui sera recu et Ecouteur des evenements SAX
// --------------------------------------------------------------------------
      SAXParserFactory usineParseurXml;
      SAXParser parseurXml;
      EcouteurSAXUpdate ecouteur;

// --------------------------------------------------------------------------
// Creation de l'objet parseurXml et de l'ecouteur.
// --------------------------------------------------------------------------
      usineParseurXml = SAXParserFactory.newInstance();
      parseurXml = usineParseurXml.newSAXParser();
      ecouteur = new EcouteurSAXUpdate();

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
      if (requete.compareTo("") == 0)
      {
         throw new SAXException("Requete vide");
      }

// --------------------------------------------------------------------------
// Ouverture de la connexion avec le serveur JDBC.
// --------------------------------------------------------------------------
      getConnection();

      try
      {

// --------------------------------------------------------------------------
// Envoi de la requete vers le serveur.
// --------------------------------------------------------------------------
         sortie.println(requete);

// --------------------------------------------------------------------------
// Lecture de la reponse du serveur et creation du documentDom :
// --------------------------------------------------------------------------
// Le "protocole" utilise est le suivant :
//
// Un flux XML de racine RACINE si le select a ete execute correctement.
// Un flux XML de racine ERREUR s'il y a eu erreur d'execution de la requete.
// --------------------------------------------------------------------------
         parseurXml.parse(sourceXml, ecouteur);

// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre
// --------------------------------------------------------------------------
// --------------------------------------------------------------------------
// Recuperation de l'element racine de l'arbre
// --------------------------------------------------------------------------
         if (ecouteur.getErreur() == true)
         {
            throw new SAXException(ecouteur.getTexteErreur());
         }
         else
         {

// --------------------------------------------------------------------------
// La requete s'est bien executee. On recupere les resultats "ecoutes"
// --------------------------------------------------------------------------
            nombreLignes = ecouteur.getNombreLignes();
         }

// --------------------------------------------------------------------------
// Fermeture de la connexion :
// --------------------------------------------------------------------------
      }
      finally
      {
         closeConnection();
      }

      return nombreLignes;
   }
}
