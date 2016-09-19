// ==========================================================================
// Projet serveurFinal : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ThreadClient : processus de dialogue avec un client (thread esclave).
// ==========================================================================

import java.net.*;
import java.io.*;

public class ThreadClient extends Thread
{

// --------------------------------------------------------------------------
// Proprietes :
//
// socketClient : reference d'une socket du serveur vers le client.
//                Cette socket est ouverte par le thread maitre (serveur) et
//                transmise au constructeur.
// actif        : indique si la connexion client (socket) est active.
// --------------------------------------------------------------------------
    private Socket socketClient;
    private boolean actif;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public ThreadClient(Socket socketClient)
    {
        this.socketClient = socketClient;
        actif = true;
    }

// --------------------------------------------------------------------------
// Traitement de chaque client. Cette methode est commune a tous les objets
// de type ThreadClient crees par le thread Serveur. Mais les proprietes et
// les parametres de methodes sont dupliques (on peut le mettre en evidence
// en affichant les references d'entree et sortie ci-dessous). Il n'y a pas
// de probleme de melange de donnees (pas de necessite de synchronisation).
// --------------------------------------------------------------------------
    public void run()
    {
        BufferedReader entree;
        PrintWriter sortie;
        boolean fin;
        String ligne;

        System.out.println("Thread client : " + currentThread());

        try
        {
            entree = new BufferedReader(
                new InputStreamReader(socketClient.getInputStream()));
            sortie = new PrintWriter(socketClient.getOutputStream(), true);

// --------------------------------------------------------------------------
// Message d'accueil pour le client.
// --------------------------------------------------------------------------
            sortie.println("Bonjour, tapez FUMIER pour sortir.");

// --------------------------------------------------------------------------
// Boucle de lecture du message client.
// --------------------------------------------------------------------------
            while (actif)
            {
                try
                {
                    ligne = entree.readLine();
                    ligne = ligne.trim();

                    if (ligne.compareTo("FUMIER") == 0)
                    {
                        actif = false;
                        sortie.println("F");
                    }
                    else
                    {
                        sortie.println("R" + ligne);
                    }
                }
                catch (SocketTimeoutException e)
                {
                    if (interrupted())
                    {
                        actif = false;
                        sortie.println("F");
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            socketClient.close();
        }
        catch (IOException e)
        {
            System.out.println("Erreur ouverture flux ThreadClient");
            System.out.println(e.getMessage());
        }
    }
}
