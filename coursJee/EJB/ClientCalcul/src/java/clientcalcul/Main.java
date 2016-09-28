package clientcalcul;

import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.*;
import objetDistant.CalculRemote;

public class Main 
{
    public static void main(String[] args) throws NamingException, IOException
    {

// ----------------------------------------------------------------------------
// Le serveur JNDI est sur la meme machine que l'application courante
// ----------------------------------------------------------------------------
//        Context ctx = new InitialContext();
//        CalculRemote calcul = (CalculRemote)ctx.lookup("calcul");

// ----------------------------------------------------------------------------
// Le serveur JNDI est sur une autre machine que l'application courante
// ----------------------------------------------------------------------------
        Hashtable variablesEnv = new Hashtable();
        variablesEnv.put("org.omg.CORBA.ORBInitialHost", "localhost");
        variablesEnv.put("org.omg.CORBA.ORBInitialPort", "3700");

        Context ctx = new InitialContext(variablesEnv);
        CalculRemote calcul = (CalculRemote)ctx.lookup("jndiCalcul");

        int i = 17;

        System.out.println("\n\nRacine cubique de " + i + " = " + 
                           calcul.racine3(i));
        System.out.println("Racine carree de " + i +  " =  " + 
                           calcul.racine2(i) + "\n\n");
        System.out.println("Carre de " + i +  " =  " + 
                           calcul.carre(i) + "\n\n");
    }
}
