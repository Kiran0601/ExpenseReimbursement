package com.revature.ers.client;
import java.sql.SQLException;
import java.util.Scanner;
public class EmployeeLogin  {

		
		public void strt() {
			System.out.println("Welcome!!");
			System.out.println("What do you want to login as?");
		    System.out.println("Press 1 to login as Employee");
			System.out.println("Press 2 to login as Manager");	
		}
		
		public static void main(String[] args) throws ClassNotFoundException,SQLException {
			EmployeeLogin l = new EmployeeLogin();
			ClientEmployee e = new ClientEmployee();
			ClientManager m = new ClientManager();
			
			Scanner sc = new Scanner(System.in);
			
			l.strt();
			int i = sc.nextInt();
			switch(i) {
			case 1:
				e.EmployeeLogin();
				break;
			case 2:
				m.ManagerLogin();
				break;
			
			default:
				l.strt();
			}
			sc.close();
	}}
