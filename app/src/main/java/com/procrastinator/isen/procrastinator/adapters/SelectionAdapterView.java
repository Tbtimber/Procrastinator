package com.procrastinator.isen.procrastinator.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.procrastinator.isen.procrastinator.MainActivity;
import com.procrastinator.isen.procrastinator.ProcrastinatorApplication;
import com.procrastinator.isen.procrastinator.R;
import com.procrastinator.isen.procrastinator.pojo.Movie;

import java.util.List;

/**
 * Created by Matthieu on 21/01/2016.
 */
public class SelectionAdapterView extends RecyclerView.Adapter<SelectionAdapterView.ViewHolder> {
    @Override
    public SelectionAdapterView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.selection_layout, parent, false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(mMovies.get(position).title);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    private List<Movie> mMovies;
    private LayoutInflater mInflater;

    public SelectionAdapterView(Context context, List<Movie> movies) {
        mMovies = movies;
        mInflater = LayoutInflater.from(context);
    }



    public class ViewHolder  extends RecyclerView.ViewHolder{
        public TextView title;

        public ViewHolder(View view) {
            super(view);
            this.title = (TextView) view.findViewById(R.id.poster_title);
        }
    }
}
