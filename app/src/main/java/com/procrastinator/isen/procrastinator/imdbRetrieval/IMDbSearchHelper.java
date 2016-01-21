package com.procrastinator.isen.procrastinator.imdbRetrieval;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tristan on 1/21/2016.
 */
public class IMDbSearchHelper {

    static final String API_URL = "http://www.omdbapi.com/?";

    public static List<SearchResult> getSearchResultsByTitle(String title) {
        String results = "";
        List<SearchResult> resultList = new ArrayList<>();
        HttpURLConnection urlConnection= getHttpURLConnection(API_URL + "s=" + title);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            results = stringBuilder.toString();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            JSONObject jo = new JSONObject(results);
            JSONArray ja = jo.getJSONArray("Search");
            for (int i = 0; i < ja.length(); i++){
                String specificTitle = ((JSONObject)ja.get(i)).getString("Title");
                resultList.add(getDetailedSearchResult(specificTitle));
            }
            int i = 2 + 3;
            String s = String.valueOf(i);
            return resultList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SearchResult getDetailedSearchResult(String title) {
        String result = "";
        title = title.replace(" ", "+");
        HttpURLConnection urlConnection = getHttpURLConnection(API_URL + "t=" + title);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            result = stringBuilder.toString();
        } catch (IOException e){
            e.printStackTrace();
        }
        try {
            JSONObject jo = new JSONObject(result);
            return new Gson().fromJson(jo.toString(), SearchResult.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpURLConnection getHttpURLConnection(String urlString) {

        try {
            URL url = new URL(urlString);
            return (HttpURLConnection) url.openConnection();
        }
        catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
    public static Bitmap getSearchResultImage(String imageUrl) throws Exception {
        final HttpURLConnection connection = getHttpURLConnection(imageUrl);
        final int responseCode = connection.getResponseCode();

        // If success
        if (responseCode == 200) {
            final Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            return bitmap;
        }
        return null;
    }
}