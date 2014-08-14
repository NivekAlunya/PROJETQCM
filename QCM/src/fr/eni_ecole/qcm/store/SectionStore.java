package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import fr.eni_ecole.qcm.model.Section;

public class SectionStore
{
	public static void ajouter(Section sect)
			throws SQLException {
		Connection cnx=null;
		CallableStatement cstmt=null; 
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.InsertSections(?,?,?,?)}");
				
			cstmt.setInt(1, sect.getNumero());
			cstmt.setInt(2, sect.getNombreQuestion());
			cstmt.setInt(3, sect.getTest().getIdTest());
			cstmt.setInt(4, sect.getTheme().getIdTheme());
			cstmt.executeUpdate();

				// affecter le numero de ligne calculé à l'objet
				

			} 
		catch (Exception e)	
		{
		// TODO: handle exception
		e.printStackTrace();
	    }
		 finally
		 {
			if (cstmt != null)	cstmt.close();
			if (cnx!=null)		cnx.close();
		}

	}	
	public static void supprimer(Section sect) throws SQLException 
	{
		Connection cnx=null;
		CallableStatement cstmt=null; 
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.DeleteSections(?,?,?)}");
			cstmt.setInt(1,sect.getNumero());
			cstmt.setInt(2,sect.getTest().getIdTest());
			cstmt.setInt(3,sect.getTheme().getIdTheme());
			cstmt.execute();
		   }
		catch (Exception e)
		   {
			// TODO: handle exception
			e.printStackTrace();
		   }
		
		finally
		{
			if (cstmt!=null)	cstmt.close();
			if (cnx!=null)		cnx.close();
		}
	}
	
	
	
	

}
