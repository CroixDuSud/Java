// ==========================================================================
// APPLICATION TestTransaction                                 
// --------------------------------------------------------------------------
// Transaction - commit - rollback
// ==========================================================================

import java.sql.*;
import java.io.*;
import utilitairesMG.jdbc.*;

public class TestTransaction
{
    public static void main(String args[]) throws IOException
    {
        int codeRetour;
        String requeteSQL;
        BaseDeDonnees base;
        Connection connexion;

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

                try
                {
                    connexion.setAutoCommit(false);

// --------------------------------------------------------------------------
// Exécution de la requete
// --------------------------------------------------------------------------
                    try
                    {
                        requeteSQL = "UPDATE EMPLOYE SET EMPSAL = EMPSAL * 1.1";
                        codeRetour = base.executeUpdate(requeteSQL);
                        System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                        requeteSQL = "DELETE FROM EMPLOYE WHERE EMPNUM = 17";
                        codeRetour = base.executeUpdate(requeteSQL);
                        System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                        requeteSQL = "INSERT INTO EMPLOYE VALUES"
                            + "(17, 'Ordure Abjecte', 800, '12-10-2011')";
                        codeRetour = base.executeUpdate(requeteSQL);
                        System.out.println(requeteSQL + "\nCode retour = " + codeRetour);

                        connexion.commit();
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Erreur requete.");
                        System.out.println(e.getMessage());
                        connexion.rollback();
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Erreur setAutoCommit().");
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
