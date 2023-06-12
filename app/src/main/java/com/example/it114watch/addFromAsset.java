package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//android entry point for singleton
@AndroidEntryPoint
public class addFromAsset extends AppCompatActivity {

    //inject the singleton list of watches into activity
    @Inject
    WatchList the_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_from_asset);
    }

    public void addWatch (View view)  {

        // prepare edit text and textview
        TextView tv = findViewById(R.id.text_main);
        EditText et = findViewById(R.id.edit_asset);

        //implement try catch for File Input

        try {

            //get file name from user
            String filename = et.getText().toString();
            //scanner to look at file
            AssetManager assetManager = getAssets();
            Scanner fsc = new Scanner(assetManager.open(filename));

            //new watch object to be displayed
            Watch newWatch = new Watch();

            //count for while loop
            int count = 0;
            //read through the asset file and add attributes
            while (fsc.hasNextLine()) {
                the_list.add(the_list.size(), newWatch);
                the_list.get(the_list.size() - 1).setBrand(fsc.nextLine());
                the_list.get(the_list.size() - 1).setSerial(fsc.nextLine());
                the_list.get(the_list.size() - 1).setMovement(fsc.nextLine());
                the_list.get(the_list.size() - 1).setWaterRes(fsc.nextInt());
                fsc.nextLine();
                the_list.get(the_list.size() - 1).setManufactureYr(fsc.nextInt());
                fsc.nextLine();
                the_list.get(the_list.size() - 1).setPrice(fsc.nextDouble());
                fsc.nextLine();
                the_list.get(the_list.size() - 1).setImageURL(fsc.next());

                tv.append("Watch Appended");
            }

        }
        //file not found error
        catch (FileNotFoundException e)
        {
            tv.append("File Not Found: Please Enter a Valid File Name");

        }
        //input / output error
        catch (IOException e) {
            tv.append("Error Retrieving File Input");

        }


    }
}