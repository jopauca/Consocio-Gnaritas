package com.coagmento.parsers;

public class LoginDataSet {
	private String name = "";
	private int userID = 0;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getUserID() { return userID; }
	public void setUserID(int userID) { this.userID = userID; }
	
	@Override
	public String toString() 
	{
		return "User Name: " + this.name + "  UserID: " + this.userID;
	}
}
