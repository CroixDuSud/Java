// ==========================================================================
// Classe ThreadClient                      Application ServeurJDBC - Console
// --------------------------------------------------------------------------
// Thread client. Processus de dialogue avec un client.
// ==========================================================================

import java.net.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import utilitairesMG.jdbc.*;

public class ThreadClient extends Thread
{

// --------------------------------------------------------------------------
// Proprietes :
// --------------------------------------------------------------------------
// socketClient : reference d'une socket du serveur vers le client.
//                Cette socket est ouverte par le thread maitre (serveur) et
//                transmise au constructeur.
//
// base         : base de donnees a utiliser pour les requetes.
// --------------------------------------------------------------------------
    private Socket socketClient;
    private BaseDeDonnees base;

// ==========================================================================
// Constructeur
// ==========================================================================
    public ThreadClient(Socket socketClient, BaseDeDonnees base)
    {
        this.socketClient = socketClient;
        this.base = base;
    }

// ==========================================================================
// Traitement de chaque client. Cette methode est commune a tous les objets
// de type ThreadClient crees par le thread Serveur. Mais les proprietes et
// les parametres de methodes sont dupliques (on peut le mettre en evidence
// en affichant les references d'entree et sortie ci-dessous). Il n'y a pas
// de probleme de melange de donnees (pas de necessite de synchronisation).
// ==========================================================================
    public void run()
    {
        ObjectOutputStream sortie;
        ObjectInputStream entree;
        String texteRequete;

        JeuResultat jeuResultat;
        int nombreLignesModifiees;

        try
        {

// --------------------------------------------------------------------------
// REMARQUE IMPORTANTE :
// --------------------------------------------------------------------------
// Il faut mettre le ObjectOutputStream avant le ObjectInputStream. En effet,
// le new ObjectInputStream() attend que le ObjectOutputStream du client soit
// fait. Si par hasard le client ecrit son new ObjectInputStream() avant son
// new ObjectOutputStream(), les deux applications vont se bloquer
// mutuellement !
// --------------------------------------------------------------------------
            sortie = new ObjectOutputStream(socketClient.getOutputStream());
            entree = new ObjectInputStream(socketClient.getInputStream());

// --------------------------------------------------------------------------
// Lecture de la requete envoyee par le client :
// --------------------------------------------------------------------------
            texteRequete = (String) entree.readObject();
            ControleurServeur.traiterTexte("Client "
                + socketClient.getInetAddress()
                + "  : "
                + texteRequete);

// --------------------------------------------------------------------------
// Ouverture de la connexion
// --------------------------------------------------------------------------
            try
            {
                base.getConnection();

// --------------------------------------------------------------------------
// Type de requete : est-ce un select ?
// --------------------------------------------------------------------------
                try
                {
                    texteRequete = texteRequete.trim();

// --------------------------------------------------------------------------
// Execution de la requete :
// --------------------------------------------------------------------------
                    if ((texteRequete.length() >= 6) &&
                        (texteRequete.substring(0, 6).
                            compareToIgnoreCase("SELECT") == 0))
                    {
                        jeuResultat = base.executeQuery(texteRequete);

// --------------------------------------------------------------------------
// Execution reussie : envoi des resultats au client
// --------------------------------------------------------------------------
// On envoie successivement :
//    le code 1
//    le jeu de resultats lu
// --------------------------------------------------------------------------
                        sortie.writeObject(1);
                        sortie.writeObject(jeuResultat);
                    }
                    else
                    {
                        nombreLignesModifiees = base.executeUpdate(texteRequete);

// --------------------------------------------------------------------------
// Execution reussie : envoi des resultats au client
// --------------------------------------------------------------------------
// On envoie successivement :
//    le code 2
//    le nombre de lignes modifiees
// --------------------------------------------------------------------------
                        sortie.writeObject(2);
                        sortie.writeObject(nombreLignesModifiees);
                    }
                }
                finally
                {
                    base.closeConnection();
                }
            }

// --------------------------------------------------------------------------
// Erreur d'execution de la requete : envoi des resultats au client
// --------------------------------------------------------------------------
// On envoie successivement :
//    0
//    le message d'erreur genere par la BDD
// --------------------------------------------------------------------------
            catch (SQLException sqlex)
            {
                sortie.writeObject(0);
                sortie.writeObject(sqlex.getMessage());
            }

// --------------------------------------------------------------------------
// Fermeture des flux et du socket client :
// --------------------------------------------------------------------------
            entree.close();
            sortie.close();
            socketClient.close();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}