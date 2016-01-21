package com.procrastinator.isen.procrastinator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.procrastinator.isen.procrastinator.imdbRetrieval.DownloadImageAsyncTask;
import com.procrastinator.isen.procrastinator.imdbRetrieval.GetSearchResultsAsync;
import com.procrastinator.isen.procrastinator.imdbRetrieval.IMDbSearchHelper;
import com.procrastinator.isen.procrastinator.imdbRetrieval.ImageMemoryCache;

public class MainActivity extends AppCompatActivity {

    public static ImageView imageView;
    public static ImageMemoryCache mImageMemoryCache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Instantiate our cache
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 16;
        mImageMemoryCache = new ImageMemoryCache(cacheSize);

        imageView = (ImageView) findViewById(R.id.image);
        DownloadImageAsyncTask getImageAsync = new DownloadImageAsyncTask(imageView,mImageMemoryCache);
        getImageAsync.execute("http://ia.media-imdb.com/images/M/MV5BNjg3NjMxNTY0MF5BMl5BanBnXkFtZTcwMzM5NTUyMQ@@._V1_SX300.jpg");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
