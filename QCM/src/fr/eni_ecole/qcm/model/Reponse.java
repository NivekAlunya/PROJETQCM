package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Reponse implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int idReponse;
	private String proposition;
	private char correcte;
	private Question idQuestion;
	
	
	/**
	 * 
	 * @param idReponse
	 * @param proposition
	 * @param correcte
	 * @param idQuestion
	 */
	
	public Reponse(int idReponse, String proposition, char correcte,
			Question idQuestion) {
		super();
		this.idReponse = idReponse;
		this.proposition = proposition;
		this.correcte = correcte;
		this.idQuestion = idQuestion;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIdReponse() {
		return idReponse;
	}
	public void setIdReponse(int idReponse) {
		this.idReponse = idReponse;
	}
	public String getProposition() {
		return proposition;
	}
	public void setProposition(String proposition) {
		this.proposition = proposition;
	}
	public char getCorrecte() {
		return correcte;
	}
	public void setCorrecte(char correcte) {
		this.correcte = correcte;
	}
	public Question getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(Question idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
	
	
	

}
