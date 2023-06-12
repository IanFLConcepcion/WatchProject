package com.example.it114watch;
import android.app.Application;
import dagger.hilt.android.HiltAndroidApp;
import com.facebook.drawee.backends.pipeline.Fresco;
//establish hilt myapplication
@HiltAndroidApp
public class MyApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        //establish drawee for displaying watch images later
        Fresco.initialize(this);
    }
}
