/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import metierMapping.Contact;


/**
 *
 * @author afpa1800
 */
public interface ContactDistant extends Remote
{
    // Lecture d'un contact
    
    public Contact lireContact(Integer numero) throws RemoteException;

}
