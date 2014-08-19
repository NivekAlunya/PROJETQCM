<%@page import="fr.eni_ecole.qcm.model.Test"%>
<%@ page  import ="fr.eni_ecole.qcm.*, java.util.*, java.text.*" %>
<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import ="fr.eni_ecole.qcm.*, java.util.*"
%>
<% ArrayList<Test> tests = (ArrayList<Test>)request.getAttribute("tests");%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"/>
  <title>Liste des tests</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/Theme1.css" type="text/css"/>
</head>
<body>

    <div class="header" >
        <div class="cadre"><h1>Accueil passage d'un test</h1></div>
    </div>
    <div class="fond_selection">
            <div class="barre_session"> 
                <div class="Nom_utilisateur">
                    <!-- include info candidat -->
                </div>
            </div>
            <h2>Sélectionnez le test que vous souhaitez passer :</h2>
            <ul>
            <% for (Test test : tests) {%> 
               <li><a href ="#"><%=test.getNom()%></a></li>
            <%}%>   
            </ul>
    </div>
    <div class="Pied_Page">
            <div class="cadre"><img  width=100%  src="image/pieddepageENI.png" ></div>
    </div>
</body>
</html>