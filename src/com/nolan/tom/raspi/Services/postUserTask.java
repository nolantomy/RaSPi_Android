package com.nolan.tom.raspi.Services;

import com.nolan.tom.raspi.Register_User;
import com.nolan.tom.raspi.Logic.RaspberrySPi;
import com.nolan.tom.raspi.Logic.User;

import android.content.Intent;
import android.os.AsyncTask;

public class postUserTask 
	 extends AsyncTask<Object, Double , Void> {
		    private Exception exception;
		    private boolean result;
		 
		    /**
		     * This method may return anything you want and is
		     * not limited to String. If you change the return 
		     * value do not forget to change the paramate in 
		     * the onPostExecute method.
		     */
		    protected Void doInBackground(Object... theObj) {
		        try {
		            User tempUser = (User) theObj[0];
		            String method = (String) theObj[1];
		            result =  HttpHandler.post_User(tempUser, method);
		        } catch (Exception e) {
		            this.exception = e;
		            result = true;
		        }
		        
				return null;
		    }
		    /**
		     * Whenever doInBackground finished, this method is
		     * called with the doInBackground return value.
		     */
		    protected void onPostExecute(String value) {
		        /**
		         * You need to check if any exceptions where
		         * set in the background process and handle 
		         * them.
		         *
		         * Check this.exception
		         */
		    	RaspberrySPi.getInstance().setUserOk(result);
		        // Do something with your value
		    }
		}

