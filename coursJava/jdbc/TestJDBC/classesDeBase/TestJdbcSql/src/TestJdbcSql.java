// ==========================================================================
// APPLICATION TestJdbcSql
// --------------------------------------------------------------------------
// Chargement du driver SQL*Server
// Connexion a une base de donnees.
// Creation d'un objet Statement pour executer des requetes SQL.
// Execution d'un SELECT SQL.
// Affichage des donnees lues.
// --------------------------------------------------------------------------
// Ce programme comporte des blocs try...catch imbriques pour une ecriture
// correctement structuree
// ==========================================================================

import java.sql.*;
import java.io.*;

public class TestJdbcSql
{
    public static void main(String args[]) throws IOException
    {

// ==========================================================================
// DECLARATIONS
// ==========================================================================
        Connection connexion;
        Statement requete;
        ResultSet resultats;
        ResultSetMetaData colonnes;

// --------------------------------------------------------------------------
// nomColonne : nom de colonne lu dans le ResultSetMetaData colonnes.
// numeroLigne : pour afficher le numero de ligne du ResultSet.
// eof : vrai si on est en fin de ResultSet.
// --------------------------------------------------------------------------
        String nomColonne;
        int numeroLigne;
        boolean eof;

// ==========================================================================
// PROGRAMME
// ==========================================================================
// --------------------------------------------------------------------------
// Chargement du pilote qui assure la connexion à la base de données.
// --------------------------------------------------------------------------
// L'appel de Class.forname indique a la JVM qu'elle doit trouver, charger
// et initialiser la classe passee en parametre. L'initialisation comprend
// l'enregistrement de cette classe aupres du gestionnaire de pilotes. Ce
// gestionnaire est la classe DriverManager (utilisee plus loin...). Il 
// conserve une reference de tous les pilotes charges.
// --------------------------------------------------------------------------
// Erreur possible : ClassNotFoundException
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Chargement du driver reussi.");

// --------------------------------------------------------------------------
// Etablir la connexion : si la connexion a la base de donnees reussit, la 
// variable connexion recoit la reference d'un objet de type Connection pret 
// a executer les methodes de l'interface Connection. 
// Si le parametre databasename est ommis, c'est une base par defaut qui est
// ouverte (cdr2 a l'Afpa).
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
            try
            {
                connexion = DriverManager.getConnection(
                    "jdbc:sqlserver://mars;"
                    + "user=UTIL_BIP;password=x;"
                    + "databasename=gnmi");
                System.out.println("Connexion a la base reussie.");

// --------------------------------------------------------------------------
// Creation de la requete (objet Statement) :
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
                try
                {
                    requete = connexion.createStatement();
                    System.out.println("Creation du statement reussie.");

// --------------------------------------------------------------------------
// Execution de la requete (objet Statement) :
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
                    try
                    {
                        resultats = requete.executeQuery(
                            "SELECT * FROM CONTACT WHERE NOM LIKE '%M%'");
                        colonnes = resultats.getMetaData();

                        System.out.println("Requete correcte.");

// --------------------------------------------------------------------------
// Affichage des resultats :
// --------------------------------------------------------------------------
// La methode next() passe a la LIGNE suivante du ResultSet. Le premier appel
// de next() permet de se positionner sur la premiere ligne, si elle existe.
// La methode getString(i) permet le lire la ieme valeur(colonne) de la ligne 
// sur laquelle on est positionne.
// --------------------------------------------------------------------------
// Erreur possible : SQLException
// --------------------------------------------------------------------------
                        try
                        {
// --------------------------------------------------------------------------
// Affichage des caracteristiques des colonnes
// --------------------------------------------------------------------------
                            System.out.println("\nListe des colonnes :\n");
                            for (int i = 1; i <= colonnes.getColumnCount(); i++)
                            {
                                System.out.println(
                                    colonnes.getColumnName(i) + " :\n"
                                    + colonnes.getColumnClassName(i)
                                    + " Taille : "
                                    + colonnes.getColumnDisplaySize(i));
                            }

// --------------------------------------------------------------------------
// Affichage du ResultSet
// --------------------------------------------------------------------------
                            System.out.println("\nResultat du Select :\n");
                            numeroLigne = 0;
                            eof = false;

                            eof = !resultats.next();
                            if (eof == true)
                            {
                                System.out.println("Aucune ligne selectionnee.");
                            }

                            while (eof == false)
                            {
                                numeroLigne++;
                                System.out.println("\n---------------------------");
                                System.out.println("ligne numero : " + numeroLigne);

                                for (int i = 1; i <= colonnes.getColumnCount(); i++)
                                {
                                    nomColonne = colonnes.getColumnName(i);
                                    System.out.println(nomColonne + " = "
                                        + resultats.getObject(i));
                                }
                                eof = !resultats.next();
                            }
                        }
                        catch (SQLException e)
                        {
                            System.out.println("Erreur affichage des resultats.");
                            System.out.println(e.getMessage());
                        }
                        finally
                        {
                            try
                            {
                                resultats.close();
                            }
                            catch (SQLException e)
                            {
                                System.out.println("Incident fermeture ResultSet.");
                            }

                        }
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Requete incorrecte.");
                        System.out.println(e.getMessage());
                    }
                    finally
                    {
                        try
                        {
                            requete.close();
                            System.out.println("\nStatement ferme.");
                        }
                        catch (SQLException e)
                        {
                            System.out.println("Incident fermeture Statement.");
                        }
                    }
                }
                catch (SQLException e)
                {
                    System.out.println("Creation Statement incorrecte.");
                    System.out.println(e.getMessage());
                }
                finally
                {
                    try
                    {
                        connexion.close();
                        System.out.println("Connexion fermee.");
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Incident fermeture connexion.");
                    }
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
