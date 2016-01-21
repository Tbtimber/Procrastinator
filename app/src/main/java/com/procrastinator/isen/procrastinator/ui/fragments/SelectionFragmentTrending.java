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
public class SelectionFragmentTrending extends android.support.v4.app.Fragment {
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
        View rootView = inflater.inflate(R.layout.fragment_selection_trending, container, false);

        List<Movie> ms= new ArrayList<>();
        for(int i=0; i< 10;i++) {
            Movie m = new Movie();
            m.title = "Titre" + Integer.toString(i);
            ms.add(m);
        }

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(ProcrastinatorApplication.getContext(), LinearLayoutManager.HORIZONTAL, false);
        mTrendingView = (RecyclerView) rootView.findViewById(R.id.selectionTrendingListView);
        mTrendingView.setLayoutManager(layoutManager2);
        final SelectionAdapterView adapterView = new SelectionAdapterView(getActivity(), ms);
        mTrendingView.setAdapter(adapterView);



        return rootView;
    }
}
