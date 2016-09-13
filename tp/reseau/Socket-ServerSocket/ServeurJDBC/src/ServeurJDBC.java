// ==========================================================================
// Classe ServeurJDBC                       Application ServeurJDBC - Console
// --------------------------------------------------------------------------
// Thread principal du serveur.
// ==========================================================================

import java.net.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class ServeurJDBC extends Thread
{

// --------------------------------------------------------------------------
// serveur  : objet serveur
// actif    : indique si le serveur est actif (true)
// base     : base de donnees utilisee par le serveur
// --------------------------------------------------------------------------
    private ServerSocket serveur;
    private boolean actif;
    private BaseDeDonnees base;

// ==========================================================================
// Constructeur : demarrage et parametrage du serveur
// ==========================================================================
    public ServeurJDBC(BaseDeDonnees base)
    {
        this.base = base;

        try
        {
            serveur = new ServerSocket(8189);
            serveur.setSoTimeout(10);
            actif = true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

// ==========================================================================
// Traitement fait par le serveur
// ==========================================================================
    public void run()
    {

// --------------------------------------------------------------------------
// socketClient : reference d'une socket du serveur vers le client
// threadClient : thread de traitement du client
// --------------------------------------------------------------------------
        Socket socketClient;
        Thread threadClient;

// --------------------------------------------------------------------------
// Le serveur sera actif jusqu'a ce que le programme Principal envoie un
// ordre d'interruption (interrupt()). Dans ce cas, la methode interrupted()
// renvoie true. Le programme ne fonctionne que parce qu'on a limite le
// temps d'attente du accept() par la methode setSoTimeout(1000) dans le
// constructeur. Sinon, le programme attend indefiniment qu'un client se
// connecte...
// --------------------------------------------------------------------------
        while (actif)
        {
            try
            {
                socketClient = serveur.accept();

                threadClient = new ThreadClient(socketClient, base);
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
