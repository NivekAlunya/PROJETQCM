package fr.eni_ecole.qcm.model;

import java.io.Serializable;

public class Administrateur implements Serializable
{
	
	// definition des attributs
	private int idAdministrateur;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String typeAdmin;
	private String email;
	
	// Constructeurs
	
	 public Administrateur()
	{
		 this(0,null,null,null,null);
	}
	public Administrateur(int idAdministrateur, String nom, String prenom,
				String motDePasse, String email)
	{
		super();
		this.idAdministrateur = idAdministrateur;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.email = email;
	}

	// méthodes Get
	
	public int getIdAdministrateur()
	{
		return idAdministrateur;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public String getMotDePasse()
	{
		return motDePasse;
	}
	
	public String getTypeAdmin() {
		return typeAdmin;
	}
			
	public String getEmail()
	{
		return email;
	}
	
	// méthodes Set
	public void setIdAdministrateur(int idAdministrateur)
	{
		this.idAdministrateur = idAdministrateur;
	}
		
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public void setMotDePasse(String motDePasse) 
	{
		this.motDePasse = motDePasse;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}	
	
	public void setTypeAdmin(String typeAdmin) {
		this.typeAdmin = typeAdmin;
	}

}
