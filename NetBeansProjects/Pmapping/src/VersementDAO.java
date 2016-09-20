
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import utilitairesMG.divers.DateFr;
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
public class VersementDAO {
    
    private JeuResultat resultats;
    private BaseDeDonnees base;
    
    public VersementDAO(BaseDeDonnees base)
    {
        this.base = base;
    }
    
    
    public Vector<Versement> lireListe(Contact contact) throws SQLException
    {
        Vector<Versement> listeVersements = new Vector<>();
        Versement versement;
        String requete;
        
        requete = "SELECT * FROM VERSEMENT WHERE NUMERO_CONTACT = " + contact.getNumero();

        resultats = base.executeQuery(requete);
        
        int nbreVersements = (resultats.getLignes()).size();
        Vector ligneVersement = null;
        
        for(int i = 0; i < nbreVersements; i++)
        {
            ligneVersement = (Vector) ((resultats.getLignes()).elementAt(i));
        
        
        versement = new Versement();
        versement.setNumero((Integer) ligneVersement.elementAt(0));
        versement.setDate((Date) ligneVersement.elementAt(1));
        versement.setMontant((BigDecimal) ligneVersement.elementAt(2));
        versement.setNumeroContact((Integer) ligneVersement.elementAt(3));
        listeVersements.addElement(versement);
        }
       
        
        return listeVersements;
    }
    
}
