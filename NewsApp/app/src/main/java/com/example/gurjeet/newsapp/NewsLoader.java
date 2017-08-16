package com.example.gurjeet.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Gurjeet on 11-Feb-17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>>  {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    NewsLoader(Context c,String url){
        super(c);
        mUrl=url;
    }
    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"StartLoading()");
        forceLoad();
    }
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        Log.i(LOG_TAG,"loadInBackground()");
        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
