package com.nolan.tom.raspi.Logic;

import com.nolan.tom.raspi.Services.JsonHandler;

public class RaspberrySPi {
	//static instance of raspberrySPi
	private static RaspberrySPi raspberrySpi;
	//the user currently logged in
	private User userloggedin ;
	
	
	/**  
	 * Private Constructor
	 * @param void
	 * @return void
	 */
	private RaspberrySPi()
	{	 
	}
	/**  
	 * Return the instance of 
	 * @param void
	 * @return RaspberrySPi
	 */
	public static RaspberrySPi getInstance()
	{
		if (raspberrySpi == null)
		{
			raspberrySpi = new RaspberrySPi();
		}
		return raspberrySpi;
	}
	/**  
	 * Register a new user 
	 * @param username the unique of the user
	 * @param password the password the user will use to log into the app
	 * @return RaspberrySPi
	 */
	public boolean registerNewUser(String username, String password)
	{
		boolean nameOK = false;
		User newUser = new User(username, password);
		JsonHandler.postUser(newUser,"register");
		return nameOK ;
			
	}
	/**
	 * Check if user Exists
	 * @param the username entered
	 * @param the password entered
	 * @return Boolean
	 */
	public boolean checkUser(String username, String password)
	{
		boolean userOk =false;
		
		User newUser = new User(username, password);
		JsonHandler.postUser(newUser,"login");
		return userOk;
	}
	
	
	
}
