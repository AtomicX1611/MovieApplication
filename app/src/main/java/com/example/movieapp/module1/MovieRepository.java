package com.example.movieapp.module1;


import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import com.example.movieapp.module2Service.MovieAPIService;
import com.example.movieapp.module2Service.RetrofitInstance;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    // A place where all the data in your app flows , and its well organized
    // to avoid inconsistency.

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieAPIService movieAPIService = RetrofitInstance.getService();
        Call<Result> call = movieAPIService.getAllPopularMovies(application.
                getApplicationContext().getString(com.example.movieapp.R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body(); //New concept.
                if(result!=null && result.getResults()!=null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);

                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(), "Call failed", Toast.LENGTH_SHORT).show();            }
        });
          return  mutableLiveData;
    }
}
