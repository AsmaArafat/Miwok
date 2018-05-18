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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "الى اين انت ذاهب؟"));
        words.add(new Word("What is your name?", "ما هو اسمك؟"));
        words.add(new Word("My name is...", "اسمي يكون...."));
        words.add(new Word("How are you feeling?", "كيف هو شعورك؟"));
        words.add(new Word("I’m feeling good.", "انا اشعر اني كويس."));
        words.add(new Word("Are you coming?", "هل انت قادم؟"));
        words.add(new Word("Yes, I’m coming.", "نعم انا قادم."));
        words.add(new Word("I’m coming.", "انا قادم."));
        words.add(new Word("Let’s go.", "هيا بنا نذهب."));
        words.add(new Word("Come here.", "تعالا هنا."));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
