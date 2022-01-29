package com.revature.ers.service;

import java.sql.SQLException;

public interface IntManager {

    public void ManagerResolvedRequest() throws SQLException;
    public void ManagerPendingRequest() throws SQLException;
    public void ManagerApproval() throws SQLException;
	
}