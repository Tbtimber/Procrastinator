
package com.procrastinator.isen.procrastinator.imdbRetrieval;

import android.os.AsyncTask;

import com.procrastinator.isen.procrastinator.interfaces.MainActivityListener;
import com.procrastinator.isen.procrastinator.interfaces.SelectionListener;

import java.util.List;

/**
 * Created by Tristan on 1/21/2016.
 */
public class GetSearchResultsAsync extends AsyncTask {
    private SelectionListener mListener;

    public GetSearchResultsAsync(SelectionListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<SearchResult> doInBackground(Object[] params) {
        return IMDbSearchHelper.getSearchResultsByTitle(params[0].toString());
    }



    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        mListener.onSelectionRetrieved((List<SearchResult>) o);
    }
}