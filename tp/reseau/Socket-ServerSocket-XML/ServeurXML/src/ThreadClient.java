// ==========================================================================
// Projet Client/Serveur/BDD : architecture 3 tiers
// --------------------------------------------------------------------------
// ThreadClient : processus de dialogue avec un client (thread esclave).
// ==========================================================================

import java.net.*;
import java.io.*;
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
        this.base = base;
        this.socketClient = socketClient;
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
        BufferedReader entree;
        PrintWriter sortie;
        String texteRequete;

        JeuResultatXML jeuResultatXML;
        String erreurXML;
        String modifXML;
        int nombreLignesModifiees;

// --------------------------------------------------------------------------
// Initialisation de la chaine XML d'erreur
// --------------------------------------------------------------------------
        erreurXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n";
        erreurXML += "<!DOCTYPE ERREUR [\n";
        erreurXML += "   <!ELEMENT ERREUR (#PCDATA)>\n";
        erreurXML += "]>\n\n";
        erreurXML += "<ERREUR>";

// --------------------------------------------------------------------------
// Initialisation de la chaine XML de modification
// --------------------------------------------------------------------------
        modifXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n\n";
        modifXML += "<!DOCTYPE MODIF [\n";
        modifXML += "   <!ELEMENT MODIF (#PCDATA)>\n";
        modifXML += "]>\n\n";
        modifXML += "<MODIF>";

        try
        {
            sortie = new PrintWriter(
                new OutputStreamWriter(
                    socketClient.getOutputStream(), "utf-8"), true);

            entree = new BufferedReader(
                new InputStreamReader(
                    socketClient.getInputStream(), "utf-8"));

// --------------------------------------------------------------------------
// Lecture de la requete envoyee par le client :
// --------------------------------------------------------------------------
            texteRequete = entree.readLine();
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
                        jeuResultatXML = base.executeQueryXML(texteRequete);

// --------------------------------------------------------------------------
// Execution reussie : envoi des resultats au client
// --------------------------------------------------------------------------
                        ControleurServeur.traiterTexte(
                            jeuResultatXML.getResultatXML());
                        sortie.println(jeuResultatXML.getResultatXML());
                    }
                    else
                    {
                        nombreLignesModifiees = base.executeUpdate(texteRequete);

// --------------------------------------------------------------------------
// Execution reussie : envoi du nombre de lignes modifiees au client
// --------------------------------------------------------------------------
                        modifXML += nombreLignesModifiees + "</MODIF>";
                        ControleurServeur.traiterTexte(modifXML);

                        sortie.println(modifXML);
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
            catch (SQLException sqlex)
            {
                erreurXML += sqlex.getMessage() + "</ERREUR>";
                ControleurServeur.traiterTexte(erreurXML);
                sortie.println(erreurXML);
            }

// --------------------------------------------------------------------------
// Fermeture des flux et du socket client :
// --------------------------------------------------------------------------
            entree.close();
            sortie.close();
            socketClient.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
