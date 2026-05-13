package com.example.musicstreamiapp;
import java.util.ArrayList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicstreamiapp.api.ApiService;
import com.example.musicstreamiapp.api.JamendoResponse;
import com.example.musicstreamiapp.api.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        loadSongs();
    }

    private void loadSongs() {

        ApiService apiService =
                RetrofitClient
                        .getRetrofitInstance()
                        .create(ApiService.class);

        Call<JamendoResponse> call =
                apiService.getSongs();

        call.enqueue(new Callback<JamendoResponse>() {

            @Override
            public void onResponse(Call<JamendoResponse> call,
                                   Response<JamendoResponse> response) {

                if (response.isSuccessful()
                        && response.body() != null) {

                    ArrayList<OnlineSong> songs =
                            new ArrayList<>(response.body().getResults());

                    OnlineSongAdapter adapter =
                            new OnlineSongAdapter(
                                    MainActivity.this,
                                    songs
                            );

                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<JamendoResponse> call,
                                  Throwable t) {

                t.printStackTrace();
            }
        });
    }
}