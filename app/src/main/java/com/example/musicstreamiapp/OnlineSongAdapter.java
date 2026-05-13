package com.example.musicstreamiapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class OnlineSongAdapter
        extends RecyclerView.Adapter<OnlineSongAdapter.ViewHolder> {

    Context context;

    ArrayList<OnlineSong> songs;

    public OnlineSongAdapter(Context context,
                             ArrayList<OnlineSong> songs) {

        this.context = context;

        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.song_item,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        OnlineSong song = songs.get(position);

        holder.songName.setText(song.getName());

        holder.artistName.setText(
                song.getArtist_name()
        );

        Glide.with(context)
                .load(song.getImage())
                .into(holder.songImage);

        holder.itemView.setOnClickListener(v -> {

            Intent intent =
                    new Intent(context,
                            PlayerActivity.class);

            intent.putExtra(
                    "songs",
                    songs
            );

            intent.putExtra(
                    "position",
                    position
            );

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {

        return songs.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView songName, artistName;

        ImageView songImage;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            songName =
                    itemView.findViewById(R.id.songName);

            artistName =
                    itemView.findViewById(R.id.artistName);

            songImage =
                    itemView.findViewById(R.id.songImage);
        }
    }
}