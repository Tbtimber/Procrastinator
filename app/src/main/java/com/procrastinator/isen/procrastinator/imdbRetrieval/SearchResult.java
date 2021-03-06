package com.procrastinator.isen.procrastinator.imdbRetrieval;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Streams;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Created by Tristan on 1/21/2016.
 */

public class SearchResult {
    @SerializedName("Title")
    public String title;

    @SerializedName("Year")
    public String year;

    @SerializedName("Rated")
    public String rated;

    @SerializedName("Released")
    public String released;

    @SerializedName("Runtime")
    public String runtime;

    @SerializedName("Genre")
    public String genre;

    @SerializedName("Director")
    public String director;

    @SerializedName("Writer")
    public String writer;

    @SerializedName("Actors")
    public String arctors;

    @SerializedName("Plot")
    public String plot;

    @SerializedName("Language")
    public String language;

    @SerializedName("Country")
    public String country;

    @SerializedName("Awards")
    public String awards;

    @SerializedName("Poster")
    public String posterURL;

    @SerializedName("Metascore")
    public String metascore;

    @SerializedName("imdbRating")
    public String rating;

    @SerializedName("imdbVotes")
    public String numVotes;

    @SerializedName("imdbID")
    public String id;

    @SerializedName("Type")
    public String resultType;

    @SerializedName("Response")
    public boolean response;

    public long getDateCreatedTimestamp() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);
        dateFormat.setLenient(false);
        try {
            final Date created = dateFormat.parse(released);
            return created.getTime();
        } catch (Exception e) {
            return 0;
        }
    }
}