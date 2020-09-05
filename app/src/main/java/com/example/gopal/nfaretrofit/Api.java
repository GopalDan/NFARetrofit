package com.example.gopal.nfaretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gopal on 7/5/2019.
 */

public class Api {
    public static Retrofit retrofit = null;
    public static String BASE_URL = "https://content.guardianapis.com/";
    public static ApiInterface getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return  apiInterface;
    }
}
