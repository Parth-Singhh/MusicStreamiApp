package com.example.musicstreamiapp;

import java.io.Serializable;

public class OnlineSong implements Serializable {

    private String name;
    private String artist_name;
    private String audio;
    private String image;

    public OnlineSong(String name,
                      String artist_name,
                      String audio,
                      String image) {

        this.name = name;
        this.artist_name = artist_name;
        this.audio = audio;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public String getAudio() {
        return audio;
    }

    public String getImage() {
        return image;
    }
}