package fr.eni_ecole.qcm.model;

import java.io.Serializable;
import java.util.*;

public class Question implements Serializable{
	/**
	 * Attributs
	 */
	private int idQuestion;
	private String enonce;
	private String urlimage;
	private Theme theme;
	private ArrayList<Reponse> reponses;
	
	/**
	 * Constructors
	 * @param idQuestion
	 * @param enonce
	 * @param urlimage
	 * @param idTheme
	 */
	public Question(){
		this( 0 ,"","",null,null);
	}
	
	public Question(int idQuestion, String enonce, String urlimage,
			Theme theme, ArrayList<Reponse> reponses) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.urlimage = urlimage;
		this.theme = theme;
		this.reponses = reponses == null ? new ArrayList<Reponse>() : reponses;
	}

	public int getIdQuestion() {
		return idQuestion;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}
	
	public String getEnonce() {
		return enonce;
	}
	
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	
	public String getUrlimage() {
		return urlimage;
	}
	
	public void setUrlimage(String urlimage) {
		this.urlimage = urlimage;
	}

	public ArrayList<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(ArrayList<Reponse> reponses) {
		this.reponses = reponses;
	}

}
