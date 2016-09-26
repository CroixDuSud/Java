/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContact;

// ==========================================================================
// Classe TraitementAccueil                      Projet gestionContactServlet
// --------------------------------------------------------------------------
// Cette classe est en fait une "extension" de ServletAccueil. Elle sert a
// alleger le code de la Servlet.
// ==========================================================================

import daoJdbcMapping.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metierMapping.*;
import utilitairesMG.divers.Colonne;
import utilitairesMG.jdbc.BaseDeDonnees;


public class TraitementAccueil
{
   private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public TraitementAccueil(BaseDeDonnees base)
   {
      this.base = base;
   }

// --------------------------------------------------------------------------
// Traitement d'affichage de la liste
// --------------------------------------------------------------------------
   public String traitementListe(HttpServletRequest requete)
   {
      String jspString;
      Vector<Contact> listeContacts;
      Vector<Colonne> listeColonnes;
      HttpSession session = requete.getSession();

      ContactDAO contactDAO;

// --------------------------------------------------------------------------
// L'objet ContactDAO est une variable locale de la methode. Elle est creee a
// chaque appel (et liberee a la fin). Il s'agit d'eviter le melange de
// donnees entre plusieurs utilisateurs. En effet, la ServletAccueil est
// instanciée une fois. La classe TraitementAccueil une fois également. Si
// l'objet ContactDAO etait declaree en propriete de la classe
// TraitementAccueil, elle serait commune a tous les utilisateurs. Or, un
// objet ContactDAO contient une propriete de type JeuResultat qui est
// modifiee a chaque lecture dans la base.
// --------------------------------------------------------------------------
      try
      {
         base.getConnection();
         contactDAO = new ContactDAO(base);

         try
         {
            listeContacts = contactDAO.lireListe();
            listeColonnes = contactDAO.getListeColonnes();

            jspString = "/jspListe.jsp";
            session.setAttribute("listeContacts", listeContacts);
            session.setAttribute("listeColonnes", listeColonnes);
         }
         catch (SQLException e)
         {
            jspString = "/jspAccueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "liste");
         }
         finally
         {
            base.closeConnection();
         }
      }
      catch(SQLException e)
      {
         jspString = "/jspAccueil.jsp";
         session.setAttribute("message", e.getMessage());
         session.setAttribute("numeroContact", "");
         session.setAttribute("choixAction", "liste");
      }
      return jspString;
   }

// --------------------------------------------------------------------------
// Traitement d'affichage de l'ecran de modification
// --------------------------------------------------------------------------
   public String traitementModif(HttpServletRequest requete)
   {
      String jspString;

      Contact contact;
      Integer numeroContact;
      Vector<Secteur> vSect;
      HttpSession session = requete.getSession();

      ContactDAO contactDAO;
      SecteurDAO secteurDAO;

      String chaineNumeroContact = requete.getParameter("numeroContact");

      try
      {
         base.getConnection();
         contactDAO = new ContactDAO(base);
         secteurDAO = new SecteurDAO(base);

         try
         {
            numeroContact = Integer.parseInt(chaineNumeroContact);
            contact = new Contact();
            contact.setNumero(numeroContact);
            contactDAO.lire(contact);

            vSect = secteurDAO.lireListe();
            
            jspString = "/jspModif.jsp";
            session.setAttribute("message", "");
            session.setAttribute("contact", contact);
            session.setAttribute("vSect", vSect);
         }
         catch(SQLException e)
         {
            jspString = "/jspAccueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", chaineNumeroContact);
            session.setAttribute("choixAction", "modification");
         }
         catch(NumberFormatException e)
         {
            jspString = "/jspAccueil.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("numeroContact", chaineNumeroContact);
            session.setAttribute("choixAction", "modification");
         }
         finally
         {
            base.closeConnection();
         }
      }
      catch(SQLException e)
      {
         jspString = "/jspAccueil.jsp";
         session.setAttribute("message", e.getMessage());
         session.setAttribute("numeroContact", chaineNumeroContact);
         session.setAttribute("choixAction", "modification");
      }

      return jspString;
   }

// --------------------------------------------------------------------------
// Traitement d'affichage du message non realise sur l'ecran d'accueil
// --------------------------------------------------------------------------
   public String traitementNonRealise(HttpServletRequest requete)
   {
      String jspString;
      HttpSession session = requete.getSession();

      String choixAction = requete.getParameter("choixAction");
      String chaineNumeroContact = requete.getParameter("numeroContact");

      jspString = "/jspAccueil.jsp";
      session.setAttribute("message", "Ecran de " + choixAction + " non réalisé");
      session.setAttribute("choixAction", choixAction);
      session.setAttribute("numeroContact", chaineNumeroContact);

      return jspString;
   }
}


