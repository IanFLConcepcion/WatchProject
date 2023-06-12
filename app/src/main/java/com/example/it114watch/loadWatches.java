package com.example.it114watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
//hilt android entrypoint for singleton
@AndroidEntryPoint
public class loadWatches extends AppCompatActivity {
    @Inject
    WatchList the_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_watches);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }
    public void loadWatch (View view)  {
        TextView tv = findViewById(R.id.text_main);
        EditText et = findViewById(R.id.edit_item);
        try {


            String userFile = et.getText().toString();
            int count = 0;

            URL file_url = new URL(userFile);
            Scanner fsc = new Scanner(file_url.openStream());

            while (the_list.size() > 0) {
                the_list.remove(0);
            }

            while (fsc.hasNext()) {
                the_list.add(the_list.size(), new Watch());
                the_list.get(count).setBrand(fsc.nextLine());
                the_list.get(count).setSerial(fsc.nextLine());
                the_list.get(count).setMovement(fsc.nextLine());
                the_list.get(count).setWaterRes(fsc.nextInt());
                the_list.get(count).setManufactureYr(fsc.nextInt());
                the_list.get(count).setPrice(fsc.nextDouble());
                fsc.nextLine();
                the_list.get(count).setImageURL(fsc.nextLine());


                count++;


            }
        } catch (MalformedURLException e) {
            tv.append("URL not Found or incorrect");
        } catch (IOException e) {
            tv.append("Input/Output Error");
        }


    }
}