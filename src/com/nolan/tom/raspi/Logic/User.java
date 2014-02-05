package com.nolan.tom.raspi.Logic;

public class User{
	
	private String username;
	private String password;
	
	public User(String name, String psswrd)
	{
		setUsername(name);
		setPassword(psswrd);
	}

	public String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
