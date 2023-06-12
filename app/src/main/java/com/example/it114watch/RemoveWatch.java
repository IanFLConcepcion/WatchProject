package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//hilt android entry point for singleton
@AndroidEntryPoint

public class RemoveWatch extends AppCompatActivity {
    //inject singleton list of watches into activity
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_watch);
    }

    public void removeWatchSerial (View view)
    {
        //establish GUI TextView and EditText connect them to xml
        TextView tv = findViewById(R.id.text_main);
        EditText et = findViewById(R.id.edit_removeSerial);
        //counter used to count number of removals made
        int count = 0;
        //take user input from EditText
        String userSerial = et.getText().toString();
        //loop through list
        for (int j = 0; j < the_list.size();j++)
        {
            //if user given serial is "equal" to the serial number of the watch append it to TextView
            if (userSerial.equals(the_list.get(j).getSerial()))
            {
                the_list.remove(the_list.get(j));
                count++;
            }

        }
        //if counter does not go up this means no removal was made and it can display error
        if (count == 0)
        {
            tv.append("Error: Watch Not Found");
        }
    }
}