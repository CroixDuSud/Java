// ==========================================================================
// Classe Controleur                              Projet GestionContactJdbcV1
// ==========================================================================

import daoJdbcMapping.VersementDAO;
import daoJdbcMapping.SecteurDAO;
import daoJdbcMapping.ContactDAO;
import metierMapping.Contact;
import java.util.*;
import utilitairesMG.divers.*;
import utilitairesMG.graphique.*;
import utilitairesMG.jdbc.*;
import java.sql.*;
import metierMapping.Secteur;
import metierMapping.Versement;

public class Controleur
{

// --------------------------------------------------------------------------
// PROPRIETES
// --------------------------------------------------------------------------
    private static Fenetre maFenetre;
    private static ContactDAO contactDAO;
    private static VersementDAO versementDAO;
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
        } catch (ClassNotFoundException e)
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
        secteurDAO = new SecteurDAO(base);

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
        Vector<Secteur> listeSecteurs;

        try
        {
            base.getConnection();

            try
            {
                listeContacts = contactDAO.lireListe();
                listeColonnes = contactDAO.getListeColonnes();
                listeSecteurs = secteurDAO.lireListe();

                maFenetre.afficheFenetreContact(listeContacts, listeColonnes, listeSecteurs);
            } catch (SQLException e)
            {
                maFenetre.afficheMessage(e.getMessage());
            } finally
            {
                base.closeConnection();
            }
        } catch (SQLException e)
        {
            maFenetre.afficheMessage(e.getMessage());
        }
    }

// --------------------------------------------------------------------------
// Creation du vecteur des versements et du vecteur des colonnes a afficher.
// --------------------------------------------------------------------------
    public static void creeListeVersements()
    {
        Vector<Versement> listeVersements;
        Vector<Colonne> listeColonnes;
        Vector<Contact> listeContacts;

        try
        {
            base.getConnection();

            try
            {

                listeContacts = contactDAO.lireListe();
                listeVersements = versementDAO.lireListe();
                listeColonnes = versementDAO.getListeColonnes();

            } catch (Exception e)
            {
                maFenetre.afficheFenetreVersement(listeVersements, listeColonnes, listeContacts);
            }
            finally
            {
                base.closeConnection();
            }
        }
        catch(SQLException e)
        {
            maFenetre.afficheMessage(e.getMessage());
        }
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
        try
        {
            base.getConnection();

            try
            {
                System.out.println("\nListe des contacts modifies :\n");

                if (contactsModifies.size() == 0)
                {
                    System.out.println("Il n'y a pas de contacts modifies.");
                } else
                {
                    for (int i = 0; i < contactsModifies.size(); i++)
                    {
                        try
                        {
                            contactDAO.modifier(contactsModifies.elementAt(i));
                            System.out.println(contactsModifies.elementAt(i));
                        } catch (Exception e)
                        {
                            maFenetre.afficheMessage("Modification des contacts impossible");
                        }
                    }
                }

                System.out.println("\n\nListe des contacts inseres :\n");

                if (contactsInseres.size() == 0)
                {
                    System.out.println("Il n'y a pas de contacts inseres.");
                } else
                {
                    for (int i = 0; i < contactsInseres.size(); i++)
                    {
                        try
                        {
                            contactDAO.creer(contactsInseres.elementAt(i));
                            System.out.println(contactsInseres.elementAt(i));
                        } catch (Exception e)
                        {
                            maFenetre.afficheMessage("Ajout des contacts impossible");
                        }
                    }
                }

                System.out.println("\n\nListe des contacts supprimes :\n");

                if (contactsSupprimes.size() == 0)
                {
                    System.out.println("Il n'y a pas de contacts supprimes.");
                } else
                {
                    for (int i = 0; i < contactsSupprimes.size(); i++)
                    {
                        try
                        {
                            contactDAO.detruire(contactsSupprimes.elementAt(i));
                            System.out.println(contactsSupprimes.elementAt(i));
                        } catch (SQLException e)
                        {
                            maFenetre.afficheMessage("Suppression des contacts impossible");
                        }
                    }
                }
            } finally
            {
                base.closeConnection();
            }
        } catch (SQLException e)
        {
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
