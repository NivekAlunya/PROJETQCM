package fr.eni_ecole.qcm.model;

public class Theme 
{
	private int idTheme;
	private String nom;
	
	
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Theme()
	{
		super();
	}
	
	public Theme(int _idTheme,String _nom)
	{
		this.idTheme=_idTheme;
		this.nom=_nom;
	}
	
	
}
