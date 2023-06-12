package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.facebook.drawee.view.SimpleDraweeView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//hilt android entrypoint for singleton
@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    //inject singleton list of watches into activity
    @Inject
    WatchList the_list; //reference to singleton
    // create Textview variable
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        tv = findViewById(R.id.text_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onOption1(MenuItem item) throws java.io.IOException {
        tv = findViewById(R.id.text_main);

        //display watches in list
        // j is a counter for loop
        int j = 0;
        //empty set text
        tv.setText("");
        //loop through list and display watches in TextView
        for (j = 0; j < the_list.size(); j++) {
            tv.append(the_list.get(j).toString());

        }

    }

    public void onOption2(MenuItem i) {
        startActivity(new Intent(this, loadWatches.class));
        //loads the list of watches to then be displayed for option 1
    }

    public void onOption3(MenuItem item) {
        //asset file add watch to end of list
        startActivity(new Intent(this, addFromAsset.class));
    }

    public void onOption4(MenuItem item) {
        //display from serial number
        startActivity(new Intent(this, findWatch.class));
    }

    public void onOption5(MenuItem item) {
        //remove watch with given serial number
        startActivity(new Intent(this, RemoveWatch.class));
    }

    public void onOption6(MenuItem item) {
        //new activity to average prices of all watches in list
        startActivity(new Intent(this, avgPrices.class));
    }

    public void onOption7 (MenuItem item)
    {
        //activity to calculate amount of automatic watches
        startActivity(new Intent(this, countAuto.class));
    }

    public void onOption8 (MenuItem i)
    {
        //display all with user given brand
        startActivity(new Intent(this , findBrand.class));
    }



}