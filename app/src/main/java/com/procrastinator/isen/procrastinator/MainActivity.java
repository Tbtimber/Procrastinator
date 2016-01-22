package com.procrastinator.isen.procrastinator;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.procrastinator.isen.procrastinator.imdbRetrieval.SearchResult;
import com.procrastinator.isen.procrastinator.interfaces.MainActivityListener;
import com.procrastinator.isen.procrastinator.ui.fragments.SelectionFragment;
import com.procrastinator.isen.procrastinator.ui.fragments.SelectionFragmentTrending;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityListener, View.OnClickListener{

    private android.support.v4.app.Fragment selectionAdaptedFrag;
    private android.support.v4.app.Fragment selectionTrendingFrag;

    @Override
    public void printScreen(List<SearchResult> results) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar abar =  getSupportActionBar();
        abar.setDisplayShowTitleEnabled(false);
        abar.setDisplayUseLogoEnabled(false);
        abar.setDisplayHomeAsUpEnabled(false);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowHomeEnabled(false);

        ActionBar.LayoutParams lp1 = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View customNav = LayoutInflater.from(this).inflate(R.layout.search_test, null);

        abar.setCustomView(customNav);

        selectionAdaptedFrag = new SelectionFragment();
        selectionTrendingFrag = new SelectionFragmentTrending();
        if(savedInstanceState == null) {
            android.support.v4.app.FragmentManager manager = getSupportFragmentManager();

            android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

            transaction.add(R.id.selecteed_fragment_layout, selectionAdaptedFrag, "frag_selected");
            transaction.add(R.id.trending_fragment_layout, selectionTrendingFrag, "frag_trending");

            transaction.commit();
            //getFragmentManager().beginTransaction().add(R.id.selecteed_fragment_layout, selectionAdaptedFrag).commit();
            //getFragmentManager().beginTransaction().add(R.id.trending_fragment_layout, selectionTrendingFrag).commit();

        }




        Button b = (Button) findViewById(R.id.button_search);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Result_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("searchString",( (EditText) findViewById(R.id.editText_search)).getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Button b2 = (Button) findViewById(R.id.button_search_more);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailSearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


    }
}
