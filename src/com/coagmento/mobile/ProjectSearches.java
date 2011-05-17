package com.coagmento.mobile;


import java.util.LinkedList;

import com.coagmento.parsers.SearchDataSet;
import com.coagmento.parsers.SearchParser;
import com.coagmento.parsers.SnippetDataSet;
import com.coagmento.parsers.SnippetParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectSearches extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searches);
        
        Bundle appData = this.getIntent().getExtras();
        
        SearchParser parser = new SearchParser();
        LinkedList<SearchDataSet> searches = parser.parseSearches(appData.getInt("userID"),appData.getInt("projID"));
        
        TableLayout snipTable = (TableLayout) findViewById(R.id.searchListTable);

        /*
        System.out.println();
        
        for (SearchDataSet search : searches) {
        	Button b = new Button(this);
        	
        	//
        	String test = search.getQuery();
        	System.out.println(test);
        	
        	b.setText(search.getQuery());
        	b.setTag(search);
        	
        	snipTable.addView(b);
        }*/

    }
}