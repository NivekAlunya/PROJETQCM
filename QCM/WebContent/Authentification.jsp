<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QCM ENI</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/Theme1.css" />
</head>
<body>
    <div id="page">
    
        <div class="header" >
            <div class="cadre"><h1>Authentification</h1></div>
        </div>
       <%
        String action = request.getContextPath() + (request.getRequestURI().equals(request.getContextPath() + "/AdministrateurSignin") ? "/AuthentifierAdministrateur" : "/AuthentifierCandidat");
       %>
        <div class="fond_selection"> 
             
           <form  class="connexion" method="post" action="<%=action %>" enctype="application/x-www-form-urlencoded">
               <div align="center">
                <div class="bloc_identifiant">
                    <label for="identifiant">Login</label>
                    <input class="champtexte" type="text" id="identifiant" name="identifiant"/>
                </div>
                <br>
                <div class="bloc_motdepasse">
                    <label for="motdepasse">Mot de passe</label>
                    <input name="motdepasse" size="20" type="password" id="motdepasse" required="required"/>
                </div>
                
	            <div class="barre_3boutons">
	                <input type="submit" id="Valider" value="Valider" class="Bouton_Valider" />
	                <input type="reset" id="Annuler" value="Annuler" class="Bouton_Annuler" />
	                <a href="default.jsp" type="submit" class="Bouton_Accueil" >Accueil</a>
	            </div> 
	            </div>                          
            </form>
        </div>
        <%@ include file="/piedDePage.jspf" %> 
    </div>
</body>






</html>