
import java.sql.SQLException;
import java.util.Vector;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.BaseDeDonnees;
import utilitairesMG.jdbc.JeuResultat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afpa1800
 */
public class SecteurDAO {
    
    //-------------------------------
    // Déclaration des variables
    //-------------------------------
    
    private JeuResultat resultats;
    private BaseDeDonnees base;
    
    public SecteurDAO(BaseDeDonnees base)
    {
        this.base = base;
    }
    
    public Secteur lireSecteur(Contact contact) throws SQLException
    {
        Vector ligneSecteur;
        String requete;
        Secteur secteur = new Secteur();
        
        
        requete = "SELECT * FROM SECTEUR WHERE code = " + contact.getCodeSecteur();
        
        resultats = base.executeQuery(requete);
        
        
        
        ligneSecteur = (Vector) ((resultats.getLignes()).elementAt(0));
        
        secteur.setCode((Integer) ligneSecteur.elementAt(0));
        secteur.setLibelle((String) ligneSecteur.elementAt(1));
        
        return secteur;
    }
}