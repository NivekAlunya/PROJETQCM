<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type"/>
    <title>QCM - ENI Accueil administration</title>
    <base href="http://localhost:8080/QCM/"/>
    <link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
<div id="page">
    <div class="header" >
        <div class="cadre"><h1>Accueil administration</h1></div>
    </div>  
    <div class="fond_selection">
         <div class="barre_session"> 
         <!-- affichage des infos administrateur  -->
              <%@ include file="/IdentiteFormateur.jspf" %>
         </div>
            <div class="barre_menu">  
                <a href="default.jsp" type="submit" class="Bouton_Accueil" >Accueil</a>
                <a href="static/AccesQuestion" type="submit" class="Bouton_Question" >Question</a>
                <a href="AdministrationTheme.jsp" type="submit" class="Bouton_Theme" >Theme</a>
                <a href="static/AccesTest" type="submit" class="Bouton_Test" >Test</a>
                <a href="static/AccesInscription" type="submit" class="Bouton_Inscription" >Inscription</a>       
                <br />
                <br />
            </div>              
    </div>
    <%@ include file="/piedDePage.jspf" %>
</div>
</body>
</html>