package fr.eni_ecole.qcm.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni_ecole.qcm.model.Administrateur;

public class AdministrateurStore 
{


public static Administrateur getAdministrateur(Administrateur administrateur) throws Exception
			 
			{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try
		{
			
			cnx = PoolConnexion.getConnection();
			
			rqt = cnx.prepareStatement("select idAdministrateur, nom, prenom,typeAdmin from administrateurs where email=? and motdepasse=?");
			rqt.setString(1, administrateur.getEmail());
			rqt.setString(2, administrateur.getMotDePasse());
			rs=rqt.executeQuery();
			//
			if (rs.next())
			{
				administrateur.setIdAdministrateur(rs.getInt("idAdministrateur"));
				administrateur.setNom(rs.getString("nom"));
				administrateur.setPrenom(rs.getString("prenom"));
			}
			// ...sinon on renvoie null
			else {
				administrateur = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		finally
		{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}
		return administrateur;
	}

}


