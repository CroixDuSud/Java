// ==========================================================================
// Classe ControleurServeur                           Application ServeurJDBC
// --------------------------------------------------------------------------
// ControleurServeur : programme principal de lancement du serveur.
// ==========================================================================

import utilitairesMG.jdbc.*;
import utilitairesMG.graphique.*;

public class ControleurServeur
{

// --------------------------------------------------------------------------
// Le controleur connait :
//    la fenetre de l'application
//    le serveur
//    la base de donnees qui sera utilisee dans les threads clients
// --------------------------------------------------------------------------
    private static FenetreServeur maFenetre;
    private static ServeurJDBC serveur;
    private static BaseDeDonnees base;

// ==========================================================================
// Lancement du serveur
// ==========================================================================
    public static void main(String args[])
    {

// --------------------------------------------------------------------------
// Chargement du driver SQL
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

// --------------------------------------------------------------------------
// Base de donnees utilisee par le serveur, ouverture de la connexion
// --------------------------------------------------------------------------
            base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;"
                + "password=x;databasename=gnmi");

// --------------------------------------------------------------------------
// Affichage de l'ecran d'accueil
// --------------------------------------------------------------------------
            LF.setLF(LF.WindowsLF);
            maFenetre = new FenetreServeur("Serveur XML");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage() + " : Driver inconnu !");
        }
    }

// ==========================================================================
// Demarrage du serveur
// ==========================================================================
    public static void demarrerServeur()
    {
        serveur = new ServeurJDBC(base);
        serveur.start();
    }

// ==========================================================================
// Arret du serveur
// --------------------------------------------------------------------------
// L'execution de la methode interrupt envoie un signal au Thread serveur.
// La methode interrupted() de celui-ci renvoie alors la valeur true.
// ==========================================================================
    public static void arreterServeur()
    {
        serveur.interrupt();
    }

// ==========================================================================
// Envoi de messages a l'ecran
// ==========================================================================
    public static void traiterTexte(String s)
    {
        maFenetre.afficheTexte(s);
    }

// ==========================================================================
// Arret de l'application
// ==========================================================================
    public static void arreter()
    {
        System.exit(0);
    }
}
