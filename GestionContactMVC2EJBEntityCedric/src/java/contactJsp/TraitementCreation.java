
package contactJsp;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objetDistant.MappingEntityRemote;
import tables.Contact;
import tables.Secteur;

public class TraitementCreation 
{
    MappingEntityRemote mapping;
    
    public TraitementCreation(MappingEntityRemote mapping )
    {
        this.mapping = mapping;
    }
    
    public String traitementCreer(HttpServletRequest request)
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
        
        resultModif = mapping.creerContact(contact);
        if(resultModif == 0)
        {
            session.setAttribute("numContact", contact.getNumero());
            retour = "/enregCreat.jsp";
        }
        else
        {
            if(resultModif == 1)
            {
                session.setAttribute("message", " ** Création impossible. Le contact " + contact.getNumero() + " existe déjà. **");
                retour = "/";
            }
            else
            {
                session.setAttribute("contact", contact);
                session.setAttribute("message", " ** Attention!!! Le contact " + contact.getNumero() + " existait déjà mais a été supprimé de la base par un autre utilisateur. Valider à nouveau la création pour recréer le contact avec les paramètres entrés.**");
                retour = "/creation.jsp";
            }
        }
        
        return retour;
    }

    public String annulerCreat(HttpServletRequest request) 
    {
        HttpSession session;
        Contact contact;
        
        String retour;
        
        session = request.getSession();
        contact = (Contact)session.getAttribute("contact");
        System.out.println("yoyoyo" + contact);
        session.setAttribute("message", "** Création annulée **");
        session.setAttribute("action", "creat");
        session.setAttribute("numContact", contact.getNumero());
        
        return "/accueil.jsp";
    }
}
