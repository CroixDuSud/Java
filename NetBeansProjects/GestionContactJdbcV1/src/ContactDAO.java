// ==========================================================================
// Classe ContactDAO                         Application GestionContactJdbcV1
// ==========================================================================

import java.util.*;
import utilitairesMG.jdbc.*;
import utilitairesMG.divers.*;
import java.sql.*;

public class ContactDAO
{

// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Base de donnees liee a la table CONTACT
// --------------------------------------------------------------------------
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Jeu de resultats lu par le executeQuery("SELECT * FROM CONTACT")
// Il contient toutes les donnees des lignes lues dans la table CONTACT et 
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public ContactDAO(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Liste des contacts
// --------------------------------------------------------------------------
    public Vector<Contact> lireListe() throws SQLException
    {
        Vector<Contact> listeContacts;
        Contact contact;

// --------------------------------------------------------------------------
// SELECT a executer
// --------------------------------------------------------------------------
        String select = "SELECT * FROM CONTACT";

        int nombreDeContacts;
        Vector ligneContact;
        int i;

        jeuResultat = base.executeQuery(select);

        listeContacts = new Vector<Contact>();
        nombreDeContacts = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeContacts; i++)
        {
            ligneContact = (Vector) ((jeuResultat.getLignes()).elementAt(i));

            contact = new Contact();
            contact.setNumero((Integer) ligneContact.elementAt(0));
            contact.setNom((String) ligneContact.elementAt(1));
            contact.setAdresse((String) ligneContact.elementAt(2));
            contact.setCodePostal((String) ligneContact.elementAt(3));
            contact.setVille((String) ligneContact.elementAt(4));
            contact.setCodeSecteur((Integer) ligneContact.elementAt(5));
            listeContacts.addElement(contact);
        }

        return listeContacts;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table Contact
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
