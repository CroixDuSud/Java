package objetDistant;

import daoJdbcMapping.ContactDAO;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import metierMapping.*;
import utilitairesMG.jdbc.BaseDeDonnees;


@Stateless
public class ContactDistantPool implements ContactDistantPoolRemote
{
   private BaseDeDonnees base;
   private DataSource ds;

// ----------------------------------------------------------------------------
// Chargement de l'EJB : ouverture de la connexion a la base
// ----------------------------------------------------------------------------
   @PostConstruct
   public void ouvreBase()
   {
      base = new BaseDeDonnees();

      try
      {
         Context ctx = new InitialContext();
         ctx.addToEnvironment("org.omg.CORBA.ORBInitialHost", "localhost");
         ctx.addToEnvironment("org.omg.CORBA.ORBInitialPort", "3700");
         ds = (DataSource)ctx.lookup("jndiPoolGnmi");
      }
      catch(NamingException e)
      {
         System.out.println(e.getMessage());
      }
   }

// ----------------------------------------------------------------------------
// Implementation de la methode de l'interface
// ----------------------------------------------------------------------------
   public Contact lireContact(Integer numeroContact) throws SQLException
   {
      Contact contact = new Contact();
      ContactDAO contactDAO;
      contact.setNumero(numeroContact);

      base.setConnection(ds.getConnection());
      contactDAO = new ContactDAO(base);

      try
      {
         contactDAO.lire(contact);
      }
      finally
      {
         base.closeConnection();
      }
      return contact;
   }
}
