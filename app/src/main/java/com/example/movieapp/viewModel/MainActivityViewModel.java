package com.example.movieapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieapp.module1.Movie;
import com.example.movieapp.module1.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

//ViewModel gathers all the data.
    //calling the repository from here.
    // The repository is basically linked to all the data.
    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }
    public LiveData<List<Movie>> getAllMovies(){

        return movieRepository.getMutableLiveData();
    }
}
