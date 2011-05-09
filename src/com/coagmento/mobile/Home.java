package com.coagmento.mobile;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity {
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        final Bundle userData = this.getIntent().getExtras();
        
        TextView usernameText = (TextView) findViewById(R.id.homeUsernameText);
        usernameText.setText(userData.getString("username"));
        
        //Set up log out button
        Button logout = (Button) findViewById(R.id.logoutButton);
        logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Retrieve preferences and replace username with blank string and userID with 0, then go back to login
				SharedPreferences prefs = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
				SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("username", "");
                prefEdit.putInt("userID", 0);
                prefEdit.commit();
                startActivity(new Intent(Home.this, Coagmento.class));
			}
		});
        
        
        //Set up projects button
        Button proj = (Button) findViewById(R.id.projects);
        proj.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Pass bundle containing user information to project list
				Intent projectList = new Intent(Home.this, Projects.class);
				projectList.putExtras(userData);
				startActivity(projectList);
			}
		});
    }
}