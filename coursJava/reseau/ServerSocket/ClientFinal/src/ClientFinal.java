// ==========================================================================
// ClientFinal : client du serveur ServeurFinal
// --------------------------------------------------------------------------
// Le serveur ServeurFinal renvoie l'echo des messages envoyes par ce client.
// --------------------------------------------------------------------------
// Ce programme doit permettre a l'utilisateur de saisir des messages au
// clavier, tout en restant a l'ecoute des messages du serveur. En effet,
// celui-ci peut s'arreter et etre a l'initiative de la fin du dialogue.
// Il faut donc mettre la saisie clavier dans un Thread separe pour que le
// programme principal puisse continuer a ecouter le serveur pendant la 
// saisie (cela n'a d'interet que si le serveur envoie des messages en plus
// de l'echo du client). Quand le programme principal recoit l'ordre de fin,
// il se termine, mais le Thread de saisie continue... Sauf si le thread de
// saisie est un demon !
// ==========================================================================

import java.net.*;
import java.io.*;

public class ClientFinal
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// saisie        : thread de saisie clavier
// socketServeur : reference d'une socket vers le serveur
// sortie        : flux vers le serveur
// entree        : flux en provenance du serveur
// --------------------------------------------------------------------------
        ThreadSaisie saisie;
        Socket socketServeur;
        BufferedReader entree;
        PrintWriter sortie;

        boolean fin;
        String ligneRecue;
        char codeMessageRecu;
        String messageRecu;

        try
        {

// --------------------------------------------------------------------------
// L'instanciation de l'objet Socket ouvre la connexion avec le serveur. Si
// le serveur est indisponible, il y a lancement d'une ConnectException.
// --------------------------------------------------------------------------
            socketServeur = new Socket("localhost", 8189);

            sortie = new PrintWriter(socketServeur.getOutputStream(), true);
            entree = new BufferedReader(
                new InputStreamReader(socketServeur.getInputStream()));

// --------------------------------------------------------------------------
// Lecture du message d'accueil
// --------------------------------------------------------------------------
            ligneRecue = entree.readLine();
            System.out.println(ligneRecue + "\n");

// --------------------------------------------------------------------------
// Boucle d'envoi de messages au serveur. Cette boucle s'arrete quand le
// serveur envoie le message "F". Si la fin est a l'initiative du serveur
// (et non suite a la saisie de "FUMIER" par le client), il faut que le
// ThreadSaisie soit un demon pour s'arreter...
// --------------------------------------------------------------------------
// Remarque : La methode isAlive() retourne true apres le start().
// --------------------------------------------------------------------------
            fin = false;
            saisie = new ThreadSaisie(sortie);
            saisie.setDaemon(true);
            saisie.start();

            while (!fin)
            {

// --------------------------------------------------------------------------
// Si le Thread saisie est mort, c'est qu'une saisie clavier a ete faite et
// que la methode run() de saisie s'est achevee. Pour faire une autre saisie,
// il faut creer un nouveau Thread (new) et le lancer (start).            
// --------------------------------------------------------------------------
                if (!saisie.isAlive())
                {
                    saisie = new ThreadSaisie(sortie);
                    saisie.setDaemon(true);
                    saisie.start();
                }

// --------------------------------------------------------------------------
// Le client est ici en attente d'un message du serveur. 
// Le message du serveur est prefixe par 'R'eponse ou 'F'inir. Le message de
// fin (prefixe par 'F') peut etre un message a l'initiative du serveur
// (lorqu'il s'arrete) ou en reponse au message "FUMIER" du client.
// --------------------------------------------------------------------------
                ligneRecue = entree.readLine();
                codeMessageRecu = ligneRecue.charAt(0);
                messageRecu = ligneRecue.substring(1);

                if (codeMessageRecu == 'F')
                {
                    fin = true;
                    System.out.println("\n\nFin de la communication");
                    Thread.currentThread().sleep(1000);
                }
                else
                {
                    System.out.println("\nMessage recu du serveur : "
                        + messageRecu + "\n");
                }
            }

            socketServeur.close();
        }
        catch (ConnectException e)
        {
            System.out.println("Connexion impossible : serveur indisponible");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
