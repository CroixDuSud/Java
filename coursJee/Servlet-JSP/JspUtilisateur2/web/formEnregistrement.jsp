<%-- 
    Document   : formEnregistrement
    Created on : 17 févr. 2016, 11:02:18
    Author     : gnmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
   <head>
      <title>Formulaire - JspUtilisateur2</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

   <body>
      <h1>Formulaire - JspUtilisateur2</h1>

      <form action="ServletEnregistrement" method="post">
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
