package contactJsp;

import java.sql.SQLException;
import java.util.Vector;
import utilitairesMG.jdbc.*;
import javax.servlet.http.*;
import objetDistant.MappingEntityRemote;
import tables.*;

public class TraitementModif 
{
    MappingEntityRemote mapping;
    
    public TraitementModif(MappingEntityRemote mapping)
    {
        this.mapping = mapping;
    }
    
    public String modifierContact( HttpServletRequest request) 
    {
        Contact contact;
        Secteur secteur;
        Vector<Secteur> listeSecteurs;
        String retour;
        int resultModif;
        
        HttpSession session;
              
        session = request.getSession();
        contact = (Contact)session.getAttribute("contact");
        listeSecteurs = (Vector<Secteur>)session.getAttribute("listeSecteurs");
        
        String nom = request.getParameter("nom");
        String adresse = request.getParameter("adresse");
        String codePostal = request.getParameter("codePostal");
        String ville = request.getParameter("ville");
        String strCodeSecteur = request.getParameter("codeSecteur");
        
        try
        {
            int codeSecteur = Integer.parseInt(strCodeSecteur);
            secteur = mapping.lireSecteur(codeSecteur);
        }
        catch(NumberFormatException ex)
        {
            secteur = null;
        }
        
        contact.setNom(((nom.equals(""))? null : nom));
        contact.setAdresse(((adresse.equals(""))? null : adresse));
        contact.setCodePostal(((codePostal.equals(""))? null : codePostal));
        contact.setVille(((ville.equals(""))? null : ville));
        contact.setCodeSecteur(secteur);
        
        resultModif = mapping.modifierContact(contact);
        if(resultModif == 0)
        {
            session.setAttribute("numContact", contact.getNumero());
            retour = "/enregModif.jsp";
        }
        else
        {
            /*if(resultModif == 1)
            {
                session.setAttribute("message", "***L'enregistrement a échoué, le contact " 
                                    + contact.getNumero()+" n'existe plus!***");
                session.setAttribute("action", "modif");
                session.setAttribute("numContact", contact.getNumero());
                retour = "/accueil.jsp";
            }
            else*/
            {
                session.setAttribute("message", "***L'enregistrement a échoué, le contact " 
                                    + contact.getNumero()+" n'existe plus!***");
                session.setAttribute("action", "modif");
                session.setAttribute("numContact", contact.getNumero());
                retour = "/accueil.jsp";
            }
        }
       
        return retour;
    }
    
    public String annulerModif( HttpServletRequest request) 
    {
        HttpSession session;
        Contact contact;
              
        session = request.getSession();
        contact = (Contact)session.getAttribute("contact");
        
        session.setAttribute("message", "**Modification annulée**");
        session.setAttribute("action", "modif");
        session.setAttribute("numContact", contact.getNumero());
                
        return "/accueil.jsp";
    }
}
