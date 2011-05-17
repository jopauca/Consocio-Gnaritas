package com.coagmento.mobile;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.coagmento.parsers.*;;

public class Coagmento extends Activity {
	
	//Declare preferences variable
	SharedPreferences prefs;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Get sharedPrefs that are stored in file "preferences"
        prefs = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
        
        //Extract int from "userID" field in prefs. If no data, userID = 0
        int userID = prefs.getInt("userID", 0);
        
        //If user ID is 0, load login screen
        if (userID == 0) {
        	setContentView(R.layout.login);
        	
        	//Set the 'register' textview to open browser and go to register site
        	TextView register = (TextView) findViewById(R.id.registerClick);
        	register.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coagmento.org/index.php?page=signup"));
					startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coagmento.org/index.php?page=signup")));
				}
			});
        	
        	//Set the login button to do login actions when clicked
        	Button login = (Button) findViewById(R.id.LoginButton);
        	login.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//Pull strings from user name and password box and trim them
					EditText usernameBox = (EditText) findViewById(R.id.usernameInput);
		        	EditText passwordBox = (EditText) findViewById(R.id.passwordInput);
		        	String username = usernameBox.getText().toString().trim();
		        	String password = passwordBox.getText().toString().trim();
		        	
		        	//Instantiate parser and send login data to server
		        	LoginParser parser = new LoginParser();    	
		        	LoginDataSet loginData = parser.parseLogin(username, password);
		        	
		        	//If userID is 0, then login is invalid; show toast message
		        	if (loginData.getUserID() == 0 || loginData.getUserID() == 176) {
		        		Toast toast = Toast.makeText(getApplicationContext(), "Invalid username and/or password!", Toast.LENGTH_LONG);
		        		toast.show();
		        	} else {
		        		//If the remember login box is checked, commit the userID to shared preferences
		        		CheckBox rememberLogin = (CheckBox) findViewById(R.id.RememberLogin);
			        	if (rememberLogin.isChecked()) {
			        		prefs = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
			                SharedPreferences.Editor prefEdit = prefs.edit();
			                prefEdit.putString("username", loginData.getName());
			                prefEdit.putInt("userID", loginData.getUserID());
			                prefEdit.commit();
			        	}
			        	
			        	//Create bundle containing user information
			        	Bundle userData = new Bundle();
			        	userData.putString("username", loginData.getName());
			        	userData.putInt("userID", loginData.getUserID());
			        	Intent home = new Intent(Coagmento.this, Home.class);
			        	home.putExtras(userData);
			        	
			        	//Move to next screen
			        	startActivity(home);
		        	}
		        	
				}
			});
        	
        } else {
        	//User ID is already stored
        	//Get data from prefs and bundle it for home activity
        	Bundle appData = new Bundle();
        	appData.putString("username", prefs.getString("username", "defUser"));
        	appData.putInt("userID", prefs.getInt("userID", 0));
        	Intent home = new Intent(Coagmento.this, Home.class);
        	home.putExtras(appData);
        	
        	startActivity(home);
        }
    }
}