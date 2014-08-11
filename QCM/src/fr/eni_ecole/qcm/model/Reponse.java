package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Reponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReponse;
	private String proposition;
	private char correcte;
	private int idQuestion;
	
	/**
	 * Constructors
	 * @param idReponse
	 * @param proposition
	 * @param correcte
	 * @param idQuestion
	 */
	public Reponse(int idReponse, String proposition, char correcte,
			int idQuestion) {
		super();
		this.idReponse = idReponse;
		this.proposition = proposition;
		this.correcte = correcte;
		this.idQuestion = idQuestion;
	}
	
	
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
	public int getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	
	

}
