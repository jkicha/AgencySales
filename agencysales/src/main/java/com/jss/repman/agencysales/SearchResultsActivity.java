package com.jss.repman.agencysales;

import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class SearchResultsActivity extends Activity {

    private TextView txtQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        // get the action bar
        ActionBar actionBar = getActionBar();

        // Enabling back navigation on action bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        txtQuery = (TextView) findViewById(R.id.txtQuery);
        if (txtQuery != null)
        {
            Log.i("agency", "txtQuery is not null");
        } else {
            Log.i("agency", "txtQuery is null");
        }
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            txtQuery.setText("Search query " + query);
        }
    }

}
