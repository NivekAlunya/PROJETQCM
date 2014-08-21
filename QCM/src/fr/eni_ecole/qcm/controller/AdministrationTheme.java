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
import fr.eni_ecole.qcm.model.Theme;
import fr.eni_ecole.qcm.store.AdministrateurStore;
import fr.eni_ecole.qcm.store.ThemeStore;

/**
 * Servlet implementation class AdministrationTheme
 */
public class AdministrationTheme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext contexte = null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministrationTheme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		contexte = config.getServletContext();
		System.out.println("access servlet theme");
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
		
		//if (request.getRequestURI().equals(request.getContextPath() + "/AdministrationTheme"))
		{
			
    		Theme theme;
			try 
			{
				theme = ThemeStore.rechercherTheme(request.getParameter("theme"));
				
    		if (theme != null )
    		{
    			System.out.println( "/theme existant");
    			request.getSession().setAttribute("theme", theme);
    			// OK 
    		}
    		else 
    		{
    		System.out.println("creation en cours!");
 	    	ThemeStore.ajouter(new Theme(0,request.getParameter("theme")));
    		   			
    		}
    		RequestDispatcher dispatcher = contexte.getRequestDispatcher("/AdministrationTheme.jsp");
			dispatcher.forward(request, response);
		    }
    		
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
