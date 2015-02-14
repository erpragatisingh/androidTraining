package com.mcq.login;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.AsyncFacebookRunner.RequestListener;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class FacebookActivity extends Activity {
    public static final String TAG = "FACEBOOK";
    private Facebook mFacebook;
    public static final String APP_ID = "260942374015035"; //the API Key for your Facebook APPs
    private AsyncFacebookRunner mAsyncRunner;
    private static final String[] PERMS = new String[] { "publish_stream","read_stream","offline_access","email" };
    private SharedPreferences sharedPrefs;
    private Context mContext;
 
   // private TextView username;
    private ProgressBar pb;
 
    public void setConnection() {
            mContext = this;
            mFacebook = new Facebook(APP_ID);
            mAsyncRunner = new AsyncFacebookRunner(mFacebook);
    }
 
    public void getID(ProgressBar progbar) {
           // username = txtUserName;
            pb = progbar;
           if (isSession()) {
                    Log.d(TAG, "sessionValid");
                    mAsyncRunner.request("me", new IDRequestListener());
            } else {
                    // no logged in, so relogin
                    Log.d(TAG, "sessionNOTValid, relogin");
                    mFacebook.authorize(this, PERMS, new LoginDialogListener());
            }
    }
 
    public void logout() throws MalformedURLException, IOException{
    	mFacebook.logout(mContext);
    	 sharedPrefs = PreferenceManager
                 .getDefaultSharedPreferences(mContext);
    	 sharedPrefs.edit().putLong("access_expires", -1)
                 .commit();
    	 sharedPrefs.edit().putString("access_token", null).commit();
    	
    }
    public boolean isSession() {
            sharedPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
            String access_token = sharedPrefs.getString("access_token", "x");
            Long expires = sharedPrefs.getLong("access_expires", -1);
            Log.d(TAG, access_token);
 
            if (access_token != null && expires != -1) {
                    mFacebook.setAccessToken(access_token);
                    mFacebook.setAccessExpires(expires);
            }
            return mFacebook.isSessionValid();
    }
 
    private class LoginDialogListener implements DialogListener {
 
            @Override
            public void onComplete(Bundle values) {
            	 pb.setVisibility(ProgressBar.GONE);
                    Log.d(TAG, "LoginONComplete");
                    String token = mFacebook.getAccessToken();
                    long token_expires = mFacebook.getAccessExpires();
                    Log.d(TAG, "AccessToken: " + token);
                    Log.d(TAG, "AccessExpires: " + token_expires);
                    sharedPrefs = PreferenceManager
                                    .getDefaultSharedPreferences(mContext);
                    sharedPrefs.edit().putLong("access_expires", token_expires)
                                    .commit();
                    sharedPrefs.edit().putString("access_token", token).commit();
                    mAsyncRunner.request("me", new IDRequestListener());
            }
 
            @Override
            public void onFacebookError(FacebookError e) {
            	
                    Log.d(TAG, "FacebookError: " + e.getMessage());
            }
 
            @Override
            public void onError(DialogError e) {
            	
                    Log.d(TAG, "Error: " + e.getMessage());
                    e.printStackTrace();
            }
 
            @Override
            public void onCancel() {
                    Log.d(TAG, "OnCancel");
            }
    }
 
    private class IDRequestListener implements RequestListener {
 
            @Override
            public void onComplete(String response, Object state) {
                    try {
                            Log.d(TAG, "IDRequestONComplete");
                            Log.d(TAG, "Response: " + response.toString());
                            JSONObject json = Util.parseJson(response);
 
                            final String id = json.getString("id");
                            final String name = json.getString("name");
                            final String email_id= json.getString("email");
                           
                          
                            FacebookActivity.this.runOnUiThread(new Runnable() {
                                    public void run() {
                                           // username.setText("Welcome: " + name+"\n ID: "+id);
                                           pb.setVisibility(ProgressBar.GONE);
                                    	  User user=new User();
                                          user.setName(name);
                                          user.setEmail(email_id);
                                          
                                          storeInSharedPreferences(user);
                                          Intent i = new Intent(mContext,com.mcq.test.TestAppActivity.class);
              							  startActivity(i);
 
                                    }
                            });
                    } catch (JSONException e) {
                            Log.d(TAG, "JSONException: " + e.getMessage());
                    } catch (FacebookError e) {
                    	
                            Log.d(TAG, "FacebookError: " + e.getMessage());
                    }
            }
 
            @Override
            public void onIOException(IOException e, Object state) {
                    Log.d(TAG, "IOException: " + e.getMessage());
            }
 
            @Override
            public void onFileNotFoundException(FileNotFoundException e,
                            Object state) {
                    Log.d(TAG, "FileNotFoundException: " + e.getMessage());
            }
 
            @Override
            public void onMalformedURLException(MalformedURLException e,
                            Object state) {
                    Log.d(TAG, "MalformedURLException: " + e.getMessage());
            }
 
            @Override
            public void onFacebookError(FacebookError e, Object state) {
            	
                    Log.d(TAG, "FacebookError: " + e.getMessage());
            }
 
    }
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	       mFacebook.authorizeCallback(requestCode, resultCode, data);
    }
     
    public void postOnWall(String msg) {
        Log.d("Tests graph API %%%%%$$$$%%%", msg);
         try {
                String response = mFacebook.request("me");
                Bundle parameters = new Bundle();
                parameters.putString("message", msg);
                parameters.putString("description", "test test test");
                response = mFacebook.request("me/feed", parameters, 
                        "POST");
                Log.d("Tests", "got response: " + response);
                if (response == null || response.equals("") || 
                        response.equals("false")) {
                   Log.v("Error", "Blank response");
                }
         } catch(Exception e) {
             e.printStackTrace();
         }
    }
    void  storeInSharedPreferences(User u){
		   SharedPreferences shp=getSharedPreferences("TEXT", 0);
		    final Editor et=shp.edit();
		    et.putString("name", u.name);
		    et.putString("email", u.email);
		    et.putString("phone", u.phone);
		    et.putString("password", u.password);
		    et.putString("address", u.address);
		    et.commit();
			
		}
    
    void publishOnWall(){
    	 Bundle params = new Bundle();
    	 params.putString("message", "posting...");
         params.putString("name", "CBeebies");
         params.putString("caption", "cbeebies");
         params.putString("link", "http://www.facebook.com/cbeebies");
         params.putString("description","How do elephants protect themselves from the sun? Andy knows. And you can find out, too - the Andy's Wild Adventures quiz is back!" 
        		+" Discover fantastic animal facts with Andy and Kip - play along by pressing the Red Button on your remote on Sky and Freeview all this week"+
        		 " (N.B. it's not on all day - you can check the times here: http://bbc.in/LY7IoH )");
        params.putString("picture", "http://www.bbc.co.uk/cbeebies/andyswildadventures/img/andys_wild_adventures_brand_224_126.png");
  
         mAsyncRunner.request("me/feed", params,"POST",  new WallPostListener(),null);
     }
  
     private final class WallPostListener implements RequestListener {

		@Override
		public void onComplete(String response, Object state) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onIOException(IOException e, Object state) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFileNotFoundException(FileNotFoundException e,
				Object state) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onMalformedURLException(MalformedURLException e,
				Object state) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFacebookError(FacebookError e, Object state) {
			// TODO Auto-generated method stub
			
		}
        

		
		
		}
     
    }
        

