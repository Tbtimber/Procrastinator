package com.procrastinator.isen.procrastinator.ui.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.procrastinator.isen.procrastinator.R;
import com.procrastinator.isen.procrastinator.adapters.GridViewAdapter;
import com.procrastinator.isen.procrastinator.imdbRetrieval.GetSearchResultsAsync;
import com.procrastinator.isen.procrastinator.imdbRetrieval.SearchResult;
import com.procrastinator.isen.procrastinator.interfaces.ResultListener;
import com.procrastinator.isen.procrastinator.interfaces.SelectionListener;

import java.util.List;

/**
 * Created by Matthieu on 21/01/2016.
 */
public class ResultFragment extends android.support.v4.app.Fragment implements SelectionListener {
    private String resultString;
    private GridView mGridView;
    @Override
    public void onSelectionRetrieved(List<SearchResult> results) {
        GridViewAdapter adapter = new GridViewAdapter(getActivity(), results);
        mGridView.setAdapter(adapter);
    }

    private GetSearchResultsAsync mAsyncTask;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }



    @Override
    public void onStart() {
        super.onStart();
        mAsyncTask = new GetSearchResultsAsync(this);
        mAsyncTask.execute(resultString);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_result, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.result_grid_view);
        final ProgressBar progressBar = new ProgressBar(getActivity());
        progressBar.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        mGridView.setEmptyView(progressBar);
        return rootView;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }
}
