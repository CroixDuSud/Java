<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
   <head>
      <title>Accueil - JspUtilisateur2</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

   <body>
      <div id="texteCentre">
         <h1 class="titre">Application Utilisateur - JspUtilisateur2</h1>

<%-- -------------------------------------------------------------------- --%>
<%-- <% : tag de scripting : scriptlet                                    --%>
<%-- -------------------------------------------------------------------- --%>
         <%
             for (int i = 1; i < 5; i++)
             {
         %>
<%-- -------------------------------------------------------------------- --%>
<%-- <%= tag d'expression : renvoie une valeur (methode ou variable java) --%>
<%-- -------------------------------------------------------------------- --%>
               <h<%=i%>>FUMIER INFECT !</h<%=i%>>
         <%
             }
         %>

         <br />
         <br />

         <p><a href="formEnregistrement.jsp">Enregistrement Utilisateur</a></p>
         <p><a href="afficheListe.jsp">Liste des Utilisateurs</a></p>
      </div>

<%-- -------------------------------------------------------------------- --%>
<%-- <%@ : tag de directive qui permet d'inclure ici le fichier           --%>
<%--       piedPage.jspf                                                  --%>
<%-- -------------------------------------------------------------------- --%>
        <%@ include file="piedPage.jspf" %>
    </body>
</html>
