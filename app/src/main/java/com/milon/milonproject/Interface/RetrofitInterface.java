package com.milon.milonproject.Interface;

import com.milon.milonproject.Model.MainDataClass;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("top_rated")
    Call<MainDataClass> getData(@Query("api_key") String token);

}
