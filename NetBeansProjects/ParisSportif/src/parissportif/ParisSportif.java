/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parissportif;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author afpa1800
 */
public class ParisSportif
{
    //private static ServeurJDBC serveur;
    //private static BaseDeDonnees base;
    private static Fenetre fenetre;

    public static void main(String[] args) throws IOException
    {
        // --------------------------------------------------------------------------
        // Chargement du driver SQL
        // --------------------------------------------------------------------------
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Driver inconnu : " + e.getMessage());
            System.exit(0);
        }

        //--------------------------------------
        // Lancement de la GUI
        //--------------------------------------
        fenetre = new Fenetre("Test");

        //--------------------------------------
        // Chargement du driver SQL
        //--------------------------------------
    }
/*
    public static void connexion() throws IOException
    {
        try
        {
            //-------------------------------------------------------------------
            // Base de données utilisée par le serveur, ouverture de la connexion
            //-------------------------------------------------------------------
            base = new BaseDeDonnees("http://localhost:8080;user=root;databasename=paris_sportif");//"jdbc:sqlserver://mars;user=UTIL_BIP;"
                    //+ "password=x;databasename=gnmi");

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
    }*/

    public static void afficheRequeteClient(InetAddress adresse, String requete)
    {
        fenetre.afficheMessage("Client  " + adresse + " : " + requete);
    }
}
