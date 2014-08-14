package fr.eni_ecole.qcm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.qcm.model.Administrateur;
import fr.eni_ecole.qcm.store.AdministrateurStore;

/**
 * Servlet implementation class ValiderAuthentification
 */
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext contexte = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException
    {
    	contexte = config.getServletContext();

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		if (request.getRequestURI().equals(request.getContextPath() + "/AuthentifierAdministrateur"))
		{
    		Administrateur administrateur = AdministrateurStore.getAdministrateur(request.getParameter("identifiant"), request.getParameter("motdepasse"));
    		if(administrateur != null ){
    			request.getSession().setAttribute("administrateur", administrateur);
    			// OK rediriger vers le menu accueil administration
    			RequestDispatcher dispatcher = contexte.getRequestDispatcher("/static/AccueilAdministration.html");
    			dispatcher.forward(request, response);
    		}
    		else {
    			System.out.println("Authentification a echoué!");
    			RequestDispatcher dispatcher = contexte.getRequestDispatcher("/static/Authentification.html");
    			dispatcher.forward(request, response);
    		}
		}
    	
    }

}
