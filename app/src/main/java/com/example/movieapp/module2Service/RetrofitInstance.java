package com.example.movieapp.module2Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit = null;
    private static String Base_URL = "https://api.themoviedb.org/3/";

    public static MovieAPIService getService(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieAPIService.class);
    }
}
