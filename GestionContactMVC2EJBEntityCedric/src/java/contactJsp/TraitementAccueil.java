package contactJsp;

import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import objetDistant.MappingEntityRemote;
import tables.*;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.*;

public class TraitementAccueil 
{
    MappingEntityRemote mapping;
    
    public TraitementAccueil(MappingEntityRemote mapping )
    {
        this.mapping = mapping;
    }

    public String traitementListe(HttpServletRequest request) 
    {
        Vector<Contact> listeContacts;
        Vector<Colonne> listeColonnes;
        String retour;
        
        HttpSession session;
        
        session = request.getSession();
              
        listeContacts = mapping.lireListeContacts();
        listeColonnes = mapping.lireListeColonnes("tables.Contact");
        
        if(listeContacts != null && listeColonnes != null)
        {    
            session.setAttribute("listeContacts", listeContacts);
            session.setAttribute("listeColonnes", listeColonnes);
            session.setAttribute("message", "");
            session.setAttribute("action", "list");
            retour = "/liste.jsp";
        }
        else
        {
            session.setAttribute("message","** Erreur : impossible de générer la liste des contacts **");
            session.setAttribute("action", "list");
            retour = "/accueil.jsp";
        }
           
        return retour;
    }
    
    public String traitementModif(HttpServletRequest request) 
    {
        Contact contact;
        Vector<Secteur> listeSecteurs;
        
        String retour;
        
        HttpSession session;
        
        contact = new Contact();
        
        session = request.getSession();
        String StringNumContact = request.getParameter("numContact");
        try
        {
            Integer numContact = new Integer(StringNumContact);

            contact = mapping.lireContact(numContact);
            listeSecteurs = mapping.lireListeSecteurs();
            if(contact != null)
            {
                session.setAttribute("contact", contact);
                session.setAttribute("listeSecteurs", listeSecteurs);
                session.setAttribute("message", "");
                retour = "/modif.jsp";                
            }
            else
            {
                session.setAttribute("message","** Le contact " + StringNumContact + " n'existe pas **");
                session.setAttribute("numContact", StringNumContact);
                session.setAttribute("action", "modif");
                retour = "/accueil.jsp";
            }
        }
        catch(NumberFormatException ex)
        {
            session.setAttribute("message",ex.getMessage());
            session.setAttribute("numContact", StringNumContact);
            session.setAttribute("action", "modif");
            retour = "/accueil.jsp";
        }
        
        return retour;
    }

    public String traitementSuppr(HttpServletRequest request) 
    {
        HttpSession session;
        String retour;

        session = request.getSession();
        retour = "/accueil.jsp";
        
        String StringNumContact = request.getParameter("numContact");
        session.setAttribute("message","Ecran de suppression non réalisé");
        session.setAttribute("numContact", StringNumContact);
        session.setAttribute("action", "suppr");
        return retour;
    }

    public String traitementCreat(HttpServletRequest request) 
    {
        Vector<Secteur> listeSecteurs;
        Vector<Contact> listeContacts;
        
        HttpSession session;
        String retour;
        
        session = request.getSession();
        
        String StringNumContact = request.getParameter("numContact");
        try
        {
            Integer numContact = new Integer(StringNumContact);
            listeContacts = mapping.lireListeContacts();
            
            boolean present = false;
            int i = 0;
            while(i < listeContacts.size() && !present)
            {
                if(listeContacts.get(i).getNumero().equals(numContact))
                {
                    present = true;
                }
                i++;
            }
            if(!present)
            {
                Contact contact = new Contact();
                contact.setNumero(numContact);
                retour = "/creation.jsp";
                listeSecteurs = mapping.lireListeSecteurs();
                session.setAttribute("contact", contact);
                session.setAttribute("listeSecteurs", listeSecteurs);
                session.setAttribute("message","");
            }
            else
            {
                session.setAttribute("message","** Le contact " 
                                    + StringNumContact + " existe déjà . "
                                    + "Vous pouvez vérifier dans la liste des"
                                    + " contacts un numéro disponible **");
                session.setAttribute("numContact", StringNumContact);
                session.setAttribute("action", "creat");
                retour = "/accueil.jsp";
            }
        }
        catch(NumberFormatException ex)
        {
            session.setAttribute("message",ex.getMessage());
            session.setAttribute("numContact", StringNumContact);
            session.setAttribute("action", "creat");
            retour = "/accueil.jsp";
        }
        return retour;
    }
}
