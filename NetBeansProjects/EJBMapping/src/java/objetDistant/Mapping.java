/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetDistant;

import daoJdbcMapping.ContactDAO;
import java.sql.SQLException;
import java.util.Vector;
import javax.ejb.Stateless;
import metierMapping.Contact;
import utilitairesMG.jdbc.BaseDeDonnees;

/**
 *
 * @author afpa1800
 */
@Stateless
public class Mapping implements MappingRemote
{
    
    private static ContactDAO contactDAO;
    private static BaseDeDonnees base;

    @Override
    public Contact lireContact(Integer numero) throws SQLException
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

    @Override
    public Vector<Vector> lireListeContacts() throws SQLException
    {
        try
        {
            base.getConnection();
            
            try
            {
                contactDAO.modifier(contact)
            }
            catch (Exception e)
            {
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            base.closeConnection();
        }
    }

    @Override
    public int modifierContact(Contact contact) throws SQLException
    {
        int rows;
        try
        {
            base.getConnection();
            try
            {
                rows = contactDAO.modifier(contact);
                
            }
            catch (Exception e)
            {
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            base.closeConnection();
        }
        return 0;
    }

    @Override
    public Vector<Vector> lireListeSecteurs() throws SQLException
    {
        try
        {
            base.getConnection();
        }
        catch (Exception e)
        {
        }
        finally
        {
            base.closeConnection();
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
