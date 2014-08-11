package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Section implements Serializable
{
	private int numero;
	private int nombreQuestion;
	private Test idTest;
	private Theme idTheme;
	
	
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
	public Test getIdTest() {
		return idTest;
	}
	public void setIdTest(Test idTest) {
		this.idTest = idTest;
	}
	public Theme getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(Theme idTheme) {
		this.idTheme = idTheme;
	}
	
	
	public Section()
	{
		this(0,0,null,null);
	}
	
	public Section(int numero,int nombreQuestion,Test idtest,Theme idTheme)
	{
		super();
		this.numero=numero;
		this.nombreQuestion=nombreQuestion;
		this.idTest=idtest;
		this.idTheme=idTheme;
	}
	
	
	
}
