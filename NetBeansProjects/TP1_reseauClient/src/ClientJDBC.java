
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import utilitairesMG.divers.Clavier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author afpa1800
 */
public class ClientJDBC
{

    private static Socket socketServeur;
    private static ObjectInputStream entree;
    private static ObjectOutputStream sortie;
    private static FenetreClient fenetreClient;
    private static String requete;
    private static Object reponse;

    public static void main(String[] args) throws IOException
    {
        //--------------------------------------------------------
        // SocketServeur : reference d'une socket vers le serveur
        // Sortie        : flux vers le serveur
        // Entree        : flux en provenance du serveur
        //--------------------------------------------------------
        

        fenetreClient = new FenetreClient("Client JDBC");

    }

    public static void connexionClient()
    {
        try
        {
            System.out.println("Requete SQL : ");
            requete = Clavier.readString();

            //------------------------------------------------------------------
            // L'instanciation de l'objet Socket ouvre la connexion avec le
            // serveur. Si le serveur est indisponible, il y a lancement d'une
            // ConnectException.
            //------------------------------------------------------------------
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

            Clavier.readString();

        } catch (ConnectException e)
        {
            System.out.println("Connexion impossible : serveur indisponible");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void deconnexionClient()
    {

    }
}
