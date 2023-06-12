package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//hilt android entry point for singleton communicating between activities
@AndroidEntryPoint
public class countAuto extends AppCompatActivity {
    //inject the list of watches into activity
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_auto);
    }

    public void autoWatches (View view)
    {
        //declare variables
        TextView tv = findViewById(R.id.text_main);

        int count =0;
        //empty textview
        tv.setText("");

        //loop through list and check if the movement of each watch if it is automatic using the "equals" method of String
        for (int j = 0; j < the_list.size();j++)
        {
            if (the_list.get(j).getMovement().equals("automatic"))
            {
                count++;
            }

        }
        //display number of automatic watches
        tv.append("Number of Automatic Watches: " + count);
    }
}