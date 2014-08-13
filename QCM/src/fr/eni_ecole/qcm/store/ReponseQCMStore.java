package fr.eni_ecole.qcm.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import fr.eni_ecole.qcm.model.ReponseQCM;


public class ReponseQCMStore 
{

	public static void ajouter(ReponseQCM reponseQCM) throws Exception
	{
		Connection cnx=null;
		CallableStatement cstmt=null;

		try{

			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.insererReponseQCM(?, ?, ?)}");
			cstmt.setString(1, String.valueOf(reponseQCM.getCochee()));
			cstmt.setInt(2, reponseQCM.getGenerationQCM().getIdGenerationQCM());
			cstmt.setInt(3, reponseQCM.getReponse().getIdReponse());
			cstmt.execute();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (cstmt!=null) cstmt.close();
			if (cnx!=null) cnx.close();
		}
	}
	
	
	public static void modifier(ReponseQCM reponseQCM) throws Exception
	{
		Connection cnx=null;
		CallableStatement cstmt=null;
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.updateReponseQCM(?, ?, ?)}");
			cstmt.setString(1, String.valueOf(reponseQCM.getCochee()));
			cstmt.setInt(2, reponseQCM.getGenerationQCM().getIdGenerationQCM());
			cstmt.setInt(3, reponseQCM.getReponse().getIdReponse());
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
	
	
	public static void supprimer(ReponseQCM reponseQCM) throws Exception
	{
		Connection cnx=null;
		CallableStatement cstmt=null;
		try{

			cnx=PoolConnexion.getConnection();				
			cstmt = cnx.prepareCall("{call dbo.deleteReponseQCMs(?)}");
			cstmt.setInt(3, reponseQCM.getReponse().getIdReponse());			
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
}
