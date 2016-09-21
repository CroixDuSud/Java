// ==========================================================================
// Classe Controleur                              Projet GestionContactJdbcV1
// ==========================================================================

import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.*;
import utilitairesMG.jdbc.*;
import java.sql.*;

public class Controleur
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
    private static Fenetre maFenetre;
    private static ContactDAO contactDAO;
    private static BaseDeDonnees base;

// --------------------------------------------------------------------------
// Methode main : lancement de l'application
// --------------------------------------------------------------------------
    public static void main(String args[])
    {

// --------------------------------------------------------------------------
// Chargement du driver SQL
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver inconnu : " + e.getMessage());
            System.exit(0);
        }

// --------------------------------------------------------------------------
// Base(s) de donnees utilisee(s)
// --------------------------------------------------------------------------
        base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;"
            + "password=x;databasename=gnmi");

// --------------------------------------------------------------------------
// Creation de l'objet DAO
// --------------------------------------------------------------------------
        contactDAO = new ContactDAO(base);

// --------------------------------------------------------------------------
// Affichage de la fenetre de l'application
// --------------------------------------------------------------------------
        LF.setLF();
        maFenetre = new Fenetre("GestionContactJdbc - Version 1");
    }

// --------------------------------------------------------------------------
// Creation du vecteur des contacts et du vecteur des colonnes a afficher.
// Appel de l'affichage de la fenetre contact... 
// --------------------------------------------------------------------------
    public static void creeListeContacts()
    {
        Vector<Contact> listeContacts;
        Vector<Colonne> listeColonnes;

        try
        {
            base.getConnection();

            try
            {
                listeContacts = contactDAO.lireListe();
                listeColonnes = contactDAO.getListeColonnes();

                maFenetre.afficheFenetreContact(listeContacts, listeColonnes);
            }
            catch (SQLException e)
            {
                maFenetre.afficheMessage(e.getMessage());
            }
            finally
            {
                base.closeConnection();
            }
        }
        catch (SQLException e)
        {
            maFenetre.afficheMessage(e.getMessage());
        }
    }

// --------------------------------------------------------------------------
// Creation du vecteur des versements et du vecteur des colonnes a afficher.
// --------------------------------------------------------------------------
    public static void creeListeVersements()
    {
        maFenetre.afficheMessage("Gestion des versements non réalisée");
    }

// --------------------------------------------------------------------------
// Creation du vecteur des secteurs et du vecteur des colonnes a afficher.
// --------------------------------------------------------------------------
    public static void creeListeSecteurs()
    {
        maFenetre.afficheMessage("Gestion des secteurs non réalisée");
    }

// --------------------------------------------------------------------------
// Mise a jour de la table CONTACT. 
// --------------------------------------------------------------------------
// Cette methode est appelee lors de la fermeture de la fenetre interne
// Contact. 
// --------------------------------------------------------------------------
    public static void majContacts(Vector<Contact> contactsModifies,
        Vector<Contact> contactsInseres,
        Vector<Contact> contactsSupprimes)
    {

// --------------------------------------------------------------------------
// Mise a jour de l'affichage de la fenetre principale. Ici, cela consiste
// a revalider le menu d'affichage de la table CONTACT.
// --------------------------------------------------------------------------
        maFenetre.valideItemContact();

// --------------------------------------------------------------------------
// Affichage des vecteurs de contacts recus par la methode.
// --------------------------------------------------------------------------
        System.out.println("\nListe des contacts modifies :\n");

        if (contactsModifies.size() == 0)
        {
            System.out.println("Il n'y a pas de contacts modifies.");
        }
        else
        {
            for (int i = 0; i < contactsModifies.size(); i++)
            {
                System.out.println(contactsModifies.elementAt(i));
            }
        }

        System.out.println("\n\nListe des contacts inseres :\n");

        if (contactsInseres.size() == 0)
        {
            System.out.println("Il n'y a pas de contacts inseres.");
        }
        else
        {
            for (int i = 0; i < contactsInseres.size(); i++)
            {
                System.out.println(contactsInseres.elementAt(i));
            }
        }

        System.out.println("\n\nListe des contacts supprimes :\n");

        if (contactsSupprimes.size() == 0)
        {
            System.out.println("Il n'y a pas de contacts supprimes.");
        }
        else
        {
            for (int i = 0; i < contactsSupprimes.size(); i++)
            {
                System.out.println(contactsSupprimes.elementAt(i));
            }
        }
    }

// --------------------------------------------------------------------------
// Arret de l'application. 
// --------------------------------------------------------------------------
    public static void arreter()
    {
        System.exit(0);
    }
}
