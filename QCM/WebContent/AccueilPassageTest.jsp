<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<base href="http://localhost:8080/QCM/"/>
<title>QCM Eni - Passage d'un test</title>
<link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
<div id="page">
    <div class="header" >
        <div class="cadre"><h1>Accueil passage d'un test</h1></div>
    </div>
    <div class="fond_selection">
            <div class="barre_session"> 
                <div class="Nom_utilisateur">
                    <!-- include info candidat -->
                     <%@ include file="/utilisateur.jspf" %>
                </div>
            </div>
            <h2>Sélectionnez le test que vous souhaitez passer :</h2>   
            <ul>
                <li><a href ="static/ConfirmationPassageTest.html">Developper avec VS 2010</a></li>
                <li><a href ="static/ConfirmationPassageTest.html">Manipuler les données avec SQL</a></li> 
            </ul>
    </div>
         <%@ include file="/piedDePage.jspf" %> 
</div>
</body>
</html>