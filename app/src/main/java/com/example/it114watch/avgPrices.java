package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//android entry point for hilt/singleton
@AndroidEntryPoint
public class avgPrices extends AppCompatActivity {
    //inject the singleton list of watches
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avg_prices);
    }
    
    public void averageWatchPrice (View view)
    {
        //declare + prep variables for use
        int i;
        TextView tv = findViewById(R.id.text_main);
        double listTotal = 0.00;
        double avgPrice;

        //loop through the list and get the price of each watch and total them up
        for (i=0; i<the_list.size();i++)
        {
            listTotal += the_list.get(i).getPrice();
        }
        //divide the total price after the loop by the size of the list
        avgPrice = listTotal/the_list.size();


        //display the double in money format
        tv.append("Average Price: "+"$"+String.format("%.2f",avgPrice));




    }
}