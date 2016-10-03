<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<% session.setAttribute("message", ""); %>
<% session.setAttribute("choixAction", "liste"); %>
<% session.setAttribute("numeroContact", ""); %>

<jsp:forward page="/jspAccueil.jsp" />
