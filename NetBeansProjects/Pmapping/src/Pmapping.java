// ==========================================================================
// CLASSE Controleur                                           Projet Mapping
// ==========================================================================

import java.sql.*;
import java.util.*;
import utilitairesMG.jdbc.*;

public class Pmapping
{
    private static BaseDeDonnees base;

    public static void main(String args[]) throws SQLException
    {
        Contact contact;
        Versement versement;
        Secteur secteur;

        ContactDAO contactDAO;
        VersementDAO versementDAO;
        SecteurDAO secteurDAO;

// --------------------------------------------------------------------------
// Chargement du (des) driver(s) jdbc
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Erreur chargement driver : " + e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Base(s) de donnees utilisee(s)
// --------------------------------------------------------------------------
        base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;"
            + "password=x;databasename=gnmi");
//      base = new BaseDeDonnees("jdbc:mysql://localhost/gnmi?" +
//                               "user=util_bip&password=x");
//      base.setFormatDate("yyyy/MM/dd");                               

// --------------------------------------------------------------------------
// Creation des objets DAO
// --------------------------------------------------------------------------
        contactDAO = new ContactDAO(base);
        versementDAO = new VersementDAO(base);
        secteurDAO = new SecteurDAO(base);

// --------------------------------------------------------------------------
// Connexion et tests de quelques objets du modele
// --------------------------------------------------------------------------
        try
        {
            base.getConnection();

            try
            {
                contact = new Contact();
                contact.setNumero(101);
                contactDAO.lire(contact);
                System.out.println(contact);

                try
                {
                    secteur = secteurDAO.lireSecteur(contact);
                    System.out.println("Secteur : " + secteur.getLibelle() + "\n");
                }
                catch (SQLException e)
                {
                    System.out.println("Code secteur non renseigne\n");
                }

                try
                {
                    Vector<Versement> listeVersements = versementDAO.lireListe(contact);

                    if (listeVersements.size() > 0)
                    {
                        System.out.println("Versements du contact : "
                            + contact.getNom() + "\n");

                        for (int i = 0; i < listeVersements.size(); i++)
                        {
                            versement = listeVersements.elementAt(i);
                            System.out.println("Versement : " + versement.getNumero());
                        }
                    }
                    else
                    {
                        System.out.println("Pas de versement pour ce contact...");
                    }
                }
                catch (SQLException e)
                {
                    System.out.println(e.getMessage());
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
            System.out.println("Echec de la connexion : " + e.getMessage());
        }
    }
}
