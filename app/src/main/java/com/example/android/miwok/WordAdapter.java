/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Context context, ArrayList<Word> words , int ColorResourceId) {
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);
// Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());
        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());
////////////
        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_image);// Get the Miwok translation from the currentWord object and set this text on
        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }
        //set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
         //find the color that resource id map to
        int color = ContextCompat.getColor(getContext() , mColorResourceId);
        //set the background color of the text container view
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

        Button button = (Button) listItemView.findViewById(R.id.play_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               MediaPlayer mp = null;
                if (mp != null) {
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                 mp = MediaPlayer.create(getContext(), R.raw.asma);
                mp.start();
            }
        });

        return listItemView;
    }
}