package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Section implements Serializable
{
	private int numero;
	private int nombreQuestion;
	private Test test;
	private Theme theme;
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNombreQuestion() {
		return nombreQuestion;
	}
	public void setNombreQuestion(int nombreQuestion) {
		this.nombreQuestion = nombreQuestion;
	}
	
	
	
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Theme getTheme() {
		return theme;
	}
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	public Section()
	{
		this(0,0,null,null);
	}
	
	public Section(int numero,int nombreQuestion,Test test,Theme theme)
	{
		super();
		this.numero=numero;
		this.nombreQuestion=nombreQuestion;
		this.test=test;
		this.theme=theme;
	}

}
