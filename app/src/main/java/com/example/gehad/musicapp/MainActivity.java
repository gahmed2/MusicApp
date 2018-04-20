/*
 * PROJECT LICENSE
 *
 * This project was submitted by Gehad Ahmed as part of the Nanodegree At Udacity.
 *
 * As part of Udacity Honor code, your submissions must be your own work, hence
 * submitting this project as yours will cause you to break the Udacity Honor Code and the suspension of your account.
 *
 * Me, the author of the project, allow you to check the code as a reference, but if you submit it, it's your own responsibility if you get expelled.
 *
 * Copyright (c) 2018 Gehad Ahmed
 *
 * Besides the above notice, the following license applies and this license notice must be included in all works derived from this project.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.example.gehad.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This app is inspired from "FlavorAdapter" app created by Google team for demonstrating
 * custom Adapter for ListView.
 * Also, it's inspired from "EscaperPlaylist" app created by "Melsara"
 * from our great community, and thanks for her for helping me to implement
 * "setOnItemClickListener".
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         * Set the content of the activity to use the activity_main.xml layout file
         */
        setContentView(R.layout.activity_main);

        ListView songs = findViewById(R.id.rootLayout);

        /*
         * Define ArrayList
         */
        ArrayList<Song> allSongs = new ArrayList<>();
        allSongs.add(new Song(getString(R.string.label_Title) + ' ' + getString(R.string.song1_Title),
                getString(R.string.label_Artist) + ' ' + getString(R.string.song1_Artist), R.drawable.yanni1));
        allSongs.add(new Song(getString(R.string.label_Title) + ' ' + getString(R.string.song2_Title),
                getString(R.string.label_Artist) + ' ' + getString(R.string.song2_Artist), R.drawable.yanni2));
        allSongs.add(new Song(getString(R.string.label_Title) + ' ' + getString(R.string.song3_Title),
                getString(R.string.label_Artist) + ' ' + getString(R.string.song3_Artist), R.drawable.yanni3));
        allSongs.add(new Song(getString(R.string.label_Title) + ' ' + getString(R.string.song4_Title),
                getString(R.string.label_Artist) + ' ' + getString(R.string.song4_Artist), R.drawable.yanni4));
        allSongs.add(new Song(getString(R.string.label_Title) + ' ' + getString(R.string.song5_Title),
                getString(R.string.label_Artist) + ' ' + getString(R.string.song5_Artist), R.drawable.yanni5));

        /*
         * Create an allSongsAdapter, whose data source is a list of
         * {Song}s. The adapter knows how to create list item views for each item
         * in the list.
         */
        SongAdapter allSongsAdapter = new SongAdapter(this, allSongs);

        /*
         * Get a reference to the ListView, and attach the adapter to the listView.
         */
        songs.setAdapter(allSongsAdapter);

        /*
         * Define On Item Click Listener to display the clickable song details
         * in a separate activity
         */
        songs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = (Song) adapterView.getItemAtPosition(i);
                String songTitle = song.getSongTitle();
                String songArtist = song.getSongArtist();
                int songImageId = song.getImageResourceId();

                // Create a new intent to open the SongActivity
                Intent songIntent = new Intent(MainActivity.this, SongActivity.class);

                //Store the values in a Bundle
                Bundle bundle = new Bundle();
                bundle.putString(Keys.TITLE_KEY, songTitle);
                bundle.putString(Keys.ARTIST_KEY, songArtist);
                bundle.putInt(Keys.IMAGE_KEY, songImageId);
                songIntent.putExtras(bundle);

                // Start the new activity
                startActivity(songIntent);
            }
        });
    }
}
