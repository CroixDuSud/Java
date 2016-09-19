// ==========================================================================
// APPLICATION TestJdbcSqlInit
// --------------------------------------------------------------------------
// Chargement du pilote JDBC de SQL*Server.
// Connexion a une base de donnees SQL*Server.
// Creation d'un objet Statement pour executer des requetes SQL.
// Execution d'un SELECT SQL.
// Affichage des donnees lues.
// ==========================================================================

import java.sql.*;
import java.io.*;

public class TestJdbcSqlInit
{
    public static void main(String args[]) throws IOException
    {

// --------------------------------------------------------------------------
// Chargement du pilote :
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver inconnu");
        }

// --------------------------------------------------------------------------
// Etablir la connexion :
// --------------------------------------------------------------------------
// Il s'agit de demander au DriverManager d'etablir une connexion avec une
// base de donnees. On appelle pour cela la methode getConnection(). Le
// DriverManager demande alors a chaque pilote charge s'il est capable 
// d'etablir une connexion avec l'URL passee en parametre de la methode 
// getConnection(). Si c'est le cas, il instancie un objet de type 
// Connection et en retourne la reference.
// --------------------------------------------------------------------------
// Une URL jdbc est de la forme : jdbc:<sous-protocole>:<info complementaire>
// Ici, le sous-protocole est sqlserver. 
// --------------------------------------------------------------------------
        Connection connexion = null;

        try
        {
            connexion = DriverManager.getConnection(
                "jdbc:sqlserver://mars;"
                + "user=UTIL_BIP;password=x;"
                + "databasename=gnmi");
        }
        catch (SQLException e)
        {
            System.out.println("Connexion impossible.");
            System.out.println(e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Creation d'un objet Statement, lie a la connexion, qui va permettre 
// l'execution d'une requete...
// --------------------------------------------------------------------------
        Statement requete = null;

        try
        {
            requete = connexion.createStatement();
        }
        catch (SQLException e)
        {
            System.out.println("Creation requete incorrecte.");
            System.out.println(e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Execution de la requete (executeQuery de l'objet Statement) :
// --------------------------------------------------------------------------
// Le UTIL_BIP devant DEPARTEMENT est necessaire si la connexion est faite 
// avec le user et le mot de passe de la session (pas UTIL_BIP, x), car la
// table DEPARTEMENT a ete creee par l'utilisateur UTIL_BIP...
// --------------------------------------------------------------------------
// Le resultat est recupere dans un objet de type ResultSet.
// La classe ResultSet fournit les methodes qui permettent d'exploiter les
// resultats.
// --------------------------------------------------------------------------
// ResultSetMetaData : objet qui va contenir les résultats de la requete
// concernant les colonnes (noms, nombre, type...).
// --------------------------------------------------------------------------
        ResultSet resultats = null;
        ResultSetMetaData colonnes = null;

        try
        {
            resultats = requete.executeQuery(
                "SELECT * FROM CONTACT WHERE NOM LIKE '%G%'");
            colonnes = resultats.getMetaData();
        }
        catch (SQLException e)
        {
            System.out.println("Requete incorrecte.");
            System.out.println(e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Affichage des resultats :
// --------------------------------------------------------------------------
// La methode next() passe a la LIGNE suivante du ResultSet. Le premier appel
// de next() permet de se positionner sur la premiere ligne, si elle existe.
// La methode getString(i) permet de lire la ieme valeur(colonne) de la ligne 
// sur laquelle on est positionne.
// --------------------------------------------------------------------------
// nomColonne : nom de colonne lu dans le ResultSetMetaData colonnes.
// texte : valeur contenue dans la table, lue dans le ResultSet resultats.
// --------------------------------------------------------------------------
        String nomColonne;
        String texte;

        try
        {
            int numeroLigne = 0;
            boolean eof = false;

            eof = !resultats.next();
            if (eof == true)
            {
                System.out.println("Aucune ligne selectionnee.");
                System.exit(0);
            }

            while (eof == false)
            {
                numeroLigne++;
                System.out.println("\n---------------------------");
                System.out.println("ligne numero : " + numeroLigne);

                for (int i = 1; i <= colonnes.getColumnCount(); i++)
                {
                    nomColonne = colonnes.getColumnName(i);
                    texte = resultats.getString(i);
                    System.out.println(nomColonne + " = " + texte);
                }
                eof = !resultats.next();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Erreur affichage des resultats.");
            System.out.println(e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Fermeture du ResultSet, de la requete et de la connexion.
// --------------------------------------------------------------------------
        try
        {
            resultats.close();
            requete.close();
            connexion.close();
        }
        catch (SQLException e)
        {
            System.out.println("Incident a la fermeture.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
