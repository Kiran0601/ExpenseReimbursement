package com.revature.ers.service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.revature.ers.doa.DaoImpl;
import com.revature.ers.model.Form;
import com.revature.ers.model.User;
import com.revature.ers.service.ImplLogin;


public class ImplService extends ImplLogin implements Service  {
    public ImplService() throws SQLException{}
   
    ImplLogin ad=new ImplLogin();
    DaoImpl di = new DaoImpl();
    User u=new User();    
    PreparedStatement pst=di.getCon().prepareStatement("select * from Cases where email=?");
    Scanner sc=new Scanner(System.in);
    @Override
	public void submitRequest(Form f) throws SQLException {
		System.out.println("Enter form details");
		  Form f1=new Form();
		  System.out.println("Enter userid");
		  String id=f1.setUserid(sc.nextLine());
		  System.out.println("Enter typeofExpense");
		  String type=f1.setTypeOfExpense(sc.nextLine());
		  System.out.println("Enter amount");
		  int rate= f1.setAmount(sc.nextInt());

		  PreparedStatement pst=di.getCon().prepareStatement("insert into formdetails(userid,amount,expensetype) values(?,?,?)");
		  pst.setString(1, id);
		  pst.setInt(2, rate);
		  pst.setString(3, type);
		  pst.execute();
	 }
	
	@Override
	public void viewResolvedRequest(String email) throws SQLException{
		String mailid=this.email;
		PreparedStatement pst=di.getCon().prepareStatement("select Cases.Status ,cases.submisiondate,employeedetails.empname,employeedetails.role,employeedetails.email from employeedetails INNER JOIN cases ON employeeDetails.email=Cases.email");
		ResultSet rs = pst.executeQuery();
		ResultSet rs2 = pst.getResultSet();
		ResultSetMetaData rsm=(ResultSetMetaData) rs2.getMetaData();
		while(rs.next()) {
			String val="resolved";
			String id=rs.getString(1);
			//System.out.println("Here");
			if(id.equalsIgnoreCase(val)) {
			String name=rs.getString(2);
			String role=rs.getString(3);
			String email2=rs.getString(4);
			System.out.print(name+" " );
			System.out.print(role+" " );
			System.out.println(email2+" " );}
		}
	}	
	@Override
	public void viewPendingRequest(String email) throws SQLException{
		
		String mailid=this.email;
		PreparedStatement pst=di.getCon().prepareStatement("select Cases.Status,cases.submisiondate ,employeedetails.empname,employeedetails.role,employeedetails.email from employeedetails INNER JOIN cases ON employeeDetails.email=Cases.email");
		ResultSet rs = pst.executeQuery();
		ResultSet rs2 = pst.getResultSet();
		ResultSetMetaData rsm=(ResultSetMetaData) rs2.getMetaData();
	    while(rs.next()) {
			String val="Pending";
			String id=rs.getString(1);
			if(id.equalsIgnoreCase(val)) {
			String name=rs.getString(2);
			String role=rs.getString(3);
			String email2=rs.getString(4);
			System.out.print(name+" " );
			System.out.print(role+" " );
			System.out.println(email2+" " );}
		}
	}
	}
    

