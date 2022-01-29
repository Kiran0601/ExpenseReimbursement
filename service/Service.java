package com.revature.ers.service;

import java.sql.SQLException;

import com.revature.ers.client.*;
import com.revature.ers.model.*;

public interface Service {
	
	public void submitRequest(Form f) throws SQLException;
	public void viewPendingRequest(String email) throws SQLException;
	void viewResolvedRequest(String email) throws SQLException;
	
}
