package com.procrastinator.isen.procrastinator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.procrastinator.isen.procrastinator.ui.fragments.ResultFragment;


/**
 * Created by Matthieu on 14/01/2016.
 */
public class Result_Activity extends AppCompatActivity {
    private ResultFragment mFragResult;
    private String searchString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        searchString = getIntent().getExtras().getString("searchString");

        mFragResult = new ResultFragment();
        mFragResult.setResultString(searchString);

        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.content_results, mFragResult, "frag_selected");
        transaction.commit();

    }
}
//TODO bug with search bar (cant modify the text) in both MainActiity and ResultActivity