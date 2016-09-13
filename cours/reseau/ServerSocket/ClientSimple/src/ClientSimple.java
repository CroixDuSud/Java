// ==========================================================================
// ClientSimple : Test de connexion a un serveur de type ServerSocket
// --------------------------------------------------------------------------
// Le serveur correspondant est ServeurSimple
// --------------------------------------------------------------------------
// Ce programme ouvre la connexion, lit le message de bienvenue du serveur,
// envoie un message, et se ferme...
// ==========================================================================

import java.net.*;
import java.io.*;

public class ClientSimple
{
    public static void main(String argv[])
    {
        Socket socketServeur;
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
            socketServeur = new Socket("localhost", 8189);

// --------------------------------------------------------------------------
// Affichage de l'adresse a laquelle la Socket est connectee
// --------------------------------------------------------------------------
            System.out.println(socketServeur.getInetAddress()
                + "   Port : " + socketServeur.getPort());

// --------------------------------------------------------------------------
// Affichage de l'adresse locale a laquelle la Socket est connectee.
// Remarque : ce n'est pas forcement l'adresse de la machine ou tourne cette
//            application. Cela peut etre la machine AFPA extremite du reseau
//            Internet...
// --------------------------------------------------------------------------
            System.out.println(socketServeur.getLocalAddress()
                + "   Port : " + socketServeur.getLocalPort());

// --------------------------------------------------------------------------
// Ouverture d'un flux d'ecriture pour envoyer des requetes au serveur
// --------------------------------------------------------------------------
            sortie = new PrintWriter(
                new OutputStreamWriter(
                    socketServeur.getOutputStream(), "UTF-8"));

// --------------------------------------------------------------------------
// Ouverture d'un flux de lecture pour recevoir les reponses du serveur
// --------------------------------------------------------------------------
            entree = new BufferedReader(
                new InputStreamReader(
                    socketServeur.getInputStream(), "UTF-8"));

// --------------------------------------------------------------------------
// Lecture du message d'accueil
// --------------------------------------------------------------------------
            System.out.println("\n");
            ligne = entree.readLine();
            System.out.println(ligne);

// --------------------------------------------------------------------------
// Envoi de messages au serveur
// Le flush() est necessaire pour vider le buffer d'envoi... Si on ne le fait
// pas, le message ne part pas (sans doute en attendant d'autres messages qui
// rempliront le buffer).
// --------------------------------------------------------------------------
            sortie.println("Compr€nds-tu les éùï, pauvre type ?");
            sortie.flush();

            entree.close();
            sortie.close();
            socketServeur.close();
        }
        catch (IOException e)
        {
            System.out.println("Connexion refusée !");
            System.out.println("Le serveur ne répond pas !");
        }
    }
}
