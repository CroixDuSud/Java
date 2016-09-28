/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactdistantclient;

import java.rmi.Naming;
import metierMapping.Contact;
import newpackage.ContactDistant;

/**
 *
 * @author afpa1800
 */
public class ContactDistantClient
{
    public static void main(String[] args)
    {
        Contact contact;// = new Contact();
        
        /*-----------------------------------------------------------
        Acces au serveur d'adressage : il faut marquer son adresse IP
        -----------------------------------------------------------*/
        try
        {
            String adresse = "//localhost:6128";
            
            /*---------------------------------------------------------------
            Acces à l'objet distant reference sur le serveur d'adressage par
            le nom /contact
            ---------------------------------------------------------------*/
            ContactDistant contactDistant = 
                    (ContactDistant) Naming.lookup(adresse + "/contactDistant");
            
            contact = contactDistant.lireContact(110);
            
            System.out.println(contact);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
