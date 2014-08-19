package fr.eni_ecole.qcm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni_ecole.qcm.store.*;
import fr.eni_ecole.qcm.model.*;

/**
 * Servlet implementation class QuestionQCMServlet
 */

public class QuestionQCMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext contexte = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionQCMServlet() {
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
		doInscription(request,response);
		gotoQuestion(request,response);
	}

	private void doInscription(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<QuestionQCM> questions = null;
		Inscription insc = null;
		if(request.getParameter("inscription") != null ) {
			insc = InscriptionStore.rechercher(Integer.valueOf(request.getParameter("inscription")));
			request.getSession().setAttribute("inscription" , insc);
			request.setAttribute("questionqcm", null);
			request.setAttribute("numero", null);
			request.getSession().setAttribute("questions", null);
			request.getSession().setAttribute("questions", QuestionQCMStore.getQCMForInscription(insc));
		}
	}

	private void gotoQuestion(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<QuestionQCM> questions = (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
		int index = 0;
		if (questions != null && !questions.isEmpty()) {
			if (request.getParameter("pnumero") != null) {
				try {
					index = Integer.valueOf(request.getParameter("pnumero"))-1 ;
				} catch(Exception e) {
					index = 0;
				}
				questions = (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
			} else if(request.getParameter("numero") != null) {
				index = Integer.valueOf(request.getParameter("numero")) ;
				if(index == questions.size()) {
					index = 0;
				}
			}
			request.setAttribute("questionqcm", questions.get(index));
			request.setAttribute("numero", index+1);
			RequestDispatcher dispatcher = contexte.getRequestDispatcher("/QuestionQCM.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("numero") != null && request.getParameter("reponse") != null) {
			try {
				Integer index = Integer.valueOf(request.getParameter("numero"))-1; 
				Integer reponse = Integer.valueOf(request.getParameter("reponse"));
				ArrayList<QuestionQCM> questions = (ArrayList<QuestionQCM>)request.getSession().getAttribute("questions");
				QuestionQCM question = questions.get(index);
				for(ReponseQCM rq : question.getReponsesQCM()) {
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		gotoQuestion(request,response);
	}

}
