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

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    SongAdapter(Activity context, ArrayList<Song> allSongs) {
        super(context, 0, allSongs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*
          Check if the existing view is being reused, otherwise inflate the view
         */
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_info_list, parent, false);
        }

        /*
         * Get the object located at this position in the list
         */
        Song currentSong = getItem(position);

        /*
         * Find the TextView in the song_info_list.xml layout with the ID songName
         */
        TextView titleTextView = listItemView.findViewById(R.id.songName);
        /*
         * Get the song title from the current Song object and
         * set this text on the title TextView
         */
        titleTextView.setText(currentSong.getSongTitle());

        /*
         * Find the TextView in the song_info_list.xml layout with the ID songArtist
         */
        TextView artistTextView = listItemView.findViewById(R.id.songArtist);
        /*
         * Get the song artist from the current Song object and
         * set this text on the artist TextView
         */
        artistTextView.setText(currentSong.getSongArtist());

        /*
         * Find the ImageView in the song_info_list.xml layout with the ID songImage
         */
        ImageView songImageView = listItemView.findViewById(R.id.songImage);
        /*
         * Get the image resource ID from the current Song object and
         * set the image to songImageView
         */
        songImageView.setImageResource(currentSong.getImageResourceId());

        /*
         * Return the whole list item layout (containing 2 TextViews and an ImageView)
         * so that it can be shown in the ListView
         */
        return listItemView;
    }
}
