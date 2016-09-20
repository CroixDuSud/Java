
import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;

/**
 *
 * @author afpa1800
 */
public class ControleurServeur

{

    private static ServeurJDBC serveur;
    private static BaseDeDonnees base;
    private static Fenetre fenetre;

    public static void main(String[] args) throws IOException
    {
        // --------------------------------------------------------------------------
        // Chargement du driver SQL
        // --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Driver inconnu : " + e.getMessage());
            System.exit(0);
        }

        //--------------------------------------
        // Lancement de la GUI
        //--------------------------------------
        fenetre = new Fenetre("Serveur JDBC");

        //--------------------------------------
        // Chargement du driver SQL
        //--------------------------------------
    }

    public static void connexion() throws IOException
    {
        try
        {
            //-------------------------------------------------------------------
            // Base de données utilisée par le serveur, ouverture de la connexion
            //-------------------------------------------------------------------
            base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;"
                    + "password=x;databasename=gnmi");

            //-------------------------------------------
            // Lancement du serveur
            //-------------------------------------------
            serveur = new ServeurJDBC(base);

            fenetre.afficheMessage("Le serveur JDBC a demarre...");
            serveur.start();

            //fenetre.afficheMessage("\nTapez Entree pour l'arreter...\n");
            //Clavier.readString();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void deconnexion()
    {
        try
        {
            serveur.interrupt();
            fenetre.afficheMessage("Le serveur a ete arrete...");
        } catch (NullPointerException e)
        {
            System.exit(0);
        }
    }

    public static void afficheRequeteClient(InetAddress adresse, String requete)
    {
        fenetre.afficheMessage("Client  " + adresse + " : " + requete);
    }
}
