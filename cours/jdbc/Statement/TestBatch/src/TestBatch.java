// ==========================================================================
// APPLICATION TestBatch                                 
// --------------------------------------------------------------------------
// Cette application reprend TestInsert mais en utilisant executeBatch qui
// permet de lancer plusieurs requetes en meme temps (plus rapide)
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestBatch
{
    public static void main(String args[]) throws IOException
    {
        String requeteSQL;
        BaseDeDonnees base;
        Connection connexion;
        Statement traitement;
        int[] codesRetour;
        int i;

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
            base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;"
                + "password=x;databasename=gnmi");

// --------------------------------------------------------------------------
// Etablir une connection a la base
// --------------------------------------------------------------------------
            try
            {
                connexion = base.getConnection();

// --------------------------------------------------------------------------
// Creation d'un objet Statement pour y ajouter les requetes            
// --------------------------------------------------------------------------
                try
                {
                    traitement = connexion.createStatement();

// --------------------------------------------------------------------------
// Exécution de la requete
// --------------------------------------------------------------------------
                    try
                    {
                        requeteSQL = "DELETE FROM EMPLOYE";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(1, 'Fumier Infect', NULL, '25-04-2015')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(4, 'Crevure Puante', 2214, NULL)";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(7, 'Pauvre Type', 1331, '24-03-2015')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(10, 'Vieux Tordu', 1811, '5-11-2014')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(17, 'Ordure Abjecte', 800, '12-10-2015')";
                        traitement.addBatch(requeteSQL);
                        System.out.println(requeteSQL + " ajoutee...");

                        codesRetour = traitement.executeBatch();

                        System.out.println("\nTableau des codes retour :");

                        for (i = 0; i < codesRetour.length; i++)
                        {
                            System.out.println("codesRetour[" + i + "] = " + codesRetour[i]);
                        }
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    finally
                    {
                        traitement.close();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println(e.getMessage());
                }
                finally
                {
                    base.closeConnection();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Connexion impossible.");
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
