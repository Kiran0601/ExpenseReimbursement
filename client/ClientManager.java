package com.revature.ers.client;
import java.sql.SQLException;
import java.util.Scanner;
import com.revature.ers.doa.*;
import com.revature.ers.service.*;

public class ClientManager {
	public ClientManager() throws SQLException{}

    ImplManager manImp = new ImplManager();

	public void ManagerLogin() throws SQLException {
		ImplLogin l = new ImplLogin();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Welcome to Manager login!!");
			l.login();
			
			System.out.println("Choose any of the option");
			System.out.println("1. View resolved cases");
			System.out.println("2. View Pending Requests");
			System.out.println("3.Approval");
			System.out.println("4. Logout");
			
			int m = sc.nextInt();
			switch(m) {
			case 1:
				manImp.ManagerResolvedRequest();
				break;
			case 2:
				manImp.ManagerPendingRequest();
				break;
			case 3:
				manImp.ManagerApproval();
				break;
			case 4:
				l.logout();
				break;
			}
		}
	}
}