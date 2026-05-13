package com.example.musicstreamiapp;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    TextView songTitle, artistName;

    ImageView songImage;

    Button playBtn, nextBtn, prevBtn;

    ExoPlayer exoPlayer;

    ArrayList<OnlineSong> songs;

    int position;

    boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_player);

        songTitle = findViewById(R.id.songTitle);

        artistName = findViewById(R.id.artistName);

        songImage = findViewById(R.id.musicImage);

        playBtn = findViewById(R.id.playBtn);

        nextBtn = findViewById(R.id.nextBtn);

        prevBtn = findViewById(R.id.prevBtn);

        songs = (ArrayList<OnlineSong>)
                getIntent().getSerializableExtra("songs");

        position = getIntent().getIntExtra("position", 0);

        if (songs == null || songs.size() == 0) {

            Toast.makeText(
                    this,
                    "No songs found",
                    Toast.LENGTH_LONG
            ).show();

            finish();

            return;
        }

        playSong(position);

        playBtn.setOnClickListener(v -> {

            if (exoPlayer == null) return;

            if (isPlaying) {

                exoPlayer.pause();

                playBtn.setText("PLAY");

                isPlaying = false;

            } else {

                exoPlayer.play();

                playBtn.setText("PAUSE");

                isPlaying = true;
            }
        });

        nextBtn.setOnClickListener(v -> {

            position++;

            if (position >= songs.size()) {

                position = 0;
            }

            playSong(position);
        });

        prevBtn.setOnClickListener(v -> {

            position--;

            if (position < 0) {

                position = songs.size() - 1;
            }

            playSong(position);
        });
    }

    private void playSong(int pos) {

        try {

            if (exoPlayer != null) {

                exoPlayer.release();
            }

            OnlineSong song = songs.get(pos);

            songTitle.setText(song.getName());

            artistName.setText(song.getArtist_name());

            Glide.with(this)
                    .load(song.getImage())
                    .into(songImage);

            exoPlayer = new ExoPlayer.Builder(this).build();

            MediaItem mediaItem =
                    MediaItem.fromUri(
                            Uri.parse(song.getAudio())
                    );

            exoPlayer.setMediaItem(mediaItem);

            exoPlayer.prepare();

            exoPlayer.play();

            playBtn.setText("PAUSE");

            isPlaying = true;

        } catch (Exception e) {

            Toast.makeText(
                    this,
                    "Playback Error",
                    Toast.LENGTH_LONG
            ).show();

            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        if (exoPlayer != null) {

            exoPlayer.release();
        }
    }
}