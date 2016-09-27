<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="utilitairesMG.jee.*, gestionContact.UtilitairesXhtml"%>
<%@page import="metierMapping.*, java.util.*" %>

<%= Xhtml.docType()%>

<% Contact contact = (Contact)session.getAttribute("contact");
   Vector<Secteur> vSect = (Vector<Secteur>)session.getAttribute("vSect");
   String message = (String)session.getAttribute("message");
   String valueInput;
   Vector<Integer> vCodeSecteur;
%>
        
<html>
   <%= Xhtml.head("Modification d'un contact") %>

   <body>
      <form action="ServletEnregModif" method="post">
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
               %>
               <%= Xhtml.labelSelect("Code secteur :",
                                        "codeSecteur",
                                        "codeSecteur",
                                        contact.getCodeSecteur(),
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
      </form>

      <%= UtilitairesXhtml.piedPage(message) %>

   </body>
</html>
