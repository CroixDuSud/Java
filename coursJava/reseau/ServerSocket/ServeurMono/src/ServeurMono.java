// ==========================================================================
// ServeurMono : Serveur qui renvoie l'echo de ce que le client envoie
// --------------------------------------------------------------------------
// Pour tester ce programme, utiliser le programme client : ClientEcho.java.
// Attention, avec Telnet, on ne peut utiliser ObjectInputStream en entree.
// --------------------------------------------------------------------------
// Ce serveur ne permet que de repondre a un client (Mono client)
// ==========================================================================

import java.net.*;
import java.io.*;

public class ServeurMono
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// serveur      : objet serveur
// socketClient : reference d'une socket du serveur vers le client
// sortie       : flux vers le client
// entree       : flux en provenance du client
// --------------------------------------------------------------------------
        ServerSocket serveur;

        Socket socketClient;
        ObjectOutputStream sortie;
        ObjectInputStream entree;

// --------------------------------------------------------------------------
// fin         : variable indiquant la fin du dialogue (true) ou pas (false)
// ligne       : chaine de lecture ou d'ecriture dans les flux
// --------------------------------------------------------------------------
        boolean fin;
        String ligne;

        try
        {

// --------------------------------------------------------------------------
// Creation et lancement du serveur attache au port 8189.
// --------------------------------------------------------------------------
            serveur = new ServerSocket(8189);

// --------------------------------------------------------------------------
// Attente connexion client et creation de la socket.
// --------------------------------------------------------------------------
            socketClient = serveur.accept();

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
                System.out.println(ligne);

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
