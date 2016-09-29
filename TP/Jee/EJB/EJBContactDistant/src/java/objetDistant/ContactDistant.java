package objetDistant;

import daoJdbcMapping.ContactDAO;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import metierMapping.*;
import utilitairesMG.jdbc.*;

@Stateless
public class ContactDistant implements ContactDistantRemote 
{
    private BaseDeDonnees base;
    private ContactDAO contactDAO;

// ----------------------------------------------------------------------------
// Chargement de l'EJB : 
// chargement du driver et création de l'objet BaseDeDonnees
// ----------------------------------------------------------------------------
    @PostConstruct
    public void ouvreBase() 
    {
        try 
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println(e.getMessage());
        }

        base = new BaseDeDonnees("jdbc:sqlserver://mars;user=UTIL_BIP;" +
                                 "password=x;databasename=gnmi");
//        base = new BaseDeDonnees("jdbc:mysql://localhost/gnmi?user=root&password=fennec");

        contactDAO = new ContactDAO(base);

        System.out.print("Ouverture....................................");
    }

// ----------------------------------------------------------------------------
// Dechargement de l'EJB
// ----------------------------------------------------------------------------
    @PreDestroy
    public void fermeBase() 
    {
        System.out.print("Fermeture................................");
    }

// ----------------------------------------------------------------------------
// Implementation de la methode de l'interface
// ----------------------------------------------------------------------------
    public Contact lireContact(Integer numeroContact) throws SQLException 
    {
        Contact contact;
        base.getConnection();

        try 
        {
            contact = new Contact();
            contact.setNumero(numeroContact);
            contactDAO.lire(contact);
        } 
        finally 
        {
            base.closeConnection();
        }

        return contact;
    }
}
