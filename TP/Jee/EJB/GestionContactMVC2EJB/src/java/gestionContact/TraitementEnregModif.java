package gestionContact;

import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metierMapping.*;
import objetDistant.MappingRemote;

public class TraitementEnregModif
{
   private MappingRemote base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public TraitementEnregModif(MappingRemote base)
   {
      this.base = base;
   }

// --------------------------------------------------------------------------
// Traitement d’annulation de la modification
// --------------------------------------------------------------------------
    public String annulationModif(HttpServletRequest requete)
    {
        String jspRetour;

        Contact contact;
        HttpSession session = requete.getSession();

        contact = (Contact)session.getAttribute("contact");

        jspRetour = "/jspAccueil.jsp";
        session.setAttribute("message", "Modification annulée");
        session.setAttribute("numeroContact", contact.getNumero().toString());
        session.setAttribute("choixAction", "modification");
        return jspRetour;
    }


// --------------------------------------------------------------------------
// Traitement d'enregistrement de la modification et affichage de l'ecran de
// confirmation de la modification
// --------------------------------------------------------------------------
   public String enregModif(HttpServletRequest requete)
   {
      String jspRetour;
      Contact contact;
      HttpSession session = requete.getSession();

      contact = (Contact)session.getAttribute("contact");

      String nom = requete.getParameter("nom");
      if (nom.compareTo("") == 0) nom = null;

      String adresse = requete.getParameter("adresse");
      if (adresse.compareTo("") == 0) adresse = null;

      String codePostal = requete.getParameter("codePostal");
      if (codePostal.compareTo("") == 0) codePostal = null;

      String ville = requete.getParameter("ville");
      if (ville.compareTo("") == 0) ville = null;

      String stringCodeSecteur = requete.getParameter("codeSecteur");
      Integer codeSecteur = null;
      if (stringCodeSecteur.compareTo("") != 0)
         codeSecteur = new Integer(stringCodeSecteur);

// --------------------------------------------------------------------------
// Modification de l'objet contact
// --------------------------------------------------------------------------
      contact.setNom(nom);
      contact.setAdresse(adresse);
      contact.setCodePostal(codePostal);
      contact.setVille(ville);
      contact.setCodeSecteur(codeSecteur);

      try
      {
         int retour = base.modifierContact(contact);
         if (retour != 0)
         {
            jspRetour = "/jspEnregModif.jsp";
            session.setAttribute("contact", contact);
         }
         else
         {
            jspRetour = "/jspModif.jsp";

            Vector<Secteur> vSect =
               (Vector<Secteur>)session.getAttribute("vSect");
            session.setAttribute("contact", contact);
            session.setAttribute("vSect", vSect);
            session.setAttribute("message", "Contact supprimé");
         }
      }
      catch(SQLException e)
      {
         jspRetour = "/jspModif.jsp";

         Vector<Secteur> vSect =
            (Vector<Secteur>)session.getAttribute("vSect");
         session.setAttribute("contact", contact);
         session.setAttribute("vSect", vSect);
         session.setAttribute("message", "Erreur : " + e.getMessage());
      }

      return jspRetour;
   }
}
