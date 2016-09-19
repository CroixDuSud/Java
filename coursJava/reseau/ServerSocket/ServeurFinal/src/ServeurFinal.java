// ==========================================================================
// Projet serveurFinal : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// ServeurFinal : Serveur (thread maitre de l'application).
// ==========================================================================

import java.net.*;
import java.util.*;

public class ServeurFinal extends Thread
{

// --------------------------------------------------------------------------
// Proprietes :
//
// serveur      : objet serveur
// actif        : indique si le serveur est actif (true)
// --------------------------------------------------------------------------
    private ServerSocket serveur;
    private boolean actif;
    private Vector vThreadClient;

// --------------------------------------------------------------------------
// Constructeur : demarrage et parametrage du serveur
// --------------------------------------------------------------------------
    ServeurFinal()
    {
        try
        {
            serveur = new ServerSocket(8189);
            serveur.setSoTimeout(3000);
            actif = true;
            vThreadClient = new Vector();
        }
        catch (Exception e)
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

        System.out.println("Thread serveur : " + currentThread() + "\n");

// --------------------------------------------------------------------------
// Le serveur sera actif jusqu'a ce que le programme Principal envoie un
// ordre d'interruption (interrupt()). Dans ce cas, la methode interrupted()
// renvoie true. Le programme ne fonctionne que parce qu'on a limite le 
// temps d'attente du accept() par la methode setSoTimeout(3000) dans le
// constructeur. Sinon, le programme attend indefiniment qu'un client se
// connecte...
// --------------------------------------------------------------------------
        while (actif)
        {
            try
            {
                socketClient = serveur.accept();
                socketClient.setSoTimeout(3000);

                threadClient = new ThreadClient(socketClient);
                vThreadClient.addElement(threadClient);
                threadClient.start();
            }
            catch (SocketTimeoutException e)
            {
                if (interrupted())
                {
                    actif = false;
                    for (int i = 0; i < vThreadClient.size(); i++)
                    {
                        if (((Thread) vThreadClient.elementAt(i)).isAlive())
                        {
                            ((Thread) vThreadClient.elementAt(i)).interrupt();
                        }
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
