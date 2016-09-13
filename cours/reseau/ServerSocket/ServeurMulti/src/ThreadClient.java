// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
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
// --------------------------------------------------------------------------
    private Socket socketClient;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public ThreadClient(Socket socketClient)
    {
        this.socketClient = socketClient;
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
        ObjectInputStream entree;
        ObjectOutputStream sortie;
        boolean fin;
        String ligne;

        System.out.println("Thread client : " + currentThread());

// --------------------------------------------------------------------------
// Ouverture des flux.
// --------------------------------------------------------------------------
// REMARQUE IMPORTANTE :
// --------------------------------------------------------------------------
// Il faut mettre le ObjectOutputStream avant le ObjectInputStream. En effet,
// le new ObjectInputStream() attend que le ObjectOutputStream du client soit
// fait. Si par hasard le client ecrit son new ObjectInputStream() avant son
// new ObjectOutputStream(), les deux applications vont se bloquer
// mutuellement !
// --------------------------------------------------------------------------
        try
        {
            sortie = new ObjectOutputStream(socketClient.getOutputStream());
            entree = new ObjectInputStream(socketClient.getInputStream());

// --------------------------------------------------------------------------
// Message d'accueil pour le client.
// --------------------------------------------------------------------------
            sortie.writeObject("Bonjour, tapez FUMIER pour sortir.");

            fin = false;

            while (!fin)
            {
                ligne = (String) entree.readObject();
                ligne = ligne.trim();

                if (ligne.compareTo("FUMIER") == 0)
                {
                    sortie.writeObject("FIN");
                    fin = true;
                }
                else
                {
                    sortie.writeObject(ligne + " vous-meme !");
                }
            }
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