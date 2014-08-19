package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import fr.eni_ecole.qcm.model.Theme;

public class ThemeStore 
{

	public static void ajouter(Theme theme) throws Exception{
		Connection cnx=null;
		CallableStatement cstmt=null;
		
		try{

			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.insertThemes(?, ?)}");
			cstmt.setString(2, theme.getNom());
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			cstmt.execute();
			theme.setIdTheme(cstmt.getInt(1));
		} catch (Exception e) {			
			e.printStackTrace();
		}
		finally{
			if (cstmt!=null) cstmt.close();
			if (cnx!=null) cnx.close();
		}
	}
		
	
	public static void modifier(Theme theme) throws Exception{
		Connection cnx=null;
		CallableStatement cstmt=null;
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.updateThemes(?, ?)}");
			cstmt.setInt(1,theme.getIdTheme());	
			cstmt.setString(2, theme.getNom());
			cstmt.execute();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (cstmt!=null) cstmt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	public static void supprimer(Theme theme) throws Exception{
		Connection cnx=null;
		CallableStatement cstmt=null;
		try{

			cnx=PoolConnexion.getConnection();				
			cstmt = cnx.prepareCall("{call dbo.deleteThemes(?)}");
			cstmt.setInt(1,theme.getIdTheme());				
			cstmt.execute();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (cstmt!=null) cstmt.close();
			if (cnx!=null) cnx.close();
		}				
	}
	
	
	public static ArrayList<Theme> listerTheme() throws Exception{
		Connection cnx=null;

		
		Statement rqt=null;
		ResultSet rs=null;
		ArrayList<Theme> listeTheme = new ArrayList<Theme>();
		try{

			cnx = PoolConnexion.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery("select * from Themes");
			Theme theme = null;
			while (rs.next()){
				theme = new Theme(
					rs.getInt("IdTheme"),
					rs.getString("nom")									
				);
				listeTheme.add(theme);				
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
		}
		
		return listeTheme;
	}
	
	
	public static Theme rechercherTheme(int idTheme) throws Exception
	{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement("select * from Themes where id = ?");
			rqt.setInt(1, idTheme);
			rs=rqt.executeQuery();
			if (rs.next()){
				
				return new Theme(rs.getInt("idTheme"),rs.getString("nom"));								
			} else {
				return null;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}

		return null;
	}	
	public static Theme rechercherTheme(String Nom) throws Exception
	{
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx=PoolConnexion.getConnection();
			rqt=cnx.prepareStatement("select * from Themes where nom = ?");
			rqt.setString(1, Nom);
			System.out.println(Nom);
			rs=rqt.executeQuery();
			if (rs.next()){
				System.out.println("retour" + (rs.getString("nom")));
				return new Theme(rs.getInt("idTheme"),rs.getString("nom"));								
			} else {
				return null;
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (rs!=null) rs.close();
			if (rqt!=null) rqt.close();
			if (cnx!=null) cnx.close();
		}

		return null;
	}	
}
