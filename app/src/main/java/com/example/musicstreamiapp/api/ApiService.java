package com.example.musicstreamiapp.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tracks/?client_id=c11fe4ca&format=json&limit=20")
    Call<JamendoResponse> getSongs();
}