package clientcontactdistantpool;

import java.sql.SQLException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import objetDistant.ContactDistantPoolRemote;

public class Main
{
    public static void main(String[] args) throws NamingException
    {

// ----------------------------------------------------------------------------
// Acces a l'objet distant
// ----------------------------------------------------------------------------
        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        ContactDistantPoolRemote contact =
                (ContactDistantPoolRemote)ctx.lookup("jndiContactDistantPool");

// ----------------------------------------------------------------------------
// Appel de la methode distante
// ----------------------------------------------------------------------------
        try
        {
            System.out.println(contact.lireContact(102));
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
