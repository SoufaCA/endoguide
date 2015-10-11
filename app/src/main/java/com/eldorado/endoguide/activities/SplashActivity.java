package com.eldorado.endoguide.activities;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.util.EGConstants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    private boolean skippedSplashScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!skippedSplashScreen) {
                    goToOnboardingActivity();
                }
            }
        }, EGConstants.SPLASH_DISPLAY_LENGTH);

        ImageView splashScreenImageView = (ImageView) findViewById(R.id.splashImageView);
        splashScreenImageView.setOnClickListener(splashScreenOnClickListener);

    }

    View.OnClickListener splashScreenOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            skippedSplashScreen = true;
            goToOnboardingActivity();
        }
    };

    protected void goToOnboardingActivity() {
        /* Create an Intent that will start the Menu-Activity. */
// Get the shared preferences
        SharedPreferences preferences = getSharedPreferences(EGConstants.PREF_FILE_NAME, MODE_PRIVATE);

// Check if onboarding_complete is false
        //if (!preferences.getBoolean("onboarding_complete", false)) {
            // Start the onboarding Activity
            Intent onboarding = new Intent(this, OnboardingActivity.class);
            startActivity(onboarding);

            // Close the main Activity
            finish();
            return;
      // }
    }
}
