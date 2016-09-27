/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactdistant;

import newpackage.ContactDistantImpl;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author afpa1800
 */
public class ContactDistantServer
{
    public static void main(String[] args) throws RemoteException, UnknownHostException, MalformedURLException
    {
        /*-----------------------------------------------
        Lancement du serveur d'adressage sur le port 6128
        -----------------------------------------------*/
        LocateRegistry.createRegistry(6128);
        
        /*-----------------------------------------------
        Affichage de l'adresse du serveur d'adressage
        -----------------------------------------------*/
        String adresse = "//"
                + InetAddress.getLocalHost().getHostAddress()
                + ":6128";
        System.out.println(adresse);
        
        /*--------------------------------------------------------
        Instanciation de l'objet distant
        --------------------------------------------------------*/
        System.out.println("Construction de l'objet distant...");
        ContactDistantImpl contactDistant = new ContactDistantImpl();
        
        /*----------------------------------------------------------------------
        Inscription de l'objet distant sur le serveur d'adressage. Il sera connu
        sous le nom "/contact"
        ----------------------------------------------------------------------*/
       
        System.out.println("Liaison de l'objet distant sur le serveur d'annuaire...");
        Naming.rebind(adresse + "/contactDistant", contactDistant);
    }
}
