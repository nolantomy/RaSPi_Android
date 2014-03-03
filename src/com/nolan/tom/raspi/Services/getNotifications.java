package com.nolan.tom.raspi.Services;

import com.nolan.tom.raspi.Logic.User;
import android.os.AsyncTask;

public class getNotifications 
				extends AsyncTask<User, Void , Boolean> {
	private Exception exception;
    /**
     * This method may return anything you want and is
     * not limited to String. If you change the return 
     * value do not forget to change the paramate in 
     * the onPostExecute method.
     */
    protected Boolean doInBackground(User... theUser) {
        try {
            User tempUser = theUser[0];
            return HttpHandler.post_User(tempUser,"user");
        } catch (Exception e) {
            this.exception = e;
            return false;
        }
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
         // Do something with your value
    }

}
