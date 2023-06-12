package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

//hilt android entrypoint for singleton
@AndroidEntryPoint
public class findWatch extends AppCompatActivity {
    //inject the singleton list of watches into this activity
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_watch);
    }

    public void displaySerial (View view)
    {
        //establish TextView and EditText to xml
        TextView tv = findViewById(R.id.text_main);
        EditText et = findViewById(R.id.edit_serial);

        //get user input from the EditText
        String userSerial = et.getText().toString();

        //loop through the list
        for (int j = 0; j < the_list.size();j++)
        {
            //if serial # given by the user = the watch's serial # output the watch
            if (userSerial.equals(the_list.get(j).getSerial()))
            {
                tv.setText("");
                tv.append(the_list.get(j).serialOutput());
                Uri uri = Uri.parse(the_list.get(j).getImageURL());
                SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image_area);
                draweeView.setImageURI(uri);

            }
        }
    }
}