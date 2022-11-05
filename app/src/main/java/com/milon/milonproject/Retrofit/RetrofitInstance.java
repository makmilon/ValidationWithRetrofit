package com.milon.milonproject.Retrofit;


import com.milon.milonproject.Interface.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URL="https://api.themoviedb.org/3/movie/";

   public static RetrofitInstance instance;
  public RetrofitInterface apiInterface;

    RetrofitInstance(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        apiInterface= retrofit.create(RetrofitInterface.class);
    }


    public static RetrofitInstance getInstance(){
          if (instance==null){
              instance= new RetrofitInstance();
          }
          return instance;
    }


}
