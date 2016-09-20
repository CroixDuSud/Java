import java.io.*;
import java.util.StringTokenizer;
import utilitairesMG.divers.*;

/**
 *
 * @author afpa1800
 */
public class TestTotalNotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        
        File repository;
        File fichierEntree;
	File fichierSortie;	
	BufferedReader entree;
	PrintWriter sortie;
		
	String chaine;
        String result[];
        StringTokenizer st;
        String tab[];
        int i;
        
		
	/* ==========================================
		Ouverture des flux
	===========================================*/
		
        repository = new File("C:\\Users\\afpa1800\\Desktop\\PoufPasteque");
	fichierEntree = new File(repository, "notes.txt");
	fichierSortie = new File(repository, "notesBis.txt");
        
        try
        {
            entree = new BufferedReader(
                     new InputStreamReader(
                            new FileInputStream(fichierEntree)));
            sortie = new PrintWriter(
                     new OutputStreamWriter(
                            new FileOutputStream(fichierSortie), "ISO-8859-1"));

// --------------------------------------------------------------------------
// Boucle de recopie.
// --------------------------------------------------------------------------
            try
            {
                System.out.println("\nDebut de la recopie du fichier");

                chaine = entree.readLine();
                
                
                //for (int i = 0; i <= tab.length; i++)
                while (chaine != null)
                {        
                        st = new StringTokenizer(chaine);
			chaine = entree.readLine();
                        
			while (st.hasMoreTokens())
                        {
                            //System.out.println(st.nextToken());
                            i = Integer.parseInt(chaine);
                            System.out.println(i);
			}						
                }
            }
            finally
            {
                entree.close();
                sortie.close();
            }

            System.out.println("\nFin de la recopie du fichier");
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    } 
}

