package fr.eni_ecole.qcm.store;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class PoolConnexion {

	public static Connection getConnection() throws Exception {
		InitialContext jndi;
		try {
			jndi = new InitialContext();
			DataSource ds = (DataSource)jndi.lookup("java:comp/env/sqlserver-PROJETQCM");
			return ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Connexion non établie via le pool de connections...");
	}
	
}
