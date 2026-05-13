package com.example.musicstreamiapp;

import java.io.Serializable;

public class SongModel implements Serializable {
    String title;
    String path;
    String artist;

    public SongModel(String title, String path, String artist) {
        this.title = title;
        this.path = path;
        this.artist = artist;
    }

    public String getTitle() { return title; }
    public String getPath() { return path; }
    public String getArtist() { return artist; }
}