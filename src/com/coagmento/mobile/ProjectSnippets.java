package com.coagmento.mobile;



import java.util.LinkedList;

import com.coagmento.parsers.BookmarkDataSet;
import com.coagmento.parsers.BookmarkParser;
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

public class ProjectSnippets extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snips);
        
        Bundle appData = this.getIntent().getExtras();
        
        SnippetParser parser = new SnippetParser();
        LinkedList<SnippetDataSet> snippets = parser.parseSnippets(appData.getInt("projID"));
        
        TableLayout snipTable = (TableLayout) findViewById(R.id.snipListTable);
        
        for (SnippetDataSet snip : snippets) {
        	Button b = new Button(this);
        	b.setText(snip.getTitle());
        	
        	snipTable.addView(b);
        }
    }

}