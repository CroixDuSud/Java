<%-- ------------------------------------------------------------------- --%>
<%-- enregistrement.jsp :                                                --%>
<%-- ------------------------------------------------------------------- --%>
<%-- Affichage des donnes saisies sur formEnregistrement.html            --%>
<%-- Utilisation du JavaBean Utilisateur                                 --%>
<%-- ------------------------------------------------------------------- --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="pageErreur.jsp"%>
<%@page import="sourcesJspUtilisateur.Utilisateur" %>


<%
    request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>

<%-- ------------------------------------------------------------------- --%>
<%-- L'instruction useBean instancie un objet de type Utilisateur        --%>
<%-- Cet objet persiste pendant toute la session grace a l'option du     --%>
<%-- parametre scope. A chaque passage dans ce programme, c'est la       --%>
<%-- meme instance qui est utilisee. En fait, l'instanciation ne         --%>
<%-- se fait qu'au premier passage (si l'objet n'existe pas).            --%>
<%-- ------------------------------------------------------------------- --%>
<%-- Si on met l'option scope a la valeur "page", l'objet disparait      --%>
<%-- avec la page... On ne le retouve plus dans index.jsp...             --%>
<%-- Il est recree a chaque passage (instances differentes).             --%>
<%-- ------------------------------------------------------------------- --%>
<jsp:useBean id="util"
             scope="session"
             class="sourcesJspUtilisateur.Utilisateur">
</jsp:useBean>

<%-- ------------------------------------------------------------------- --%>
<%-- Attention : en cas de valeur null (Champ non renseigné)             --%>
<%-- les proprietes du bean sont inchangees.                             --%>
<%-- On peut resoudre le probleme en initialisant les                    --%>
<%-- proprietes par :                                                    --%>
<%--    <jsp:setProperty name="util" property="nom" value="" />          --%>
<%-- ------------------------------------------------------------------- --%>
<jsp:setProperty name="util" property="prenom" value="" />
<jsp:setProperty name="util" property="nom" value="" />
<jsp:setProperty name="util" property="login" value="" />
<jsp:setProperty name="util" property="age" value="0" />

<jsp:setProperty name="util" property="*" />



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

<%-- ------------------------------------------------------------------- --%>
<%-- Deux possibilites pour l'affichage des proprietes                   --%>
<%-- ------------------------------------------------------------------- --%>
         <p>Votre prénom est <%= util.getPrenom() %>.</p>
         <p>Votre nom est <%= passeEnMajuscules(util.getNom()) %>.</p>
         <p>Votre login est <%= util.getLogin() %>.</p>
         <p>Votre age est <%= util.getAge() %>.</p>

<%-- ------------------------------------------------------------------- --%>
<%-- Ou...                                                               --%>
<%-- ------------------------------------------------------------------- --%>
<%--
         <p>Votre prenom est
            <jsp:getProperty name="util" property="prenom" />.
         </p>
         <p>Votre nom est
            <jsp:getProperty name="util" property="nom" />.
         </p>
         <p>Votre login est
            <jsp:getProperty name="util" property="login" />.
         </p>
         <p>Vous avez
            <jsp:getProperty name="util" property="age" /> ans.
         </p>         <p>Votre prénom est <%= request.getParameter("prenom") %>.</p>
         <p>Votre nom est <%= passeEnMajuscules(request.getParameter("nom")) %>.</p>
         <p>Votre login est <%= request.getParameter("login") %>.</p>
         <p>Votre age est <%= request.getParameter("age") %>.</p>
--%>

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



