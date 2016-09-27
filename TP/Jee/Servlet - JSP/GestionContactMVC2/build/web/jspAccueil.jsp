<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="utilitairesMG.jee.*, gestionContact.UtilitairesXhtml"%>

<%= Xhtml.docType()%>

<% String tabScript[] = new String[2];
   tabScript[0] = "utilitaires.js";
   tabScript[1] = "accueil.js";

   String message = (String)session.getAttribute("message");
   String choixAction = (String)session.getAttribute("choixAction");
   String numeroContact = (String)session.getAttribute("numeroContact");
   boolean checked;
%>

<html>
   <%= Xhtml.head("Gestion des contacts : menu", tabScript) %>

   <body>
      <form action="ServletControleur" method="post">
         <fieldset>
            <legend>Gestion des contacts</legend>
            <div class="divSaisieAccueil">
               <div class="divTexte">
                  <%= Xhtml.labelInputText("Numéro de contact :",
                                           "numero",
                                           "numeroContact",
                                           numeroContact,
                                           8)
                  %>
               </div>
               <div class="divRadio">
                  <% checked = false;
                  if (choixAction.compareTo("modification") == 0)
                     checked = true;
                  %>
                  <%= Xhtml.radioLabel("Modification",
                                       "radio1",
                                       "choixAction",
                                       "modification",
                                       checked)
                  %>
                  <% checked = false;
                  if (choixAction.compareTo("creation") == 0)
                     checked = true;
                  %>
                  <%= Xhtml.radioLabel("Creation",
                                       "radio2",
                                       "choixAction",
                                       "creation",
                                       checked)
                  %>
                  <% checked = false;
                  if (choixAction.compareTo("suppression") == 0)
                     checked = true;
                  %>
                  <%= Xhtml.radioLabel("Suppression",
                                       "radio3",
                                       "choixAction",
                                       "suppression",
                                       checked)
                  %>
                  <br />
                  <br />
                  <br />
                  <br />
                  <% checked = false;
                  if (choixAction.compareTo("liste") == 0)
                     checked = true;
                  %>
                  <%= Xhtml.radioLabel("Liste des contacts",
                                       "radio4",
                                       "choixAction",
                                       "liste",
                                       checked)
                  %>
               </div>
            </div>
         </fieldset>
            
         <div>
            <input type="submit"
                   class="envoyer"
                   value="Envoyer" />
         </div>

         <div>
            <input type="hidden" name="idEcran" value="1"/>
         </div>
      </form>

      <%= UtilitairesXhtml.piedPage(message) %>
   </body>
</html>
