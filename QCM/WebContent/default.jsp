<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="content-type" />
<title>QCM ENI</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/theme/Theme1.css" />
</head>
<body>
    <div id="page">
        <div class="header" >
            <div class="cadre"><h1>QCM ENI</h1></div>
        </div>
        <div class="fond_selection">         
            <a href="<%=request.getContextPath()%>/AdministrateurSignin" type="submit" class="bouton_Choix_Espace" >Espace formateur</a>
            <a href="<%=request.getContextPath()%>/CandidatSignin" type="submit" class="bouton_Choix_Espace" >Espace candidat</a>         
        </div>
        <%@ include file="/piedDePage.jspf" %>
     </div>        
</body>
</html>