<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title>QCM ENI</title>
<base href="http://localhost:8080/QCM/" />
<link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
<div id="page">
    <div class="header" >
        <div class="cadre"><h1>Gestion des Thèmes</h1></div>
    </div>  
    <div class="fond_selection">
        <div class="barre_session"> 
              <div class="Nom_utilisateur">
                 <!-- include info administrateur -->     
                  <%@ include file="/IdentiteFormateur.jspf" %>
              </div>
        </div>
        <div>
        
        </div>
        
    <form class="connexion" method="post" action="/QCM/AdministrationTheme" enctype="application/x-www-form-urlencoded">
        <div class="bloc_theme">
         <label for="identifiant">Saisie nouveau thème</label>
         </div>
         
        <div>
          <input class="champtheme" type="text" name="theme" />
          
        </div> 
        <div class="barre_2boutons">
            <input type="submit" id="Valider" value="Valider" class="Bouton_Valider" />
            <input type="reset" id="Annuler" value="Annuler" class="Bouton_Annuler"  />
            <a class="text_souligne" href="<%=request.getContextPath()%>/AccueilAdministration.jsp">Retour Accueil</a>
        </div>
    </form>
</div>
</div>
</body>
</html>