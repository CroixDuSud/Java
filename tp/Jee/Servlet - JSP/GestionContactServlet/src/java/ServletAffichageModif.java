// ==========================================================================
// Classe ServletAffichageModif                  Projet gestionContactServlet
// ==========================================================================

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import metierMapping.*;
import utilitairesMG.jee.*;

public class ServletAffichageModif extends HttpServlet
{
   protected void executeRequete(HttpServletRequest requete,
               HttpServletResponse reponse)
               throws ServletException,
                      IOException
   {
      String affiche;
      String valueInput;

      Contact contact;
      Vector<Secteur> vSect;
      Vector<Integer> vCodeSecteur;
      String message;

      PrintWriter sortie = reponse.getWriter();

      HttpSession session = requete.getSession();

      try
      {
         contact = (Contact)session.getAttribute("contact");
         vSect = (Vector<Secteur>)session.getAttribute("vSect");
         message = (String)session.getAttribute("message");

// --------------------------------------------------------------------------
// Doctype
// --------------------------------------------------------------------------
         affiche = Xhtml.docType();
         affiche +=
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\">";

// --------------------------------------------------------------------------
// Entete du fichier html
// --------------------------------------------------------------------------
         affiche += Xhtml.head("Modification");

// --------------------------------------------------------------------------
// Corps du fichier html
// --------------------------------------------------------------------------
         affiche +=     "<body>";
         affiche +=        "<form action=\"ServletEnregModif\" method=\"post\">";
         affiche +=           "<fieldset>";
         affiche +=              "<legend>Modification du contact " +
                                          contact.getNumero();
         affiche +=              "</legend>";

// --------------------------------------------------------------------------
// Zone nom
// --------------------------------------------------------------------------
         affiche += "<div class=\"divSaisieModif\">";
            valueInput = "";
            if (contact.getNom()!= null)
            {
               valueInput = contact.getNom();
            }
            affiche += Xhtml.labelInputText("Nom :",
                                            "nom",
                                            "nom",
                                            valueInput,
                                            20);
         affiche += "</div>";

// --------------------------------------------------------------------------
// Zone adresse
// --------------------------------------------------------------------------
         affiche += "<div class=\"divSaisieModif\">";
            valueInput = "";
            if (contact.getAdresse()!= null)
            {
               valueInput = contact.getAdresse();
            }
            affiche += Xhtml.labelInputText("Adresse :",
                                            "adresse",
                                            "adresse",
                                            valueInput,
                                            50);
         affiche += "</div>";

// --------------------------------------------------------------------------
// Zone codePostal
// --------------------------------------------------------------------------
         affiche += "<div class=\"divSaisieModif\">";
            valueInput = "";
            if (contact.getCodePostal()!= null)
            {
               valueInput = contact.getCodePostal();
            }
            affiche += Xhtml.labelInputText("Code postal :",
                                            "codePostal",
                                            "codePostal",
                                            valueInput,
                                            5);
         affiche += "</div>";

// --------------------------------------------------------------------------
// Zone ville
// --------------------------------------------------------------------------
         affiche += "<div class=\"divSaisieModif\">";
            valueInput = "";
            if (contact.getVille()!= null)
            {
               valueInput = contact.getVille();
            }
            affiche += Xhtml.labelInputText("Ville :",
                                            "ville",
                                            "ville",
                                            valueInput,
                                            20);
         affiche += "</div>";

// --------------------------------------------------------------------------
// Zone codeSecteur
// --------------------------------------------------------------------------
         affiche +=              "<div class=\"divSaisieModif\">";
            vCodeSecteur = new Vector<Integer>();
            for(int i = 0; i < vSect.size(); i++)
            {
               vCodeSecteur.addElement(vSect.elementAt(i).getCode());
            }
            affiche += Xhtml.labelSelect("Code secteur :",
                                         "codeSecteur",
                                         "codeSecteur",
                                         contact.getCodeSecteur(),
                                         vCodeSecteur);
         affiche +=       "</div>";

         affiche +=    "</fieldset>";

         affiche +=           "<div>";
         affiche +=              "<input type=\"submit\" ";
         affiche +=                     "class=\"envoyer\" ";
         affiche +=                     "name=\"choixAction\" ";
         affiche +=                     "value=\"Enregistrer\" />";
         affiche +=              "<input type=\"submit\" ";
         affiche +=                     "class=\"envoyer\" ";
         affiche +=                     "name=\"choixAction\" ";
         affiche +=                     "value=\"Annuler\" />";
         affiche +=           "</div>";
         affiche +=       "</form>";
         affiche +=       UtilitairesXhtml.piedPage(message);
         affiche +=    "</body>";
         affiche += "</html>";

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
