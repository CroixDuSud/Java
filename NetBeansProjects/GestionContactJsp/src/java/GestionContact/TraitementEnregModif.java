/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionContact;

// ==========================================================================
// Classe TraitementEnregModif                   Projet gestionContactServlet
// ==========================================================================

import daoJdbcMapping.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import metierMapping.*;
import utilitairesMG.jdbc.BaseDeDonnees;

public class TraitementEnregModif
{
   private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
   public TraitementEnregModif(BaseDeDonnees base)
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
// Enregistrement de la modification et affichage de l'ecran de confirmation
// de la modification
// --------------------------------------------------------------------------
   public String enregModif(HttpServletRequest requete)
   {
      String servlet;

      Contact contact;
      Vector<Secteur> vSect;

      HttpSession session = requete.getSession();
      ContactDAO contactDAO;

      contact = (Contact)session.getAttribute("contact");
      vSect = (Vector<Secteur>)session.getAttribute("vSect");

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
         base.getConnection();
         contactDAO = new ContactDAO(base);

         try
         {
            int retour = contactDAO.modifier(contact);
            if (retour != 0)
            {
               servlet = "/jspEnregModif.jsp";
               session.setAttribute("contact", contact);
            }
            else
            {
               servlet = "/jspModif.jsp";
               session.setAttribute("message", "Le contact " + 
                                               contact.getNumero() +
                                               " a été supprimé");
               session.setAttribute("contact", contact);
               session.setAttribute("vSect", vSect);
            }
         }
         catch(SQLException e)
         {
            servlet = "/jspModif.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("contact", contact);
            session.setAttribute("vSect", vSect);
         }
         finally
         {
            base.closeConnection();
         }
      }
      catch(SQLException e)
      {
         servlet = "/jspModif.jsp";
         session.setAttribute("message", e.getMessage());
         session.setAttribute("contact", contact);
         session.setAttribute("vSect", vSect);
      }

      return servlet;
   }
}

