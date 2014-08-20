package fr.eni_ecole.qcm.store;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni_ecole.qcm.model.Test;

public class TestStore {
	
	
	
	/**
	 * @return La liste peut être vide mais jamais <code>null</code>
	 * @throws Exception 
	 */
	public static ArrayList<Test> listeTest()
	{
		
		ArrayList<Test>listeT=new ArrayList<Test>();
		Connection cnx = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			cnx = PoolConnexion.getConnection();
			stm = cnx.createStatement();
			rs = stm.executeQuery("select * from Tests");
			
			while(rs.next())
			{
				Test test = new Test();
				test.setIdTest(rs.getInt("idTest"));
				test.setDuree(rs.getInt("duree"));
				test.setNom(rs.getString("nom"));
				test.setSeuilAcquis(rs.getInt("seuilAcquis"));
				test.setSeuilEnCours(rs.getInt("seuilEnCours"));
				listeT.add(test);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) rs.close();
				if (stm!=null) stm.close();
				if (cnx!=null && !cnx.isClosed()) cnx.close();
			}
		    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return listeT;
	}
	
	// Rechercher un test
	
	public static Test rechercherTest(Integer idTest ){
		Connection cnx=null;
		PreparedStatement rqt=null;
		ResultSet rs=null;
		try{
			cnx = PoolConnexion.getConnection();
		    rqt=cnx.prepareStatement("select * from tests where idTest = ?");
			rqt.setInt(1, idTest);
			rs=rqt.executeQuery();
			if (rs.next())
			{
				return new Test (rs.getInt("idTest"),rs.getInt("duree"),
				rs.getString("nom"),rs.getInt("seuilAcquis"),rs.getInt("seuilEnCours"),rs.getInt("nbSection"));
			}
		}
	    catch (Exception e)
	    {
	    	// TODO: handle exception
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	try {
			    if (rs!=null) rs.close();
			    if (rqt!=null) rqt.close();
			    if (cnx!=null) cnx.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
		
		return null;
	}
	
	public static void ajouter(Test test) throws Exception{
		Connection cnx=null;
		CallableStatement cstmt=null;

		try{
				

			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.InsertTests(?,?,?,?,?,?)}");
			cstmt.setInt(1, test.getDuree());
			cstmt.setString(2,test.getNom());
			cstmt.setInt(3,test.getSeuilAcquis());
			cstmt.setInt(4,test.getSeuilEnCours());
			cstmt.setInt(5,test.getNbSection());
			cstmt.registerOutParameter(6, java.sql.Types.INTEGER);
			cstmt.execute();
			test.setIdTest(cstmt.getInt(6));
		}
	    catch (Exception e)
	    {
		// TODO: handle exception
		e.printStackTrace();
	    }
				
		finally
		{
			if (cstmt!=null)
				cstmt.close();
			if (cnx!=null) cnx.close();
		}
	}
		
		
	public static void modifier(Test test) throws Exception{
		Connection cnx=null;
		CallableStatement cstmt =null;
		
		try{
			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.UpdateTests(?,?,?,?,?,?)}");
			cstmt.setInt(1,test.getIdTest());	
			cstmt.setInt(2,test.getDuree());
			cstmt.setString(3, test.getNom());
			cstmt.setInt(4,test.getSeuilAcquis());	
			cstmt.setInt(5,test.getSeuilEnCours());	
			cstmt.setInt(6,test.getNbSection());	
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
	
	public static void supprimer(Integer idTest ) throws Exception{
		Connection cnx=null;
		
		
		CallableStatement cstmt =null;
		try{

			cnx=PoolConnexion.getConnection();
			cstmt = cnx.prepareCall("{call dbo.DeleteTests(?)}");
			cstmt.setInt(1,idTest);	
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



