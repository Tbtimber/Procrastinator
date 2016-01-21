package com.procrastinator.isen.procrastinator.imdbRetrieval;

import android.os.AsyncTask;

import java.util.List;

/**
 * Created by Tristan on 1/21/2016.
 */
public class GetSearchResultsAsync extends AsyncTask<String, Void, List<SearchResult>> {
    @Override
    protected List<SearchResult> doInBackground(String... params) {
        return IMDbSearchHelper.getSearchResultsByTitle(params[0]);
    }

    protected void onPostExecute(List<SearchResult> result){
    }
}
