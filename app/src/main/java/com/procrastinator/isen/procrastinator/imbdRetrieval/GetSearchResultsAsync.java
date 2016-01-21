package com.procrastinator.isen.procrastinator.imdbRetrieval;

import android.os.AsyncTask;

/**
 * Created by Tristan on 1/21/2016.
 */
public class GetSearchResultsAsync extends AsyncTask {
    @Override
    protected Object doInBackground(Object[] params) {
        return IMDbSearchHelper.getSearchResultsByTitle(params[0].toString());
    }
}