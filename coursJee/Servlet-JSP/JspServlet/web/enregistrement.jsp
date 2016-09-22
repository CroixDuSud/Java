<%-- ------------------------------------------------------------------- --%>
<%-- enregistrement.jsp :                                                --%>
<%-- ------------------------------------------------------------------- --%>
<%-- Affichage des donnes saisies sur formEnregistrement.html            --%>
<%-- Utilisation du JavaBean Utilisateur                                 --%>
<%-- ------------------------------------------------------------------- --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sourcesJspUtilisateur.Utilisateur" %>

<!DOCTYPE html>

<%-- ------------------------------------------------------------------- --%>
<%-- Recuperation de l'objet Utilisateur stocke dans la session          --%>
<%-- ------------------------------------------------------------------- --%>
<% Utilisateur util =
        (Utilisateur)session.getAttribute("util");
%>

<html>
   <head>
      <title>Données enregistrées</title>
      <meta http-equiv="Content-Type"
            content="text/html; charset=utf-8" />
      <link rel="stylesheet"
            type="text/css"
            href="miseEnPage.css" />
   </head>

    <body>
      <div id="texteCentre">
         <h1 class="titre">Données enregistrées pour l'utilisateur</h1>

            
         <p>Voici les données que vous avez fournies :</p>

         <p>Votre prénom est <%= util.getPrenom() %>.</p>
         <p>Votre nom est <%= passeEnMajuscules(util.getNom()) %>.</p>
         <p>Votre login est <%= util.getLogin() %>.</p>
         <p>Votre age est <%= util.getAge() %>.</p>

         <br />
         <br />
         <p>Aller à la <a href="index.jsp">page d'accueil</a></p>
      </div>

      <%@ include file="piedPage.jspf" %>
   </body>
</html>

<%-- ------------------------------------------------------------------- --%>
<%-- Tag de declaration de la methode passeEnMajuscules                  --%>
<%-- ------------------------------------------------------------------- --%>

<%!
    public String passeEnMajuscules(String s)
    {
        return s.toUpperCase();
    }
%>

