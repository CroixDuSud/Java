<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% session.setAttribute("message", ""); %>
<% session.setAttribute("choixAction", "liste"); %>
<% session.setAttribute("numeroContact", ""); %>

<jsp:forward page="/ServletAffichageAccueil" />