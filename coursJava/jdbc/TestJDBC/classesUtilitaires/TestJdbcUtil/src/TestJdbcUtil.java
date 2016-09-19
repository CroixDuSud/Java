// ==========================================================================
// APPLICATION TestJdbcUtil
// --------------------------------------------------------------------------
// Cet exemple reprend l'exemple TestJdbcSql avec utilisation des classes
// utilitaires de utilitairesMG...
// ==========================================================================

import java.sql.*;
import java.io.*;
import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.jdbc.*;

public class TestJdbcUtil
{

    public static void main(String args[]) throws IOException
    {

// ==========================================================================
// DECLARATIONS
// ==========================================================================
        BaseDeDonnees base;
        JeuResultat resultats;

// --------------------------------------------------------------------------
// listeLignes : liste des lignes selectionnees.
// listeColonnes : liste des colonnes selectionnees.
// --------------------------------------------------------------------------
        Vector<Vector<Object>> listeLignes;
        Vector<Colonne> listeColonnes;

// ==========================================================================
// PROGRAMME
// ==========================================================================
// --------------------------------------------------------------------------
// Chargement du pilote qui assure la connexion à la base de données.
// La methode forName "charge la classe" SQLServerDriver du package
// com.microsoft.sqlserver.jdbc.
// --------------------------------------------------------------------------
// Erreur possible : ClassNotFoundException
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

// --------------------------------------------------------------------------
// Base(s) de donnees utilisee(s)
// --------------------------------------------------------------------------
            base = new BaseDeDonnees(
                "jdbc:sqlserver://mars;"
                + "user=UTIL_BIP;password=x;"
                + "databasename=gnmi");

// --------------------------------------------------------------------------
// Etablir une connection a la base
// --------------------------------------------------------------------------
            try
            {
                base.getConnection();

// --------------------------------------------------------------------------
// Exécution de la requete
// --------------------------------------------------------------------------
                try
                {
                    resultats = base.executeQuery("SELECT * FROM VERSEMENT");

// --------------------------------------------------------------------------
// Liste des colonnes
// --------------------------------------------------------------------------
                    System.out.println("Liste des colonnes :\n");
                    listeColonnes = resultats.getColonnes();

                    for (int i = 0; i < listeColonnes.size(); i++)
                    {
                        System.out.println(listeColonnes.elementAt(i));
                    }

// --------------------------------------------------------------------------
// Liste des lignes
// --------------------------------------------------------------------------
                    System.out.println("\n\nListe des lignes :\n");
                    listeLignes = resultats.getLignes();

                    for (int i = 0; i < listeLignes.size(); i++)
                    {
                        System.out.println(listeLignes.elementAt(i));
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Requete impossible");
                    System.out.println(e.getMessage());
                }
                finally
                {
                    base.closeConnection();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Connexion impossible");
                System.out.println(e.getMessage());
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Echec du chargement du pilote SQLServer.");
            System.out.println(e.getMessage());
        }
    }
}
