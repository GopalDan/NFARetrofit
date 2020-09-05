package com.example.gopal.nfaretrofit;

import com.example.gopal.nfaretrofit.pojo.Event;
import com.example.gopal.nfaretrofit.pojo.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Gopal on 7/5/2019.
 */

public interface ApiInterface {
    @GET("search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline")
    Call<List<Event>> getListOfEvent();

    @GET("search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline")
    Call<Movie> getSingleEvent();

    @GET("search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline")
    Call<Response> getResponseOne();

    @GET("search?&api-key=d71aed14-2fe8-42ca-b962-a9c3794f5049&show-fields=thumbnail,byline")
    Call<Event> getEvent();

    @GET
    Call<Event> getEventByType(@Url String urlAsString);

}
