package com.nolan.tom.raspi.Services;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import com.nolan.tom.raspi.Logic.User;


public class HttpHandler {
	
	private static boolean result;
	private final static String TAG = "HttpHandler";
	private final static String appUrl = "http://" + "upbeat-element-358" + ".appspot.com/";
	private static HttpClient httpClient = new DefaultHttpClient();
	private static JSONObject tempObj = new JSONObject(), jsonResult;
	private static HttpResponse response;
	private static HttpPost request;
	private static StringEntity postJsonObject;
   
	public static boolean post_User(User theUser, String method) throws JSONException, UnsupportedEncodingException
	{
		
		StringEntity se = new StringEntity( "{'user_name':'"+ theUser.getUsername()+"','password':'"+ theUser.getPassword()
													+"','method':'"+method+"'}");

		String res = null ;
	    try { 
	    	request = new HttpPost(appUrl+"notifications");
	        postJsonObject =new StringEntity(tempObj.toString());
	        request.addHeader("Content-type", "application/json");
	        request.setEntity(se);
	        response = httpClient.execute(request);
	        jsonResult = new JSONObject(response.getEntity().toString());
	        res = jsonResult.get("answer").toString();
	    }catch (Exception ex) {
	        // handle exception here
	    	Log.d(TAG, "Transmission failed " + ex.getMessage());
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	        Log.d(TAG, "Transmission finished " + res);
	        //add notifications to the user
	    }
	    return result;
	}
	
	public static boolean getNotifications(User theUser) throws JSONException
	{
		
		tempObj.put("user_name", theUser.getUsername());
		tempObj.put("password", theUser.getPassword());
		String res = null;
		try { 
	        request = new HttpPost(appUrl+"notifications");
	        postJsonObject =new StringEntity(tempObj.toString());
	        request.addHeader("Content-type", "application/json");
	        request.setEntity(postJsonObject);
	        response = httpClient.execute(request);
	        jsonResult = new JSONObject(response.getEntity().toString());
	        res = jsonResult.get("answer").toString();
	    }catch (Exception ex) {
	        // handle exception here
	    	Log.d(TAG, "Transmission failed " + ex.getMessage());
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	        Log.d(TAG, "Transmission finished " + res);
	        //add notifications to the user
	    }
	    return result;
		
		
	}
	
}//class

