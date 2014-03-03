package com.nolan.tom.raspi.Logic;

import java.util.concurrent.ExecutionException;
import org.json.JSONException;

import android.os.AsyncTask;

import com.nolan.tom.raspi.Services.*;

public class RaspberrySPi {
	//static instance of raspberrySPi
	private static RaspberrySPi raspberrySpi;
	//the user currently logged in
	private User userloggedin ;
	private boolean userOk;
	private AsyncTask Async_Task;
	
	
	/**  
	 * Private Constructor
	 * @param void
	 * @return void
	 */
	private RaspberrySPi()
	{	 
		userOk = false;
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
	
	
	
	/*
	 * *************** getter and setter methods
	 */
	//userOk
	public void setUserOk(boolean b)
	{
		this.userOk = b;
	}
	public boolean getUserOk()
	{
		return this.userOk;
	}
	//userloggedin
	public User getUserloggedin() {
		return userloggedin;
	}
	public void setUserloggedin(User userloggedin) {
		this.userloggedin = userloggedin;
	}
	
	
	
	
	
	/**  
	 * Register a new user 
	 * @param username the unique of the user
	 * @param password the password the user will use to log into the app
	 * @return 
	 * @return RaspberrySPi
	 * @throws JSONException 
	 */
	public void registerNewUser(String username, String password) 
	{
		User newUser = new User(username, password);
		Async_Task = new postUserTask().execute(newUser,"register");
	}
	/**
	 * Check if user Exists
	 * @param the username entered
	 * @param the password entered
	 * @return Boolean
	 */
	public void checkUser(String username, String password)
	{
		User newUser = new User(username, password);
		Async_Task = new postUserTask().execute(newUser,"login");
	}
	
	/**
	 * Return notifications for this user
	 * @return Notification Array
	 */
	public Notification[] getNotifications()
	{
		return null;
		
	}
	
	/**
	 * stream Video linked to a notification
	 * @return void
	 */
	public void streamVideo(Notification notification)
	{
		//getVideo from cloud... 
		
	}
	
	
}
