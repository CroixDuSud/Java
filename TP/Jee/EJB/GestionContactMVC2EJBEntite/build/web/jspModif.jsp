<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="utilitairesMG.jee.*, gestionContact.UtilitairesXhtml"%>
<%@page import="tables.*, java.util.*" %>

<%= Xhtml.docType()%>

<% Contact contact = (Contact)session.getAttribute("contact");
   Vector<Secteur> vSect = (Vector<Secteur>)session.getAttribute("vSect");
   String message = (String)session.getAttribute("message");
   String valueInput;
   Vector<Integer> vCodeSecteur;
%>
        
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
   <%= Xhtml.head("Modification d'un contact") %>

   <body>
      <form action="ServletControleur" method="post">
        <fieldset>
            <legend>
               Modification du contact <%= contact.getNumero()%>
            </legend>

            <div class="divSaisieModif">
               <% valueInput ="";
                  if (contact.getNom() != null)
                  {
                     valueInput = contact.getNom();
                  }
               %>
               <%= Xhtml.labelInputText("Nom :",
                                        "nom",
                                        "nom",
                                        valueInput,
                                        20)
               %>
            </div>

            <div class="divSaisieModif">
               <% valueInput ="";
                  if (contact.getAdresse() != null)
                  {
                     valueInput = contact.getAdresse();
                  }
               %>
               <%= Xhtml.labelInputText("Adresse :",
                                        "adresse",
                                        "adresse",
                                        valueInput,
                                        50)
               %>
            </div>

            <div class="divSaisieModif">
               <% valueInput ="";
                  if (contact.getCodePostal() != null)
                  {
                     valueInput = contact.getCodePostal();
                  }
               %>
               <%= Xhtml.labelInputText("Code Postal :",
                                        "codePostal",
                                        "codePostal",
                                        valueInput,
                                        5)
               %>
            </div>

            <div class="divSaisieModif">
               <% valueInput ="";
                  if (contact.getVille() != null)
                  {
                     valueInput = contact.getVille();
                  }
               %>
               <%= Xhtml.labelInputText("Ville :",
                                        "ville",
                                        "ville",
                                        valueInput,
                                        20)
               %>
            </div>

            <div class="divSaisieModif">
               <% vCodeSecteur = new Vector<Integer>();
                  for (int i = 0; i < vSect.size(); i++)
                  {
                     vCodeSecteur.addElement(vSect.elementAt(i).getCode());
                  }
                  Integer codeSecteur = null;
                  if (contact.getCodeSecteur() != null)
                  {
                     codeSecteur = contact.getCodeSecteur().getCode();
                  }
               %>

               <%= Xhtml.labelSelect("Code secteur :",
                                     "codeSecteur",
                                     "codeSecteur",
                                     codeSecteur,
                                     vCodeSecteur)
               %>
            </div>
         </fieldset>

         <div>
            <input type="submit" 
                   class="envoyer" 
                   name="choixAction" 
                   value="Enregistrer"/>
            <input type="submit" 
                   class="envoyer" 
                   name="choixAction" 
                   value="Annuler"/>
         </div>

          <div>
            <input type="hidden" name="idEcran" value="2"/>
         </div>
      </form>

      <%= UtilitairesXhtml.piedPage(message) %>

   </body>
</html>
