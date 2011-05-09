package com.coagmento.mobile;


import com.coagmento.parsers.ProjectDataParser;
import com.coagmento.parsers.ProjectDataSet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectItems extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.projectitems);
        
        final Bundle projData = this.getIntent().getExtras();
        
        int test = projData.getInt("projID");
        System.out.println(test);
        
        ProjectDataParser parser = new ProjectDataParser();
        ProjectDataSet projectDataList = parser.parseProjData(projData.getInt("projID"));

        	TextView bookmarks = (TextView) findViewById(R.id.numBookmarks);
            TextView notes = (TextView) findViewById(R.id.numNotes);
            TextView snippets = (TextView) findViewById(R.id.numSnippets);
            TextView searches = (TextView) findViewById(R.id.numSearches);

            bookmarks.append(" (" + projectDataList.getNumBookmarks() + ")");
            notes.append(" (" + projectDataList.getNumNotes() + ")");
            snippets.append(" (" + projectDataList.getNumSnippets() + ")");
            searches.append(" (" + projectDataList.getNumSearches() + ")");
    	        
        
        
        
        Button homeButton = (Button) findViewById(R.id.projitemshomeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "Not implemented yet", Toast.LENGTH_SHORT);
        		toast.show();
				//startActivity(new Intent(ProjectItems.this, Home.class));
			}
		});
		
        
        Button refreshButton = (Button) findViewById(R.id.projitemsRefreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast toast = Toast.makeText(getApplicationContext(), "Not implemented yet", Toast.LENGTH_SHORT);
        		toast.show();
			}
		});
 
    }

}