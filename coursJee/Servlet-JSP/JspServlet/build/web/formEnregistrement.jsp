<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sourcesJspUtilisateur.Utilisateur" %>

<!DOCTYPE html>

<%-- -------------------------------------------------------------------- --%>
<%-- Recuperation de l'objet Utilisateur dans la session (s'il y est).    --%>
<%-- -------------------------------------------------------------------- --%>
<%
   Utilisateur util = (Utilisateur)session.getAttribute("util");
%>

<html>
   <head>
      <title>Formulaire - JspServlet</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

   <body>
      <h1>Formulaire - JspServlet</h1>

      <form action="ServletEnregistrement" method="post">
         <%  if (util == null) { %>
         <div class="divSaisieForm">
            <label for="prenom">Prénom</label>
            <input type="text"
                   name="prenom"
                   size="30"
                   maxlength="30"
                   id="prenom" />
         </div>

          <div class="divSaisieForm">
           <label for="nom">Nom</label>
            <input type="text"
                   name="nom"
                   size="30"
                   maxlength="30"
                   id="nom" />
         </div>

         <div class="divSaisieForm">
            <label for="login">Nom d'utilisateur</label>
            <input type="text"
                   name="login"
                   size="30"
                   maxlength="30"
                   id="login" />
         </div>

         <div class="divSaisieForm">
            <label for="age">Age</label>
            <input type="text"
                   name="age"
                   size="30"
                   maxlength="30"
                   id="age" />
         </div>
         <%  } else { %>
         <div class="divSaisieForm">
            <label for="prenom">Prénom</label>
            <input type="text"
                   name="prenom"
                   size="30"
                   maxlength="30"
                   value="<%=util.getPrenom()%>"
                   id="prenom" />
         </div>

         <div class="divSaisieForm">
            <label for="nom">Nom</label>
            <input type="text"
                   name="nom"
                   size="30"
                   maxlength="30"
                   value="<%=util.getNom()%>"
                   id="nom" />
         </div>

         <div class="divSaisieForm">
            <label for="login">Nom d'utilisateur</label>
            <input type="text"
                   name="login"
                   size="30"
                   maxlength="30"
                   value="<%=util.getLogin()%>"
                   id="login" />
         </div>

         <div class="divSaisieForm">
            <label for="age">Age</label>
            <input type="text"
                   name="age"
                   size="30"
                   maxlength="30"
                   value="<%=util.getAge()%>"
                   id="age" />
         </div>
         <%  } %>

<%-- -------------------------------------------------------------------- --%>
<%-- Bouton d'enregistrement                                              --%>
<%-- -------------------------------------------------------------------- --%>
         <div>
            <input type="submit"
                   value="Enregistrer"/>
         </div>
      </form>

      <%@ include file="piedPage.jspf" %>
   </body>
</html>
