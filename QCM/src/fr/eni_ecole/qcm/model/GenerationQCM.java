package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class GenerationQCM implements Serializable{
	
	private int idGenerationQCM;
	private String marque;
	private Inscription inscription;
	private Theme theme;
	private Test test;
	private Question question;
	
	public GenerationQCM() {
		this(0,"",null,null,null,null);
	}
	public GenerationQCM(int idGenerationQCM, String marque,
			Inscription inscription, Theme theme, Test test, Question question) {
		super();
		this.idGenerationQCM = idGenerationQCM;
		this.marque = marque;
		this.inscription = inscription;
		this.theme = theme;
		this.test = test;
		this.question = question;
	}
	public int getIdGenerationQCM() {
		return idGenerationQCM;
	}
	public void setIdGenerationQCM(int idGenerationQCM) {
		this.idGenerationQCM = idGenerationQCM;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public Inscription getInscription() {
		return inscription;
	}
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

}
