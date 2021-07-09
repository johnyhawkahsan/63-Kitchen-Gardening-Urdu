package com.johnyhawkdesigns.a63_kitchen_gardening_urdu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

import org.jetbrains.annotations.Nullable;


public class MyCustomAppIntro extends AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment

        addSlide(AppIntroFragment.newInstance(
                "Welcome",
                "Welcome to Kitchen Gardening Course in Urdu.",
                R.drawable.ic_kitchengardening_icon_svg_nobcg, // imageDrawable
                R.drawable.ic_appintro_fab_background // backgroundDrawable
        ));

        addSlide(AppIntroFragment.newInstance(
                "Start Gardening Today",
                "Custom made course to help you start gardening today.",
                R.drawable.pot_png_1,
                getResources().getColor(R.color.colorPrimary)

        ));

        addSlide(AppIntroFragment.newInstance(
                "Easy to understand",
                "First ever Urdu course made to learn basics of kitchen gardening which is very easy to understand.",
                R.drawable.pot_png_2,
                getResources().getColor(R.color.design_default_color_primary)
        ));

        //setTransformer(AppIntroPageTransformerType.Depth);
        //isColorTransitionsEnabled = true;
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Decide what to do when the user clicks on "Skip"

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //finish();
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Decide what to do when the user clicks on "Done"
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //finish();
    }
}
