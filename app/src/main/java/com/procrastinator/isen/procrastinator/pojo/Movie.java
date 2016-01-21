package com.procrastinator.isen.procrastinator.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthieu on 21/01/2016.
 */
public class Movie {
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
    public double metascore;

    @SerializedName("imdbRating")
    public double rating;

    @SerializedName("imdbVotes")
    public long numVotes;

    @SerializedName("imdbID")
    public String id;

    @SerializedName("Type")
    public String resultType;

    @SerializedName("Response")
    public boolean response;

}
