
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modification</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="script.js"></script>
    </head>
    <body>
        <form action="ServletControleur" onsubmit="return checkWholeNumber()" method="post">
            <input type="hidden" name="page" value="accueil">
            <fieldset>
                <legend>Gestion des contacts</legend>
                <div id="numero"><label for="numContact">Numero de contact : </label><input type=\"text\" name="numContact" id="numContact" value="<%=((session.getAttribute("numContact")==null)? "" : session.getAttribute("numContact") )%>"></div>
                <div id="boutons"><div id="choix"><input type="radio" name="action" value="modif" id="modif" <% if(session.getAttribute("action").equals("modif")){%> checked <%;}%>><label for="modif">Modification</label>
                <input type="radio" name="action" value="creat" id="creat" <% if(session.getAttribute("action").equals("creat")){%> checked <%;}%>><label for="creat">Création</label>
                <input type="radio" name="action" value="suppr" id="suppr" <% if(session.getAttribute("action").equals("suppr")){%> checked <%;}%>><label for="suppr">Suppression</label></div>
                <div><input type="radio" name="action" value="list" id="list" <% if(session.getAttribute("action").equals("list")){%> checked <%;}%>><label for="list">Liste des contacts</label></div></div>
            </fieldset>
            <div id="submit">
                <input type="submit" value="ENVOYER">
            </div>
        </form>
        <footer><p><%=session.getAttribute("message")%></p></footer>
    </body>
</html>
