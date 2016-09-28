/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetDistant;

import daoJdbcMapping.ContactDAO;
import java.sql.SQLException;
import javax.ejb.Stateless;
import metierMapping.Contact;
import utilitairesMG.jdbc.BaseDeDonnees;

/**
 *
 * @author afpa1800
 */
@Stateless
public class ContactDistant implements ContactDistantRemote
{

    private static ContactDAO contactDAO;
    private static BaseDeDonnees base;

    public ContactDistant()
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
    }

    @Override
    public Contact lireContact(Integer numero)
    {
        Contact contact = new Contact();
        contact.setNumero(numero);

        try
        {
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
        }
        catch (SQLException e)
        {
        }
        return contact;
    }
}
