// ==========================================================================
// ServeurWeb : Serveur qui affiche la requete HTTP client (GET ou POST)
// --------------------------------------------------------------------------
// L'interet de ce programme est de visualiser une requete HTTP envoyee par
// un navigateur WEB. On lui renvoie un ecran HTML...
// ==========================================================================

import java.net.*;
import java.io.*;
//import utilitairesMG.divers.*;

public class ServeurWeb
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
        PrintWriter sortie;
        BufferedReader entree;

        String ligne;
        String requete;

        try
        {

// --------------------------------------------------------------------------
// Creation d'un serveur attache au port 8189
// --------------------------------------------------------------------------
            serveur = new ServerSocket(8189);
            socketClient = serveur.accept();

// --------------------------------------------------------------------------
// Flux d'entree et de sortie lies a la Socket
// --------------------------------------------------------------------------
// Le parametre true pour le PrintWriter signifie qu'un appel de flush()
// sera fait a chaque ordre print(). Ainsi, l'ordre d'impression sera
// systematiquement execute (pas d'attente de remplissage du buffer
// d'ecriture).
// --------------------------------------------------------------------------
            sortie = new PrintWriter(
                new OutputStreamWriter(
                    socketClient.getOutputStream(), "utf-8"), true);

            entree = new BufferedReader(
                new InputStreamReader(
                    socketClient.getInputStream(), "utf-8"));

// --------------------------------------------------------------------------
// Le traitement du message recu est ici adapte a un message au format http
// Les messages sont composes d'un entete, suivi d'une ligne vide, puis d'un
// corps contenant des donnees (saisies par exemple dans une page HTML) dans
// le cas des requetes POST ou PUT.
// --------------------------------------------------------------------------
            ligne = entree.readLine();
            System.out.println("La requete recue est : " + ligne);

// --------------------------------------------------------------------------
// Envoi d'un message au client et fermeture de la connexion.
// Si le client est un navigateur WEB, il affichera une page HTML...
// --------------------------------------------------------------------------
            requete = ligne.substring(0, 4);

            sortie.println("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            sortie.println(
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            sortie.println(
                "  \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

            sortie.println(
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" "
                + "xml:lang=\"fr\">");
            sortie.println("<head>");
            sortie.println("<title>Ecran de réponse du serveur Web</title>");
            sortie.println(
                "<meta http-equiv=\"Content-Type\" content=\"text/html; "
                + "charset=utf-8\" />");
            sortie.println("</head>");

            sortie.println("<body>");
            sortie.println("<div>");
            sortie.println(
                "<h1>La requete " + requete
                + " a été affichée par le serveur Web !</h1>");
            sortie.println("</div>");
            sortie.println("</body>");
            sortie.println("</html>");

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
