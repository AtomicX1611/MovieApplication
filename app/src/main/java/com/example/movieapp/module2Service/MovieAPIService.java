package com.example.movieapp.module2Service;

import com.example.movieapp.module1.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPIService {
            // This is mostly for passing the Query to the web server.
    @GET("movie/popular")
    Call<Result> getAllPopularMovies(@Query("api_key") String apiKey);
}
