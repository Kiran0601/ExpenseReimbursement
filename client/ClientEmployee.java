package com.revature.ers.client;

import com.revature.ers.doa.*;
import com.revature.ers.model.*;
import com.revature.ers.model.Form;
import com.revature.ers.service.*;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientEmployee {
	
	//Form f =new Form();
	public ClientEmployee() throws SQLException{}
	ImplService im=new ImplService();
	DaoImpl da=new DaoImpl();
	
	public void EmployeeLogin() throws SQLException {
		try (Scanner sc=new Scanner(System.in)){
			System.out.println("Welcome to Employee login!!");
			ImplLogin ad = new ImplLogin();
			ad.getId();
			
			Form f =new Form();
			ad.login();
			System.out.println("Choose the operation you need to perform ");
			System.out.println("1. View Resolved Cases");
			System.out.println("2. View Pending Cases");
			System.out.println("3. Submit form");
			System.out.println("3. Logout");
		
			int e = sc.nextInt();
			switch(e) {
			case 1:
				String email=ad.getEmail();
				System.out.println(email);
				//System.out.println("In client");
				im.viewResolvedRequest(email);
				break;
			case 2:
				
				String email1=ad.getEmail();
				im.viewPendingRequest(email1);
				break;
			case 3:
				im.submitRequest(f);
				break;
			case 4:
				ad.logout();
				break;
			}	
		} 
	}
}