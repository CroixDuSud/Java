<%--
    Document   : jspAccueil
    Created on : 22 sept. 2016, 14:39:00
    Author     : afpa1800
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" lang="fr">
<title>Gestion des Contacts</title>
<link href="style.css" type="text/css" rel="stylesheet"> 
</head>
<body>
<div>
<form action="ServletAccueil" method="post">
<fieldset id="field">
    <legend>Gestion des contacts</legend>
    <div id="numC">
    <label for="numeroContact">Numero de contact :</label>
    <input type="text" name="numeroContact" id="numContact">
    </div>
    <div id="radioG">
    <div id="radio">
        <input type="radio" name="choixAction" value="modification">Modification
        <input type="radio" name="choixAction" value="creation">Creation
        <input type="radio" name="choixAction" value="suppression">Suppression
    </div>
    <div>
        <input type="radio" name="choixAction" value="liste" id="liste">Liste des contacts
        </div>
    </div>
</fieldset>
<br>
<input type="submit" id="send" value="Envoyer">
</form>
</div>
<br>
<br>
<br>
<br>
<div id="footer">
    <p></p>
</div>
</body>
</html>
