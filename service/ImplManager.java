package com.revature.ers.service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.revature.ers.doa.*;
import com.revature.ers.model.Form;

public class ImplManager implements IntManager {
	public ImplManager() throws SQLException{}
    
    ImplLogin ad=new ImplLogin();
    DaoImpl di = new DaoImpl();
     @Override
	public void ManagerResolvedRequest() throws SQLException {
		PreparedStatement pst=di.getCon().prepareStatement("select Cases.Status ,employeedetails.empname,employeedetails.role,employeedetails.email from employeedetails INNER JOIN cases ");
		ResultSet rs = pst.executeQuery();
		ResultSet rs2 = pst.getResultSet();
		ResultSetMetaData rsm=(ResultSetMetaData) rs2.getMetaData();
		while(rs.next()) {
			String val="resolved";
			String id=rs.getString(1);
			if(id.equalsIgnoreCase(val)) {
			String name=rs.getString(2);
			String role=rs.getString(3);
			String email2=rs.getString(4);
			System.out.print(name+" " );
			System.out.print(role+" " );
			System.out.println(email2+ " " );}
		}}

	@Override
	public void ManagerPendingRequest() throws SQLException {
		PreparedStatement pst=di.getCon().prepareStatement("select Cases.Status ,employeedetails.empname,employeedetails.role,employeedetails.email from employeedetails INNER JOIN cases ");
		ResultSet rs = pst.executeQuery();
		ResultSet rs2 = pst.getResultSet();
		ResultSetMetaData rsm=(ResultSetMetaData) rs2.getMetaData();
		while(rs.next()) {
			String val="pending";
			String id=rs.getString(1);
			if(id.equalsIgnoreCase(val)) {
			String name=rs.getString(2);
			String role=rs.getString(3);
			String email2=rs.getString(4);
			System.out.print(name+" " );
			System.out.print(role+ " " );
			System.out.println(email2+" " );}
		}}
	@Override
	public void ManagerApproval() throws SQLException{
		Statement stmt=di.getCon().createStatement();
		//PreparedStatement pst=di.getCon().prepareStatement("Upadate Cases set status=Resolved");
		String s="Upadate Cases set status='Resolved' where status='Pending'";
		stmt.execute(s);
		ResultSet rs=stmt.executeQuery(s);
		//ResultSet rs = stmt.executeQuery(QUERY);
		while(rs.next()) {
			//ResultSet rs = null;
			System.out.print("Userid "+rs.getString(1));
			System.out.println("Status "+rs.getString(2));
		}
		}
		
		
	
	}