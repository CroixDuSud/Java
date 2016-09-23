// ==========================================================================
// Classe ServletAffichageAccueil                Projet gestionContactServlet
// ==========================================================================

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import utilitairesMG.jee.*;

public class ServletAffichageAccueil extends HttpServlet
{

    protected void executeRequete(HttpServletRequest requete,
            HttpServletResponse reponse)
            throws ServletException,
            IOException
    {
        String affiche;
        String tabScript[];

        String message;
        String choixAction;
        String numeroContact;
        boolean checked;

// --------------------------------------------------------------------------
// Les servlets d'affichage ne reçoivent rien de la requete. Il est inutile
// de preciser l'encodage des caracteres de la requete :
// requete.setCharacterEncoding("UTF-8");
// --------------------------------------------------------------------------
// On precise par contre le type des caracteres envoyes.
// --------------------------------------------------------------------------
        reponse.setContentType("text/html;charset=UTF-8");

        PrintWriter sortie = reponse.getWriter();

        try
        {
            HttpSession session = requete.getSession();

            message = (String) session.getAttribute("message");
            choixAction = (String) session.getAttribute("choixAction");
            numeroContact = (String) session.getAttribute("numeroContact");

// --------------------------------------------------------------------------
// Doctype
// --------------------------------------------------------------------------
            affiche = Xhtml.docType();
            affiche
                    += "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"fr\">";

// --------------------------------------------------------------------------
// Entete du fichier html
// --------------------------------------------------------------------------
            tabScript = new String[2];
            tabScript[0] = "utilitaires.js";
            tabScript[1] = "accueil.js";

            affiche += Xhtml.head("Gestion des contacts : menu", tabScript);

// --------------------------------------------------------------------------
// Corps du fichier html
// --------------------------------------------------------------------------
            affiche += "<body>";
            affiche += "<form action=\"ServletAccueil\" method=\"post\">";
            affiche += "<fieldset>";
            affiche += "<legend>Gestion des contacts";
            affiche += "</legend>";

// --------------------------------------------------------------------------
// Zone nom
// --------------------------------------------------------------------------
            affiche += "<div class=\"divSaisieAccueil\">";
            affiche += "<div class=\"divTexte\">";
            affiche += Xhtml.labelInputText("Numéro de contact :",
                    "numero",
                    "numeroContact",
                    numeroContact,
                    8);
            affiche += "</div>";

// --------------------------------------------------------------------------
// Zone des boutons radio
// --------------------------------------------------------------------------
            affiche += "<div class=\"divRadio\">";
            checked = false;
            if (choixAction.compareTo("modification") == 0)
            {
                checked = true;
            }
            affiche += Xhtml.radioLabel("Modification",
                    "radio1",
                    "choixAction",
                    "modification",
                    checked);

            checked = false;
            if (choixAction.compareTo("creation") == 0)
            {
                checked = true;
            }
            affiche += Xhtml.radioLabel("Creation",
                    "radio2",
                    "choixAction",
                    "creation",
                    checked);

            checked = false;
            if (choixAction.compareTo("suppression") == 0)
            {
                checked = true;
            }
            affiche += Xhtml.radioLabel("Suppression",
                    "radio3",
                    "choixAction",
                    "suppression",
                    checked);

            affiche += "<br />";
            affiche += "<br />";
            affiche += "<br />";
            affiche += "<br />";

            checked = false;
            if (choixAction.compareTo("liste") == 0)
            {
                checked = true;
            }
            affiche += Xhtml.radioLabel("Liste des contacts",
                    "radio4",
                    "choixAction",
                    "liste",
                    checked);

            affiche += "</div>";

            affiche += "</div>";

            affiche += "</fieldset>";

            affiche += "<div>";
            affiche += "<input type=\"submit\" ";
            affiche += "class=\"envoyer\" ";
            affiche += "value=\"Envoyer\" />";
            affiche += "</div>";
            affiche += "</form>";
            affiche += UtilitairesXhtml.piedPage(message);
            affiche += "</body>";
            affiche += "</html>";

            sortie.println(affiche);
        } finally
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
