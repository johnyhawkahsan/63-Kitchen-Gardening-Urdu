package com.johnyhawkdesigns.a63_kitchen_gardening_urdu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Splash extends AppCompatActivity {

    SharedPreferences prefs = null;
    View parentLayout;
    String TAG = Splash.class.getName();

    /** Duration of wait **/
    private final int secondsDelayed = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        parentLayout = findViewById(R.id.layoutSplash);

        prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);


    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false using the following line to edit/commit prefs
            prefs.edit().putBoolean("firstrun", false).apply();

            Log.d(TAG, "app first run ");
            Snackbar.make(parentLayout, "First app run", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

            // run first time app intro here
            Intent intent = new Intent(this, MyCustomAppIntro.class);
            startActivity(intent);

        } else {


            Log.d(TAG, "app second run ");

            // run main activity here
            new Handler().postDelayed(new Runnable(){ // New Handler to start the Main-Activity and close this Splash-Screen after some seconds.
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                }
            },secondsDelayed * 1000);
        }
    }
}