// ==========================================================================
// Classe ClientXML                                    Application ServeurXML
// ==========================================================================

import java.net.*;
import java.io.*;
import utilitairesMG.divers.*;

public class ClientXML
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// socketServeur : reference d'une socket vers le serveur
// sortie        : flux vers le serveur
// entree        : flux en provenance du serveur
// --------------------------------------------------------------------------
        Socket socketServeur;
        BufferedReader entree;
        PrintWriter sortie;

        String requete;
        String reponse;

        try
        {
            System.out.print("\nRequete SQL : ");
            requete = Clavier.readString();

// --------------------------------------------------------------------------
// L'instanciation de l'objet Socket ouvre la connexion avec le serveur. Si
// le serveur est indisponible, il y a lancement d'une ConnectException.
// --------------------------------------------------------------------------
            socketServeur = new Socket("localhost", 8189);

            sortie = new PrintWriter(
                new OutputStreamWriter(
                    socketServeur.getOutputStream(), "utf-8"), true);

            entree = new BufferedReader(
                new InputStreamReader(
                    socketServeur.getInputStream(), "utf-8"));

            sortie.println(requete);

            reponse = entree.readLine();

            while (reponse != null)
            {
                System.out.println(reponse);
                reponse = entree.readLine();
            }

            entree.close();
            sortie.close();
            socketServeur.close();
        }
        catch (ConnectException e)
        {
            System.out.println("Connexion impossible : serveur indisponible");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
