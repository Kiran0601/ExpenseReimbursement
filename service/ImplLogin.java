package com.revature.ers.service;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.ers.client.*;
import com.revature.ers.model.*;
import com.revature.ers.doa.*;
public class ImplLogin implements IntLogin
{
	   public ImplLogin() throws SQLException {}
	EmployeeLogin l = new EmployeeLogin();
	DaoImpl cdi = new DaoImpl();
	Scanner sc = new Scanner(System.in);
	
	User log = new User();

	String id,name,email,role;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public ImplLogin(String id, String name, String email, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "ImplLogin [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
    public void login()   
    {
		cdi.getCon();
		System.out.println("Enter your Email");
		log.setEmail(sc.nextLine());
		System.out.println("Enter your password");
		log.setPassword(sc.nextLine());
		try {
			PreparedStatement pst=cdi.getCon().prepareStatement("select * from EmployeeDetails where email=? and password=?");
			pst.setString(1, log.getEmail());
			pst.setString(2, log.getPassword());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//System.out.println(rs.getString(4));
				//System.out.println(rs.getString(5));
				//System.out.println(log.getEmail());
				//System.out.println(log.getPassword());
				
				if(rs.getString(4).equals(log.getEmail()) && rs.getString(5).equals(log.getPassword()))
				{
					System.out.println("Logged in Successfully !!");
					id = rs.getString(1);
					name=rs.getString(2);
					role=rs.getString(3);
					email=rs.getString(4);
					
					
				}
				else{
					System.out.println("You have entered wrong credentials.");
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void logout() {
		System.out.println("Logged out successfully!!");
		l.strt();
	}
	
	

	
		}
