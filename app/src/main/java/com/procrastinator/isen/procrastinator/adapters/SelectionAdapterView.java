package com.procrastinator.isen.procrastinator.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.procrastinator.isen.procrastinator.MainActivity;
import com.procrastinator.isen.procrastinator.ProcrastinatorApplication;
import com.procrastinator.isen.procrastinator.R;
import com.procrastinator.isen.procrastinator.imdbRetrieval.DownloadImageAsyncTask;
import com.procrastinator.isen.procrastinator.imdbRetrieval.ImageMemoryCache;
import com.procrastinator.isen.procrastinator.imdbRetrieval.SearchResult;
import com.procrastinator.isen.procrastinator.pojo.Movie;

import java.util.List;

/**
 * Created by Matthieu on 21/01/2016.
 */
public class SelectionAdapterView extends RecyclerView.Adapter<SelectionAdapterView.ViewHolder> {
    private ImageMemoryCache mMemoryCache;
    private List<SearchResult> mMovies;
    private LayoutInflater mInflater;
    @Override
    public SelectionAdapterView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.selection_layout, parent, false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SearchResult item = mMovies.get(position);

        final Bitmap bm = mMemoryCache.getBitmapFromMemCache(item.posterURL);
        if(null == bm) {
            new DownloadImageAsyncTask(holder.pic, mMemoryCache).execute(item.posterURL);
        } else {
            holder.pic.setImageBitmap(bm);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public SelectionAdapterView(Context context, List<SearchResult> movies) {
        mMovies = movies;
        mInflater = LayoutInflater.from(context);
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory())/1024;
        final int cacheSize = maxMemory/16;
        mMemoryCache = new ImageMemoryCache(cacheSize);
    }



    public class ViewHolder  extends RecyclerView.ViewHolder{
        public ImageView pic;
        public ViewHolder(View view) {
            super(view);
            this.pic = (ImageView) view.findViewById(R.id.poster);
        }
    }
}
