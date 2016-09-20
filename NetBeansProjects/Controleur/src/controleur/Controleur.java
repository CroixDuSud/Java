// ==========================================================================
// Classe Controleur                                      Application JTable7
// -------------------------------------------------------------------------- 
// La JTable est modifiable.
// ==========================================================================
package controleur;

import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import utilitairesMG.graphique.*;
import utilitairesMG.divers.*;
import utilitairesMG.jdbc.BaseDeDonnees;
import utilitairesMG.jdbc.JeuResultat;

public class Controleur {

    private static Fenetre fenetre;
    private static ContactDAO contactDAO_memo;
    private static Ifenetre fenetreContacts;
    private static BaseDeDonnees base;
    private static JeuResultat resultats;

// -------------------------------------------------------------------------- 
// Programme principal de l'application.
// -------------------------------------------------------------------------- 
    public static void main(String args[]) throws IOException{

// --------------------------------------------------------------------------
// Chargement du pilote
// --------------------------------------------------------------------------
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("test");
        }
        
        catch(ClassNotFoundException e)
        {
            System.out.println("Echec de chargement du pilote SQLServer.");
            System.out.println(e.getMessage());
        }

// -------------------------------------------------------------------------- 
// Affichage de la fenetre.
// -------------------------------------------------------------------------- 
        LF.setLF();
        fenetre = new Fenetre("GestionContactLocal");
    }

// -------------------------------------------------------------------------- 
// Arret de l'application.
// -------------------------------------------------------------------------- 
    public static void arreter(Vector<Contact> listeContacts,
            Vector<Contact> listeContactsModifies,
            Vector<Contact> listeContactsInseres,
            Vector<Contact> listeContactsSupprimes) {
        System.exit(0);
    }

    public static void recupContacts() {

        ContactDAO contactDAO = new ContactDAO();
        fenetre.afficheContacts(contactDAO.getListe(),
                contactDAO.getListeColonnes());

    }

    public static void decrireContacts(Vector<Contact> listeContacts,
            Vector<Contact> listeContactsModifies,
            Vector<Contact> listeContactsInseres,
            Vector<Contact> listeContactsSupprimes) {
        fenetre.reactiveContacts();
        System.out.println("Tous les contacts :\n" + listeContacts);
        System.out.println("\n\nContacts modifies :\n" + listeContactsModifies);
        System.out.println("\n\nContacts inseres :\n" + listeContactsInseres);
        System.out.println("\n\nContacts supprimes :\n" + listeContactsSupprimes);
    }

    public static void afficherMessageVersements() {
        fenetre.messageVersements();
    }

    public static void afficherMessageSecteur() {
        fenetre.messageSecteur();
    }

    public static void quitterProgramme() {
        System.exit(0);
    }

    public static void annulerQuitter() {
        fenetre.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public static void appelFermetureFenetreInterne() {
        fenetre.fenetreInterneFermee();
    }
    
    public static void connexionBDD()
    {
        //Connection connexion = null;
        
        //try
    }
}
