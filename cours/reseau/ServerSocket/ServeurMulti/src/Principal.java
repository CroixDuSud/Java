
// ==========================================================================
// Projet serveurMulti : serveur multiThreads (echo)
// --------------------------------------------------------------------------
// Principal : programme principal de lancement du serveur.
// ==========================================================================
import java.io.*;
import utilitairesMG.divers.*;

public class Principal
{
    public static void main(String[] argv) throws IOException
    {
        ServeurMulti serveur;

// --------------------------------------------------------------------------
// Affichage du nom du thread principal (main)
// --------------------------------------------------------------------------
// En fait, la methode statique currentThread() retourne la reference du
// Thread courant. L'affichage direct de cette reference fait appel
// implicitement a la methode toString() de la classe Thread. Cette methode
// affiche le nom du thread, sa priorite, et le nom du groupe auquel il
// appartient.
// --------------------------------------------------------------------------
// Si on ne veut que le nom, utiliser getName().
// --------------------------------------------------------------------------
        System.out.println("Thread principal : " + Thread.currentThread());

// --------------------------------------------------------------------------
// ServeurMulti est une classe de type Thread. L'instanciation est faite dans
// le Thread main. Ce n'est qu'a partir du start() que le nouveau Thread
// demarre.
// --------------------------------------------------------------------------
        serveur = new ServeurMulti();
        serveur.start();
        System.out.println("Le serveur a demarre...");

        System.out.println("\n\nTapez Entree pour l'arreter...");
        Clavier.readString();

// --------------------------------------------------------------------------
// L'execution de la methode interrupt envoie un signal au Thread serveur.
// La methode interrupted() de celui-ci renvoie alors la valeur true.
// --------------------------------------------------------------------------
        serveur.interrupt();

// --------------------------------------------------------------------------
// Le Thread main se termine ici. Toutefois, tant que tous les Threads client
// crees par le serveur tournent, l'application continue de tourner (la
// Clavier reste ouverte). Quand tous les Threads sont arretes, la Clavier
// se ferme.
// --------------------------------------------------------------------------
        System.out.println("Le serveur a ete arrete...");
    }
}
