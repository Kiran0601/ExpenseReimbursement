package com.revature.ers.doa;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DaoImpl implements Dao
	{
		
		public Connection getCon(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		}
		
	}
