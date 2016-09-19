// ==========================================================================
// APPLICATION TestInsert                                 
// --------------------------------------------------------------------------
// Creation d'un objet Statement - Execution de requetes INSERT
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestInsert
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;
        String requeteSQL;
        BaseDeDonnees base;

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
                base.getConnection();

// --------------------------------------------------------------------------
// Exécution de la requete
// --------------------------------------------------------------------------
                try
                {
                    requeteSQL = "DELETE FROM EMPLOYE";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(1, 'Fumier Infect', NULL, '25-04-2015')";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(4, 'Crevure Puante', 2214, NULL)";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(7, 'Pauvre Type', 1331, '24-03-2015')";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(10, 'Vieux Tordu', 1811, '5-11-2014')";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                    requeteSQL = "INSERT INTO EMPLOYE VALUES"
                        + "(17, 'Ordure Abjecte', 800, '12-10-2015')";
                    codeRetour = base.executeUpdate(requeteSQL);
                    System.out.println(requeteSQL + "\nCode retour = " + codeRetour);
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
