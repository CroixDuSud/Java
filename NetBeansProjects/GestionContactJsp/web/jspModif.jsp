<%-- 
    Document   : jspModif
    Created on : 22 sept. 2016, 14:43:51
    Author     : afpa1800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" lang="fr">
<title>Modification du Contact</title>
<link href="styleModif.css" rel="stylesheet"> 
</head>
<body id="home">
<div>
<form action="ServletEnregModif" method="post">
    <fieldset id="field">
        <legend>Modification du contact</legend>
        <br>
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom">
        <br>
        <br>
        <label for="adresse">Adresse :</label>
        <input type="text" name="adresse" id="adresse">
        <br>
        <br>
        <label for="codePostal">Code postal :</label>
        <input type="text" name="codePostal" id="codePostal">
        <br>
        <br>
        <label for="ville">Ville :</label>
        <input type="text" name="ville" id="ville">
        <br>
        <br>
        <label for="secteur">Code secteur :</label>
        <select name="secteur" id="secteur"></select>
        <br>         
        <br>
    </fieldset>
    <br>
    <div id="boutons">
    <input type="submit" id="send" value="Enregistrer">
    <input type="button" id="annuler" value="Annuler">
        </div>
</form>
</div>
    <br>
    <br>
    <br>
    <br>
    <iframe src="boiteDialogue.html">   
    </iframe>
</body>
</html>