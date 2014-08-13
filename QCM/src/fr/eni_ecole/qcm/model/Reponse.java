package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Reponse implements Serializable{
	
	
	private int idReponse;
	private String proposition;
	private char correcte;
	private Question question;
	
	public Reponse (){
		this(0,"",'-',null);
	}
	
	public Reponse(int idReponse, String proposition, char correcte,Question question) {
		
		super();
		this.idReponse = idReponse;
		this.proposition = proposition;
		this.correcte = correcte;
		this.question = question;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
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

}
