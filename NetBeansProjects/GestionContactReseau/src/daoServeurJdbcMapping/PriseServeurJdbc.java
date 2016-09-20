// ==========================================================================
// package daoServeurJdbcMapping
// --------------------------------------------------------------------------
// CLASSE PriseServeurJdbc
// --------------------------------------------------------------------------
// Un objet de cette classe reference un serveur de type JDBC.
// Le constructeur recoit l'adreese IP et le port du serveur.
// ==========================================================================

package daoServeurJdbcMapping;

import java.net.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class PriseServeurJdbc
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
   private String nomMachine;
   private int numeroPort;
   private String formatDate = "dd/MM/yyyy";

   private Socket socketReseau;
   private ObjectInputStream entree;
   private ObjectOutputStream sortie;

// ==========================================================================
// Constructeur
// --------------------------------------------------------------------------
// Le constructeur prend deux parametres :
//
// nomMachine : nom (ou adresse IP) de la machine distante
// numeroPort : numero de port de l'application distante
// ==========================================================================
   public PriseServeurJdbc(String nomMachine, int numeroPort)
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

         sortie = new ObjectOutputStream(socketReseau.getOutputStream());
         entree = new ObjectInputStream(socketReseau.getInputStream());
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
                      throws IOException, ClassNotFoundException
   {
      JeuResultat jeuResultat;
      Integer codeRetour;
      String messageErreur;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
      if (requete.compareTo("") == 0)
      {
         throw new IOException("Requete vide");
      }

// --------------------------------------------------------------------------
// Ouverture de la connexion avec le serveur JDBC.
// --------------------------------------------------------------------------
// Il faut ouvrir (et fermer) la connexion a chaque appel (executeQuery ou
// executeUpdate), a cause de la conception du serveur JDBC...
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
         sortie.writeObject(requete);

         codeRetour = (Integer)entree.readObject();

         if (codeRetour == 0)
         {
            messageErreur = (String)entree.readObject();
            throw new IOException(messageErreur);
         }
         else
         {
            jeuResultat = (JeuResultat)entree.readObject();
            return jeuResultat;
         }
      }
      finally
      {
         closeConnection();
      }
   }

// ==========================================================================
// executeUpdate (INSERT, DELETE, UPDATE)
// --------------------------------------------------------------------------
// Cette methode retourne le nombre de lignes concernees par la requete
// ==========================================================================
   public Integer executeUpdate(String requete) throws IOException,
                                                       ClassNotFoundException
   {
      Integer codeRetour;
      String messageErreur;

// --------------------------------------------------------------------------
// Cas de la requete vide.
// --------------------------------------------------------------------------
      if (requete.compareTo("") == 0)
      {
         throw new IOException("Requete vide");
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
         sortie.writeObject(requete);

         codeRetour = (Integer)entree.readObject();

         if (codeRetour == 0)
         {
            messageErreur = (String)entree.readObject();
            throw new IOException(messageErreur);
         }
         else
         {
            codeRetour = (Integer)entree.readObject();
            return codeRetour;
         }
      }
      finally
      {
         closeConnection();
      }
   }
}
