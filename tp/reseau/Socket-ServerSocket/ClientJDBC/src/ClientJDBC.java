// ==========================================================================
// Classe ClientJDBC                                  Application ServeurJDBC
// --------------------------------------------------------------------------
// Client du serveur ServeurJDBC (mode console ou pas)
// --------------------------------------------------------------------------
// Ce programme ouvre la connexion, envoie une requete SQL, lit la reponse
// du serveur, et affiche les deux objets de la reponse.
// ==========================================================================

import java.net.*;
import java.io.*;
import utilitairesMG.divers.*;

public class ClientJDBC
{
    public static void main(String argv[])
    {

// --------------------------------------------------------------------------
// socketServeur : reference d'une socket vers le serveur
// sortie        : flux vers le serveur
// entree        : flux en provenance du serveur
// --------------------------------------------------------------------------
        Socket socketServeur;
        ObjectInputStream entree;
        ObjectOutputStream sortie;

        String requete;
        Object reponse;

        try
        {
            System.out.print("\nRequete SQL : ");
            requete = Clavier.readString();

// --------------------------------------------------------------------------
// L'instanciation de l'objet Socket ouvre la connexion avec le serveur. Si
// le serveur est indisponible, il y a lancement d'une ConnectException.
// --------------------------------------------------------------------------
            socketServeur = new Socket("localhost", 8189);

            sortie = new ObjectOutputStream(socketServeur.getOutputStream());
            entree = new ObjectInputStream(socketServeur.getInputStream());
            sortie.writeObject(requete);

            reponse = entree.readObject();
            System.out.println(reponse);
            reponse = entree.readObject();
            System.out.println(reponse);

            entree.close();
            sortie.close();
            socketServeur.close();
        }
        catch (ConnectException e)
        {
            System.out.println("Connexion impossible : serveur indisponible");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
