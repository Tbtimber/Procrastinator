package com.procrastinator.isen.procrastinator.interfaces;

import com.procrastinator.isen.procrastinator.imdbRetrieval.SearchResult;

import java.util.List;

/**
 * Created by Matthieu on 21/01/2016.
 */
public interface MainActivityListener {
    void printScreen(List<SearchResult> results);
}
