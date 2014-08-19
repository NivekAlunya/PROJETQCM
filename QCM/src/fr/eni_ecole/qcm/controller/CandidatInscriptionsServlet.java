package fr.eni_ecole.qcm.controller;



import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.qcm.model.Test;

import fr.eni_ecole.qcm.store.TestStore;

/**
 * Servlet implementation class ListerTests
 */
public class CandidatInscriptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServletContext contexte = null ;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatInscriptionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		contexte = config.getServletContext();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		System.out.println("processRequest " + response + " " + request);
	
		ArrayList<Test> listeTest = new ArrayList<Test>();
		// Construire la liste des tests et la placer en session
		try {
			listeTest = TestStore.listeTest();
			System.out.println(listeTest);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		request.setAttribute("tests", listeTest);			
		RequestDispatcher dispatcher= null;
		dispatcher = request.getRequestDispatcher("/CandidatInscriptions.jsp"); 
		dispatcher.forward(request, response);
		
	}
		
protected void redirectionErreur(Exception e, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Placer l'objet repr�sentant l'exception dans le contexte de requete
	
		request.setAttribute("erreur", e);
		// Passer la main � la page de pr�sentation des erreurs
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/Erreur.jsp"); 
		dispatcher.forward(request, response);

	}
}	



		