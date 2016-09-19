// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ServeurMulti : Serveur (thread maitre de l'application).
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurMulti extends Thread
{

// --------------------------------------------------------------------------
// Proprietes :
//
// serveur      : objet serveur
// actif        : indique si le serveur est actif (true)
// --------------------------------------------------------------------------
    private ServerSocket serveur;
    private boolean actif;

// --------------------------------------------------------------------------
// Constructeur : demarrage et parametrage du serveur
// --------------------------------------------------------------------------
    ServeurMulti()
    {
        try
        {
            serveur = new ServerSocket(8189);
            serveur.setSoTimeout(10);
            actif = true;
        }

// --------------------------------------------------------------------------
// Il peut y avoir IOException sur le new ServerSocket() ou SocketException
// sur le setSoTimeout(10). SocketException hérite de IOException.
// --------------------------------------------------------------------------
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

// --------------------------------------------------------------------------
// Traitement fait par le serveur
// --------------------------------------------------------------------------
    public void run()
    {

// --------------------------------------------------------------------------
// socketClient : reference d'une socket du serveur vers le client
// threadClient : thread de traitement du client
// --------------------------------------------------------------------------
        Socket socketClient;
        Thread threadClient;

        System.out.println("Thread serveur : " + currentThread());

// --------------------------------------------------------------------------
// Le serveur sera actif jusqu'a ce que le programme Principal envoie un
// ordre d'interruption (interrupt()). Dans ce cas, la methode interrupted()
// renvoie true. Le programme ne fonctionne que parce qu'on a limite le
// temps d'attente du accept() par la methode setSoTimeout(10) dans le
// constructeur. Sinon, le programme attend indefiniment qu'un client se
// connecte...
// --------------------------------------------------------------------------
// Remarque : le thread serveur peut s'arreter mais les threads clients
//            continuent a tourner... L'application se termine quand tous
//            les clients ont tape FUMIER.
// --------------------------------------------------------------------------
        while (actif)
        {
            try
            {
                socketClient = serveur.accept();

                threadClient = new ThreadClient(socketClient);
                threadClient.start();
            }
            catch (SocketTimeoutException e)
            {
                if (interrupted())
                {
                    actif = false;
                }
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }

// --------------------------------------------------------------------------
// Arreter le ServerSocket, pour liberer le port 8189
// --------------------------------------------------------------------------
        try
        {
            serveur.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}