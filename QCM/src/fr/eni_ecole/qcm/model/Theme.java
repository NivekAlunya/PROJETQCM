package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Theme implements Serializable
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
		this(0,"");
	}
	
	public Theme(int idTheme,String nom)
	{
		super();
		this.idTheme=idTheme;
		this.nom=nom;
	}
	
	
}
