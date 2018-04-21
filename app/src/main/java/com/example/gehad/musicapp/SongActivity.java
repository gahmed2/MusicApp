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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.each_song_info);

        //Restoring data from bundle
        Intent songIntent = getIntent();
        final Bundle bundle = songIntent.getExtras();
        String songTitle = bundle.getString(Keys.TITLE_KEY);
        String songArtist = bundle.getString(Keys.ARTIST_KEY);
        int songImageId = bundle.getInt(Keys.IMAGE_KEY);

        //Assign values to each view in each_song_info.xml
        ImageView eachSongImage = findViewById(R.id.eachSongImage);
        eachSongImage.setImageResource(songImageId);

        TextView eachSongTitle = findViewById(R.id.eachSongName);
        eachSongTitle.setText(songTitle);

        TextView eachSongArtist = findViewById(R.id.eachSongArtist);
        eachSongArtist.setText(songArtist);

        /*
         * on click listener to navigate back to the main playlist "Home"
         */
        Button home = findViewById(R.id.homeButton);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(SongActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
