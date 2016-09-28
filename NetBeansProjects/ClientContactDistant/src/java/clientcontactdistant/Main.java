/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientcontactdistant;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import metierMapping.Contact;
import objetDistant.ContactDistantRemote;

/**
 *
 * @author afpa1800
 */
public class Main
{

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException
    {

        Contact contact;

        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        ContactDistantRemote contactDistantRemote = (ContactDistantRemote) ctx.lookup("jndiContactDistant");

        contact = contactDistantRemote.lireContact(110);

        System.out.println(contact);
    }

}
