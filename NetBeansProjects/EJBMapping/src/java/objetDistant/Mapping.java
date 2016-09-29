/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetDistant;

import daoJdbcMapping.ContactDAO;
import daoJdbcMapping.SecteurDAO;
import java.sql.SQLException;
import java.util.Vector;
import javax.ejb.Stateless;
import metierMapping.Contact;
import metierMapping.Secteur;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.BaseDeDonnees;

/**
 *
 * @author afpa1800
 */
@Stateless
public class Mapping implements MappingRemote
{

    private static ContactDAO contactDAO;
    private static SecteurDAO secteurDAO;
    private static BaseDeDonnees base;
    
    public Mapping()
    {
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
        secteurDAO = new SecteurDAO(base);
    }
    

    @Override
    public Contact lireContact(Integer numero) throws SQLException
    {
        Contact contact = new Contact();
        contact.setNumero(numero);

        base.getConnection();

        try
        {
            contactDAO.lire(contact);
        }
        catch (Exception e)
        {
        }
        finally
        {
            base.closeConnection();
        }

        return contact;
    }

    @Override
    public Vector<Vector> lireListeContacts() throws SQLException
    {
        Vector<Vector> retour = new Vector<>();
        Vector<Contact> listeContact = new Vector<Contact>();
        Vector<Colonne> listeColonne = new Vector<Colonne>();

        base.getConnection();

        try
        {
            listeContact = contactDAO.lireListe();
            listeColonne = contactDAO.getListeColonnes();
            retour.addElement(listeContact);
            retour.addElement(listeColonne);
        }

        finally
        {
            base.closeConnection();
        }
        return retour;
    }

    @Override
    public int modifierContact(Contact contact) throws SQLException
    {
        int rows;
        base.getConnection();
        try
        {
            rows = contactDAO.modifier(contact);
        }
        finally
        {
            base.closeConnection();
        }
        return rows;
    }

    @Override
    public Vector<Vector> lireListeSecteurs() throws SQLException
    {
        Vector<Vector> retour = new Vector<>();
        Vector<Secteur> listeSecteurs = new Vector<Secteur>();
        Vector<Colonne> listeColonne = new Vector<Colonne>();
        
        base.getConnection();
        
        try
        {
            listeSecteurs = secteurDAO.lireListe();
            listeColonne = secteurDAO.getListeColonnes();
            retour.addElement(listeSecteurs);
            retour.addElement(listeColonne);
        }
        finally
        {
            base.closeConnection();
        }
        return retour;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
