package com.procrastinator.isen.procrastinator.ui.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.procrastinator.isen.procrastinator.ProcrastinatorApplication;
import com.procrastinator.isen.procrastinator.R;
import com.procrastinator.isen.procrastinator.adapters.SelectionAdapterView;
import com.procrastinator.isen.procrastinator.interfaces.MainActivityListener;
import com.procrastinator.isen.procrastinator.pojo.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthieu on 21/01/2016.
 */
public class SelectionFragment extends android.support.v4.app.Fragment {

    private RecyclerView mScrollView;
    private RecyclerView mTrendingView;

    private MainActivityListener mListener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivityListener) {
            mListener = (MainActivityListener) context;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_selection, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(ProcrastinatorApplication.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mScrollView = (RecyclerView) rootView.findViewById(R.id.selectionAdaptedListView);
        mScrollView.setLayoutManager(layoutManager);
        List<Movie> movieList= new ArrayList<>();
        for(int i=0; i< 10;i++) {
            Movie m = new Movie();
            m.title = "Titre" + Integer.toString(i);
            movieList.add(m);
        }
        final SelectionAdapterView adapter = new SelectionAdapterView(getActivity(),movieList);
        mScrollView.setAdapter(adapter);

        return rootView;
    }
}
