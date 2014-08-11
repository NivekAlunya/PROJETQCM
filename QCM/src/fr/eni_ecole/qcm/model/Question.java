package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Question implements Serializable{
	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 1L;
	private int idQuestion;
	private String enonce;
	private String urlimage;
	private int idTheme;
	
	/**
	 * Constructors
	 * @param idQuestion
	 * @param enonce
	 * @param urlimage
	 * @param idTheme
	 */
	public Question(int idQuestion, String enonce, String urlimage, int idTheme) {
		super();
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.urlimage = urlimage;
		this.idTheme = idTheme;
	}
	
	// guetters and setters
	
	public int getIdQuestion() {
		return idQuestion;
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
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	
	

}
