// ==========================================================================
// Classe ServletAffichageListe                  Projet gestionContactServlet
// ==========================================================================

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import metierMapping.*;
import utilitairesMG.divers.*;
import utilitairesMG.jee.*;

public class ServletAffichageListe extends HttpServlet
{
   protected void executeRequete(HttpServletRequest requete,
                                 HttpServletResponse reponse)
                                 throws ServletException,
                                        IOException
   {
      String affiche;

      Vector<Contact> listeContacts;
      Vector<Colonne> listeColonnes;

      PrintWriter sortie = reponse.getWriter();

      HttpSession session = requete.getSession();

      try
      {
         listeContacts = (Vector<Contact>)session.getAttribute("listeContacts");
         listeColonnes = (Vector<Colonne>)session.getAttribute("listeColonnes");

// --------------------------------------------------------------------------
// Doctype
// --------------------------------------------------------------------------
         affiche = Xhtml.docType();
         affiche +=
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\">";

// --------------------------------------------------------------------------
// Entete du fichier html
// --------------------------------------------------------------------------
         affiche += Xhtml.head("Liste des contacts");

// --------------------------------------------------------------------------
// Corps du fichier html
// --------------------------------------------------------------------------
         affiche +=    "<body>";
         affiche +=       "<table>"
                 +           "<caption>LISTE DES CONTACTS</caption>"
                 +           "<thead>"
                 +              "<tr>";

// --------------------------------------------------------------------------
// Colonnes
// --------------------------------------------------------------------------
         for (int i = 0; i < listeColonnes.size();i++)
         {
            if(listeColonnes.elementAt(i).getLongueur() < 16)
            {
               affiche += "<th class=\"petitTitreColonne\">";
            }
            else
            {
               affiche += "<th>";
            }
            affiche += listeColonnes.elementAt(i).getNom();
            affiche += "</th>";
         }
         affiche +=             "</tr>"
                 +           "</thead>"
                 +           "<tbody>";

// --------------------------------------------------------------------------
// Lignes
// --------------------------------------------------------------------------
         Contact contact;
         for (int i = 0; i < listeContacts.size(); i++)
         {
            contact = listeContacts.elementAt(i);

            affiche += "<tr>"
                    +     "<td>";
            affiche +=       contact.getNumero();
            affiche +=    "</td>"
                    +     "<td>";

            if (contact.getNom() != null)
               affiche +=   contact.getNom();

            affiche +=    "</td>"
                    +     "<td>";

            if (contact.getAdresse() != null)
               affiche +=   contact.getAdresse();

            affiche +=    "</td>"
                    +     "<td>";

            if (contact.getCodePostal() != null)
               affiche +=   contact.getCodePostal();

            affiche +=    "</td>"
                    +     "<td>";

            if (contact.getVille() != null)
               affiche += contact.getVille();

            affiche +=    "</td>"
                    +     "<td>";

            if (contact.getCodeSecteur() != null)
               affiche += contact.getCodeSecteur();

            affiche +=    "</td>"
                    +  "</tr>";
         }

         affiche +=          "</tbody>"
                 +        "</table>"
                 +        "<p id=\"pListe\">"
                 +           "<a href = \"index.jsp\">"
                 +              "Retour au menu principal"
                 +           "</a>"
                 +        "</p>"
                 +     "</body>"
                 +  "</html>";

         sortie.println(affiche);
      }
      finally
      {
         sortie.close();
      }
   }

   @Override
   protected void doGet(HttpServletRequest requete,
                        HttpServletResponse reponse)
                        throws ServletException,
                        IOException
   {
      executeRequete(requete, reponse);
   }

   @Override
   protected void doPost(HttpServletRequest requete,
                         HttpServletResponse reponse)
                         throws ServletException,
                         IOException
   {
      executeRequete(requete, reponse);
   }
}
