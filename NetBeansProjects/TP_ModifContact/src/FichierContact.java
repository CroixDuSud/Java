import java.io.*;
import utilitairesMG.divers.*;
import java.util.*;

/**
 *
 * @author afpa1800
 */
public class FichierContact extends Fichier
{

    public FichierContact(String nom, String mode) throws IOException
	{
		super(nom, mode, 108);
	}

	public void lireListe() throws FileNotFoundException, IOException
	{
		String ligne;
            BufferedReader entree;
            PrintWriter sortie;
      
            Vector<Comparable> vecteur = new Vector<Comparable>();
            Contact contact;
      
            StringTokenizer token;
            String mot;
            int n;
      	
            entree = new BufferedReader(new FileReader("contacts.csv"));
            sortie = new PrintWriter(new FileWriter("contactsTries.txt"));
            ligne = entree.readLine();
      	
            while (ligne != null)
            {
// --------------------------------------------------------------------------
// Creation du contact correspondant a la ligne lue
// --------------------------------------------------------------------------
                contact = new Contact();
         
// --------------------------------------------------------------------------
// Traitement de la ligne lue
// --------------------------------------------------------------------------
                token = new StringTokenizer(ligne, ";");

// --------------------------------------------------------------------------
// Extraction des proprietes du Contact et modification du Contact
// --------------------------------------------------------------------------
                mot = token.nextToken();
                n = Integer.parseInt(mot);
                contact.setNumero(n);
         
                mot = token.nextToken();
                contact.setNom(mot);
         
                mot = token.nextToken();
                contact.setAdresse(mot);
         
                mot = token.nextToken();
                contact.setCodePostal(mot);
         
                mot = token.nextToken();
                contact.setVille(mot);
         
                mot = token.nextToken();
                n = Integer.parseInt(mot);
                contact.setCodeSecteur(n);

// --------------------------------------------------------------------------
// Ajout au vecteur
// --------------------------------------------------------------------------
                vecteur.addElement(contact);
                ligne = entree.readLine();
            }

// --------------------------------------------------------------------------
// Affichage
// --------------------------------------------------------------------------
            System.out.println("Contacts avant tri : \n");
            TriBulleVecteur.afficher(vecteur);

            System.out.println("\n\nContacts apres tri : \n");
            TriBulleVecteur.trier(vecteur);
            TriBulleVecteur.afficher(vecteur);

// --------------------------------------------------------------------------
// Ecriture dans le fichier texte
// --------------------------------------------------------------------------
            for (int i = 0; i < vecteur.size(); i++)
            {
                sortie.println(vecteur.elementAt(i)); 
            }

            entree.close();
            sortie.close();

        }

	public void lire(Contact contact, int numEnreg)
	{
		// à compléter
	}

	public void lire(Contact contact)
	{
		// // à compléter
	}

	public void ecrire(Contact contact, int numEnreg)
	{

	}

	public void ecrire(Contact contact) throws IOException
	{
		writeInt(contact.getNumero());
		writeString(contact.getNom(),21);
		writeString(contact.getAdresse(),51);
		writeString(contact.getCodePostal(),6);
		writeString(contact.getVille(),21);
		writeByte(0);
		writeInt(contact.getCodeSecteur());
	}
        
}
