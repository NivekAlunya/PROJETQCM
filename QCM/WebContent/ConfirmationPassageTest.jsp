<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Passage Test</title>
<link rel="stylesheet" type="text/css" href="theme/Theme1.css" />
</head>
<body>
<div>
        <div id="page">
            <div class="fond_confirmation"> 
                <h3> Confirmation </h3>
                <div class="Barre_Confirmation"> 
                    <img class="displayed" width=10%  alt="" src="image/attention.jpg" align=left  >
                    <p>Vous êtes sur le point de commencer le test </p> <br />
                <div><%@ include file="/IdentiteTest.jspf" %></div><br />                        
                </div>
                <div class="barre_boutons_OuiNon"> 
                    <a href="/PassageTest.jsp" class="Bouton_Oui" >Oui</a>
                    <a href="/CandidatInscriptions.jsp" class="Bouton_Non" >Non</a>
                </div> 
            </div>
        </div>
    </div>   
</body>
</html>