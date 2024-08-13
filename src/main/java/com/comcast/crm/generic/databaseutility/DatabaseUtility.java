package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

;

public class DatabaseUtility {
	Connection con;
	public void getDbconnection()
	{
		try
		{
			java.sql.Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			con =DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	public void closeDbconnection()
	{
		try
		{
			con.close();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	public ResultSet executeSelectQuery(String query) 
	{
		ResultSet r =null;
		try
		{
			Statement stat =con.createStatement();
			r=stat.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return r;
		
	}
	public int executeNonselectQuery(String query)
	{
		int r=0;
		try
		{
			Statement stat =con.createStatement();
			r=stat.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return r;
	}

}
