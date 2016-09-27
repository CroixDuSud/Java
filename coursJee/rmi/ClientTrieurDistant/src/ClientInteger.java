// ==========================================================================
// Projet RMI TrieurDistant
// --------------------------------------------------------------------------
// ClientInteger : Client de l'objet distant Trieur (tri d'un tableau
// d'entiers).
// ==========================================================================

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;
import objetDistant.Trieur;


public class ClientInteger
{
   public static void main(String args[])
   {

      Comparable tabInteger[] = new Integer[10];
      Random r = new Random();

// --------------------------------------------------------------------------
// Remplissage et affichage du tableau d'Integer a trier:
// --------------------------------------------------------------------------
      System.out.println("Tableau avant le tri :\n");
      for (int i = 0; i < tabInteger.length; i++)
      {
         tabInteger[i] = new Integer(r.nextInt(201));
         System.out.println(tabInteger[i]);
      }

// --------------------------------------------------------------------------
// Acces au serveur d'adressage : Il faut marquer son adresse IP
// --------------------------------------------------------------------------
        try
        {
           String adresse = "//localhost:6128";

// --------------------------------------------------------------------------
// Acces a l'objet distant reference sur le serveur d'adressage par le nom
// "trieur".
// --------------------------------------------------------------------------
           Trieur trieur = (Trieur)Naming.lookup(adresse + "/trieur");

// --------------------------------------------------------------------------
// Utilisation de la methode trier de l'objet distant
// --------------------------------------------------------------------------
           tabInteger = trieur.trier(tabInteger);

// --------------------------------------------------------------------------
// Affichage du tableau trie
// --------------------------------------------------------------------------
           System.out.println("\n\nTableau apres le tri :\n");
           for (int i = 0; i < tabInteger.length; i++)
           {
              System.out.println(tabInteger[i]);
           }
        }
        catch (NotBoundException | MalformedURLException | RemoteException e)
        {
            e.printStackTrace();
        }
    }
}
