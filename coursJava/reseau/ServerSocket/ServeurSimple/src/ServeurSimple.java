// ==========================================================================
// ServeurSimple : lancement d'un serveur qui s'arrete au bout de 10 secondes
// --------------------------------------------------------------------------
// Le client correspondant est ClientSimple
// --------------------------------------------------------------------------
// Ce programme lance le serveur, envoie un message de bienvenue, lit un
// message du client, et s'arrete... Les textes échangés sont codés en UTF-8.
// --------------------------------------------------------------------------
// Si le client ne se connecte pas dans les 10 secondes, le serveur s'arrete
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurSimple
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// serveur      : objet serveur
// socketClient : reference d'une socket du serveur vers le client
// sortie       : flux vers le client
// entree       : flux en provenance du client
// ligne        : chaine de lecture et d'ecriture dans les flux
// --------------------------------------------------------------------------
        ServerSocket serveur;
        Socket socketClient;
        PrintWriter sortie;
        BufferedReader entree;
        String ligne;

        try
        {

// --------------------------------------------------------------------------
// Creation et lancement d'un serveur attache au port 8189 de l'ordinateur
// courant.
// --------------------------------------------------------------------------
            serveur = new ServerSocket(8189);
            if (!serveur.isClosed())
            {
                System.out.println("Le serveur est actif...");
            }

// --------------------------------------------------------------------------
// Parametrage du parametre SO_TIMEOUT qui permet de limiter le temps
// d'attente du serveur. Le serveur va attendre 10 secondes qu'un client se
// connecte... A defaut, il s'arrete en passant par le bloc catch
// java.net.SocketTimeoutException
// --------------------------------------------------------------------------
            serveur.setSoTimeout(10000);  // SocketException (non surveillee)

            System.out.println("Un client doit se connecter avant "
                + serveur.getSoTimeout() / 1000 + " secondes.\n\n");

// --------------------------------------------------------------------------
// La methode accept() demande au programme d'attendre jusqu'a ce qu'un
// client se connecte. La connexion du client s'accompagne de la creation
// d'un objet Socket qui permettra de dialoguer avec lui. La methode accept()
// retourne l'adresse de cette "Socket".
// --------------------------------------------------------------------------
            socketClient = serveur.accept();
            System.out.println("Socket créée : " + socketClient);

// --------------------------------------------------------------------------
// Ouverture des flux.
// --------------------------------------------------------------------------
            sortie = new PrintWriter(
                new OutputStreamWriter(
                    socketClient.getOutputStream(), "UTF-8"));

            entree = new BufferedReader(
                new InputStreamReader(
                    socketClient.getInputStream(), "UTF-8"));

// --------------------------------------------------------------------------
// Envoi du message de bienvenue
// --------------------------------------------------------------------------
            sortie.println("Bienvenue, €spèce de FUMIER !");
            sortie.flush();

// --------------------------------------------------------------------------
// Lecture du message du client
// --------------------------------------------------------------------------
            ligne = entree.readLine();
            System.out.println(ligne);

            entree.close();
            sortie.close();
            socketClient.close();
        }
        catch (SocketTimeoutException e)
        {
            System.out.println(
                "Temps d'attente de la connexion client dépassé !");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
