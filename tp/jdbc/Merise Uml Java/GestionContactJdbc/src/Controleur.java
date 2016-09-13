// ==========================================================================
// Classe Controleur                                Projet GestionContactJdbc
// ==========================================================================

import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.*;
import utilitairesMG.jdbc.*;
import java.sql.*;
import daoJdbcMapping.*;
import metierMapping.*;

public class Controleur
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
    private static Fenetre maFenetre;
    private static ContactDAO contactDAO;
    private static SecteurDAO secteurDAO;
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
// Creation des objets DAO 
// --------------------------------------------------------------------------
        contactDAO = new ContactDAO(base);
        secteurDAO = new SecteurDAO(base);

// --------------------------------------------------------------------------
// Affichage de la fenetre de l'application
// --------------------------------------------------------------------------
        LF.setLF();
        maFenetre = new Fenetre("GestionContactJdbc");
    }

// --------------------------------------------------------------------------
// Creation du vecteur des contacts et du vecteur des colonnes a afficher.
// Appel de l'affichage de la fenetre contact... 
// --------------------------------------------------------------------------
    public static void creeListeContacts()
    {
        Vector<Contact> listeContacts;
        Vector<Colonne> listeColonnes;
        Vector<Secteur> listeSecteurs;

        try
        {
            base.getConnection();

            try
            {
                listeContacts = contactDAO.lireListe();
                listeColonnes = contactDAO.getListeColonnes();
                listeSecteurs = secteurDAO.lireListe();

                maFenetre.afficheFenetreContact(listeContacts,
                    listeColonnes,
                    listeSecteurs);
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
    public static void majContacts(Vector<Contact> contactsInseres,
        Vector<Contact> contactsModifies,
        Vector<Contact> contactsSupprimes)
    {
        Contact contact;
        int nombreDeContacts;
        int i;
        int nombreModifs;

// --------------------------------------------------------------------------
// Mise a jour de l'affichage de la fenetre principale. Ici, cela consiste
// a revalider le menu d'affichage de la table CONTACT.
// --------------------------------------------------------------------------
        maFenetre.valideItemContact();

        try
        {

// --------------------------------------------------------------------------
// Transaction : cela suppose que la connexion est gardee entre chaque
// operation (creation, modification...). Sinon, la connexion etant perdue
// apres l'operation et le commit non fait, la modif est perdue...
// --------------------------------------------------------------------------
            base.getConnection().setAutoCommit(false);

// --------------------------------------------------------------------------
// 1. Destruction des contacts du vecteur contactsSupprimes.
// --------------------------------------------------------------------------
            try
            {
                for (i = 0; i < contactsSupprimes.size(); i++)
                {
                    contact = contactsSupprimes.elementAt(i);
                    try
                    {
                        nombreModifs = contactDAO.detruire(contact);
                        System.out.println("Destruction : " + nombreModifs);
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

// --------------------------------------------------------------------------
// 2. Sauvegarde du vecteur des Contacts inseres dans la base de donnees.
// --------------------------------------------------------------------------
                nombreDeContacts = contactsInseres.size();

                for (i = 0; i < nombreDeContacts; i++)
                {
                    contact = contactsInseres.elementAt(i);

                    try
                    {
                        nombreModifs = contactDAO.creer(contact);
                        System.out.println("Insertion : " + nombreModifs);
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

// --------------------------------------------------------------------------
// 3. Sauvegarde du vecteur des Contacts modifies dans la base de donnees.
// --------------------------------------------------------------------------
                nombreDeContacts = contactsModifies.size();

                for (i = 0; i < nombreDeContacts; i++)
                {
                    contact = contactsModifies.elementAt(i);

                    try
                    {
                        nombreModifs = contactDAO.modifier(contact);
                        System.out.println("Modif : " + nombreModifs);
                    }
                    catch (SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }

// --------------------------------------------------------------------------
// Fin de la transaction.
// --------------------------------------------------------------------------
                base.getConnection().commit();
            }
            finally
            {
                base.closeConnection();
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
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
