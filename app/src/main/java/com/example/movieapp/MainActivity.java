package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.os.Bundle;

import com.example.movieapp.databinding.ActivityMainBinding;
import com.example.movieapp.module1.Movie;
import com.example.movieapp.view.Adapter;
import com.example.movieapp.viewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<Movie> movies;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class); //provides and instance of the class.
        getPopularMovies();

        swipeRefreshLayout = mainBinding.swipe;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });
    }

    private void getPopularMovies() {
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movie) {
                movies = (ArrayList<Movie>) movie;
                displayMovies();

            }

            private void displayMovies() {

                recyclerView = mainBinding.Rv;
                adapter = new Adapter(movies, getApplicationContext());

                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);

                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                adapter.notifyDataSetChanged();

            }
        });
    }
}