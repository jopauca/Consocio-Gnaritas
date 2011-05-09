package com.coagmento.mobile;

import java.util.LinkedList;

import com.coagmento.parsers.ProjectListDataSet;
import com.coagmento.parsers.ProjectListParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class Projects extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projects);
        
        //Get bundle containing user name and ID
        final Bundle userData = this.getIntent().getExtras();
        
        //Parse data using userID from bundle
        ProjectListParser parser = new ProjectListParser();
        LinkedList<ProjectListDataSet> projectList = parser.parseProjectList(3);//(userData.getInt("userID")); 
        
        //Add buttons to table layout for each project
        TableLayout projectTable = (TableLayout) findViewById(R.id.projectsTable);
        if (projectList.isEmpty()) {
        	
        } else
        {
        	for (ProjectListDataSet proj : projectList) {
            	Button b = new Button(this);
            	b.setText(proj.getName());
            	b.setTag(proj.getProjID()); //Tag allows us to pass data to inner methods (e.g. click listener)
            	b.setOnClickListener(new View.OnClickListener() {
    				
            		//Define click listeners for each button
    				@Override
    				public void onClick(View v) {
    					
    					//Create bundle containing project ID and then go to project items page
    					Bundle projData = new Bundle();
			        	projData.putInt("projID", Integer.parseInt(v.getTag().toString()));
			        	
			        	int test = Integer.parseInt(v.getTag().toString());
			        	
    			    	Intent elements = new Intent(Projects.this,ProjectItems.class);
    			    	elements.putExtras(projData);
    			    	startActivity(elements);
    				}
    			});
            	
            	projectTable.addView(b);
            }	
        }
        
        
        //Set up button to go back to home
        Button homeButton = (Button) findViewById(R.id.projecthomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "Not implemented yet", Toast.LENGTH_SHORT);
        		toast.show();
				//startActivity(new Intent(Projects.this, Home.class));
			}
		});
		
        
        //Set up button to refresh the list of projects
        Button refreshButton = (Button) findViewById(R.id.projectrefreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "Not implemented yet", Toast.LENGTH_SHORT);
        		toast.show();
			}
		});
 
    }

}