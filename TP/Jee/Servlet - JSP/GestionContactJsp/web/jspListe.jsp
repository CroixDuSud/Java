<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="utilitairesMG.jee.*, gestionContact.UtilitairesXhtml"%>
<%@page import="java.util.Vector, utilitairesMG.divers.*, metierMapping.*" %>

<%= Xhtml.docType()%>

<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs ajoutes dans la requete dans ServletListe                  --%>
<%-- ------------------------------------------------------------------- --%>
<%
   Vector<Contact> listeContacts =
      (Vector)session.getAttribute("listeContacts");
   Vector<Colonne> listeColonnes =
      (Vector)session.getAttribute("listeColonnes");
   Contact contact;
%>


<html>
   <%= Xhtml.head("Liste des contacts")%>

   <body>
      <table>
         <caption>LISTE DES CONTACTS</caption>
         <thead>
            <tr>
               <%
                  for (int i = 0; i < listeColonnes.size();i++)
                  {
                     if(listeColonnes.elementAt(i).getLongueur() < 16)
                     {
               %>
               <th class="petitTitreColonne">
               <%
                     }
                     else
                     {
               %>
               <th>
               <%
                     }
               %>
                  <%=listeColonnes.elementAt(i).getNom()%>
               </th>
               <%
                  }
               %>
            </tr>
         </thead>

         <tbody>
            <%
                for (int i = 0; i < listeContacts.size(); i++)
                {
                    contact = listeContacts.elementAt(i);
            %>
            <tr>
               <td>
                  <%= contact.getNumero()%>
               </td>
               
               <td>
                  <% if(contact.getNom() != null) { %>
                     <%= contact.getNom()%>
                  <% } %>
               </td>

               <td>
                  <% if(contact.getAdresse() != null) { %>
                     <%= contact.getAdresse()%>
                  <% } %>
               </td>

               <td>
                  <% if(contact.getCodePostal() != null) { %>
                     <%= contact.getCodePostal()%>
                  <% } %>
               </td>

               <td>
                  <% if(contact.getVille() != null) { %>
                     <%= contact.getVille()%>
                  <% } %>
               </td>

               <td>
                  <% if(contact.getCodeSecteur() != null) { %>
                     <%= contact.getCodeSecteur()%>
                  <% } %>
               </td>
            </tr>
            <%
                }
            %>
         </tbody>
      </table>

      <p id="pListe">
         <a href="index.jsp">Retour au menu principal</a>
      </p>
   </body>
</html>