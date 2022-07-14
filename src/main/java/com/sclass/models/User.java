package com.sclass.models;

public class User {

	private int id;
	private String username;
	private String pass;
	
	//constructors
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String pass) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
	}
	
	//getters,setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	//Stringy
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pass=" + pass + "]";
	}
	
	
	
	
}
