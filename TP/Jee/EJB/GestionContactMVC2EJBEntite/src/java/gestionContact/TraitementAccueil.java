package gestionContact;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import tables.*;
import objetDistant.MappingEntiteRemote;
import utilitairesMG.divers.*;

public class TraitementAccueil
{
   private MappingEntiteRemote base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public TraitementAccueil(MappingEntiteRemote base)
   {
      this.base = base;
   }

// --------------------------------------------------------------------------
// Traitement d'affichage de la liste
// --------------------------------------------------------------------------
   public String traitementListe(HttpServletRequest requete)
   {
      String jspRetour;
      Vector<Contact> listeContacts;
      Vector<Colonne> listeColonnes;
      HttpSession session = requete.getSession();

      try
      {
         listeContacts = base.lireListeContacts();
         listeColonnes = base.lireListeColonnes("tables.Contact");

         jspRetour = "/jspListe.jsp";
         session.setAttribute("message", "");
         session.setAttribute("listeContacts", listeContacts);
         session.setAttribute("listeColonnes", listeColonnes);
      }
      catch (Exception e)
      {
         jspRetour = "/jspAccueil.jsp";
         session.setAttribute("message", "Erreur : " + e.getMessage());
         session.setAttribute("numeroContact", "");
         session.setAttribute("choixAction", "liste");
      }

      return jspRetour;
    }

// --------------------------------------------------------------------------
// Traitement d'affichage de l'ecran de modification
// --------------------------------------------------------------------------
   public String traitementModif(HttpServletRequest requete)
   {
      String jsp;

      Integer numeroContact;
      Contact contact;
      Vector<Secteur> vSect;
      HttpSession session = requete.getSession();

      String chaineNumeroContact = requete.getParameter("numeroContact");

      try
      {
         numeroContact = Integer.parseInt(chaineNumeroContact);
         contact = base.lireContact(numeroContact);

         if (contact != null)
         {
            vSect = base.lireListeSecteurs();

            jsp = "/jspModif.jsp";
            session.setAttribute("message", "");
            session.setAttribute("contact", contact);
            session.setAttribute("vSect", vSect);
         }
         else
         {
            jsp = "/jspAccueil.jsp";
            session.setAttribute("message", "Erreur : contact " +
                                 chaineNumeroContact + " inconnu");
            session.setAttribute("numeroContact", chaineNumeroContact);
            session.setAttribute("choixAction", "modification");
         }
      }
      catch(Exception e)
      {
         jsp = "/jspAccueil.jsp";
         session.setAttribute("message", "Erreur : " + e.getMessage());
         session.setAttribute("numeroContact", chaineNumeroContact);
         session.setAttribute("choixAction", "modification");
      }

      return jsp;
   }

// --------------------------------------------------------------------------
// Traitement d'affichage du message non realise sur l'ecran d'accueil
// --------------------------------------------------------------------------
   public String traitementNonRealise(HttpServletRequest requete)
   {
      String jspRetour;
      HttpSession session = requete.getSession();

      String choixAction = requete.getParameter("choixAction");
      String chaineNumeroContact = requete.getParameter("numeroContact");

      jspRetour = "/jspAccueil.jsp";
      session.setAttribute("message", "Ecran de " + choixAction + " non réalisé");
      session.setAttribute("choixAction", choixAction);
      session.setAttribute("numeroContact", chaineNumeroContact);

      return jspRetour;
   }
}
