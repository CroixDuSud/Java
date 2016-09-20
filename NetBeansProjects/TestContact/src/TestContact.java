import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import utilitairesMG.divers.*;

/**
 *
 * @author afpa1800
 */
public class TestContact {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {
        private Integer numero;
        private String nom;
        private String adresse;
        private String codePostal;
        private String ville;
        private Integer codeSecteur;

        File dossier;
        File fichierEntree;
        File fichierSortie;

        BufferedReader entree;
        PrintWriter sortie;
        String ligne;
        StringTokenizer token;

        String chaine;
        ArrayList<Contact> listeContact = new ArrayList<Contact>();

        /* --------------------------------------------------------
                Ouverture des flux
        ----------------------------------------------------------*/

        dossier = new File("F:\\Afpa\\Java\\tp\\bases\\flux\\fichiers textes\\fichiers");
        fichierEntree = new File(dossier, "contacts.txt");
        fichierSortie = new File(dossier, "contactsTries");

        try
        {
            entree = new BufferedReader(new FileReader(fichierEntree));
            sortie = new PrintWriter(new FileWriter(fichierSortie));

            try
            {
                ligne = entree.readLine();
                while(ligne != null)
                {
                    /*---------------------------------------------
                            Traitement des données
                    ---------------------------------------------*/

                    token = new StringTokenizer(ligne,";");

                    numero = token.nextToken();
                    nom = token.nextToken();
                    adresse = token.nextToken();
                    codePostal = token.nextToken();
                    ville = token.nextToken();
                    codeSecteur = token.nextToken();

                    listeContact.add(numero);
                    listeContact.add(nom);
                    listeContact.add(adresse);
                    listeContact.add(codePostal);
                    listeContact.add(ville);
                    listeContact.add(codeSecteur);

                    ligne = entree.readLine();

                }
            }
            finally
            {
                entree.close();
                sortie.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Le fichier " + fichierEntree.getName() + " n'a pas été trouvé.");

        }
    }
}

