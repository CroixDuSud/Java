/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttrieur;

import java.util.Hashtable;
import java.util.Random;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import objetDistant.TrieurRemote;

/**
 *
 * @author afpa1800
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException
    {

        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        TrieurRemote trieur = (TrieurRemote) ctx.lookup("jndiTrieur");

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

}
