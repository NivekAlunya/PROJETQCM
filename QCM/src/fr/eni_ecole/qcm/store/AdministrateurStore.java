package fr.eni_ecole.qcm.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni_ecole.qcm.model.Administrateur;

public class AdministrateurStore 
{
	public static Administrateur getAdministrateur(String login, String motdepasse)
	{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try
		{
			
			cnx = PoolConnexion.getConnection();
			
			rqt = cnx.prepareStatement("select idAdministrateur, nom, prenom,typeAdmin,email,motdepasse,login from administrateurs where login=? and motdepasse=?");
			rqt.setString(1, login);
			rqt.setString(2, motdepasse);
			rs=rqt.executeQuery();
			//
			if (rs.next())
			{
				return new Administrateur(rs.getInt("idAdministrateur"), rs.getString("nom"), rs.getString("prenom"), rs.getString("motDePasse"), rs.getString("login"), rs.getString("typeAdmin"), rs.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try {
				if (rs!=null) rs.close();
				if (rqt!=null) rqt.close();
				if (cnx!=null) cnx.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
}


