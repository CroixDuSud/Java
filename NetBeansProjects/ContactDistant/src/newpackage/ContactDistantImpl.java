/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import daoJdbcMapping.ContactDAO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import metierMapping.Contact;
import utilitairesMG.jdbc.BaseDeDonnees;

/**
 *
 * @author afpa1800
 */
public class ContactDistantImpl extends UnicastRemoteObject implements ContactDistant
{

    private static ContactDAO contactDAO;
    private static BaseDeDonnees base;

    public ContactDistantImpl() throws RemoteException
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
    public Contact lireContact(Integer numero) throws RemoteException
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
