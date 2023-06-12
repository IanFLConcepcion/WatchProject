package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//hilt android entrypoint for singleton to communicate to this activity
@AndroidEntryPoint
public class findBrand extends AppCompatActivity {
    //inject singleton list of watches into activity
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_brand);
    }
    public void sortBrand (View view)
    {
        //prepare app's GUI set TextView and EditText
        TextView tv = findViewById(R.id.text_main);
        EditText et = findViewById(R.id.edit_serial);
        //Empty textview contents
        tv.setText("");
        //
        //give the user's input in the edit text a String variable
        String userBrand = et.getText().toString();


        //loop through list
        for (int j = 0; j < the_list.size();j++)
        {
            //if user's input is equal to the brand of the watch retrieve the watch information
            if (userBrand.equals(the_list.get(j).getBrand()))
            {
                tv.append(the_list.get(j).allBrand());
            }
        }


    }

}