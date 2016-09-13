// ==========================================================================
// SocketWeb : Test de connexion au serveur WEB situe sur la machine mercure
//             (adresse IP : 10.75.96.102)  port : 80. On enverra une
//             requete HTTP de type GET pour lire le code de la page
//             d'accueil du serveur.
// ==========================================================================

import java.net.*;
import java.io.*;

public class SocketWeb
{
    public static void main(String argv[])
    {
        Socket socketClient;
        BufferedReader entree;
        PrintWriter sortie;
        String ligne;

        try
        {
// --------------------------------------------------------------------------
// L'instanciation d'un objet Socket s'accompagne de l'envoi d'une requete
// de connexion. Il s'agit de l'envoi de l'adresse IP et du numero de port
// de l'application a atteindre.
// --------------------------------------------------------------------------
// Possibilites : mercure 80, mars 80...
// --------------------------------------------------------------------------
            socketClient = new Socket("mercure", 80);

// --------------------------------------------------------------------------
// Affichage de l'adresse a laquelle la Socket est connectee
// --------------------------------------------------------------------------
            System.out.println(socketClient.getInetAddress()
                + "   Port : " + socketClient.getPort());

// --------------------------------------------------------------------------
// Affichage de l'adresse locale a laquelle la Socket est connectee.
// Remarque : ce n'est pas forcement l'adresse de la machine ou tourne cette
//            application. Cela peut etre la machine AFPA extremite du reseau
//            Internet...
// --------------------------------------------------------------------------
            System.out.println(socketClient.getLocalAddress()
                + "   Port : " + socketClient.getInetAddress());

// --------------------------------------------------------------------------
// Ouverture d'un flux d'ecriture pour envoyer des requetes au serveur
// --------------------------------------------------------------------------
            sortie = new PrintWriter(socketClient.getOutputStream());

// --------------------------------------------------------------------------
// Ouverture d'un flux de lecture pour recevoir les reponses du serveur
// --------------------------------------------------------------------------
            entree = new BufferedReader(
                new InputStreamReader(
                    socketClient.getInputStream(), "windows-1252"));

// --------------------------------------------------------------------------
// Envoi de requetes (simulation de HTTP).
// --------------------------------------------------------------------------
// Le flush() permet d'envoyer la requete...
// Si on ne le met pas, un buffer d'ecriture se remplit, et attend d'etre
// rempli pour partir automatiquement.
// --------------------------------------------------------------------------
// Remarque : sortie.print("\r\n\r\n"); peut etre remplace par
//
//            sortie.println("");
//            sortie.println("");
// --------------------------------------------------------------------------
            sortie.print("GET / HTTP/1.0");
            sortie.print("\r\n\r\n");
            sortie.flush();

// --------------------------------------------------------------------------
// Lecture des reponses du serveur
// --------------------------------------------------------------------------
            System.out.println("\nFichier d'accueil :\n");

            ligne = entree.readLine();

            while (ligne != null)
            {
                System.out.println(ligne);
                ligne = entree.readLine();
            }

            entree.close();
            sortie.close();
            socketClient.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
