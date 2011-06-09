package com.coagmento.mobile;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProjectNotes extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes);
        
        final Bundle appData = this.getIntent().getExtras();
        
        //Set up button to go back to home
        Button homeButton = (Button) findViewById(R.id.noteshomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent backToHome = new Intent(ProjectNotes.this, Home.class);
				backToHome.putExtras(appData);
				backToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(backToHome);
			}
		});
    }

}