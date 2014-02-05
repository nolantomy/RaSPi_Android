package com.nolan.tom.raspi.Services;



import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.util.Log;

import com.nolan.tom.raspi.Logic.User;

public class JsonHandler {
	
	// url of my google app engine server
	private final static String url = "http://www.upbeat-element-358.appspot.com/";
	private final static int readTimeout = 10000, connectTimeout = 15000;
	
	public static boolean postUser(User theUser, String method )
	{
		//start a new thread??
		InputStream inputStream = null;
        String result = "";
        try {
 
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
 
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url+"user");
 
            String json = "";
 
            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("username", theUser.getUsername());
            jsonObject.accumulate("password", theUser.getPassword());
 
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();
 
            // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person); 
 
            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);
 
            // 6. set httpPost Entity
            httpPost.setEntity(se);
 
            // 7. Set some headers to inform server about the type of the content   
            httpPost.setHeader("Method", method);			//whether to login or register
            httpPost.setHeader("Content-type", "user");		//a user object is being sent
 
            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
 
            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
 
            // 10. convert inputstream to string
            
 
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
 
        // 11. return result
        return false;
    }


	
}
	
