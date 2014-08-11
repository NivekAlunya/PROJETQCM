package fr.eni_ecole.qcm.model;

public class Section 
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
		super();
	}
	
	public Section(int _numero,int _nombreQuestion,Test _idtest,Theme _idTheme)
	{
		this.numero=_numero;
		this.nombreQuestion=_nombreQuestion;
		this.idTest=_idtest;
		this.idTheme=_idTheme;
	}
	
	
	
}
