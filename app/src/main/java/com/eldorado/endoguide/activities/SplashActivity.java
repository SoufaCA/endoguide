package com.eldorado.endoguide.activities;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.util.EGConstants;

import android.animation.ObjectAnimator;
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

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(splashScreenImageView, "alpha", .3f, 1f);
        fadeIn.setDuration(1000);

        fadeIn.start();

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

        Intent nextPage;

        if (preferences.getBoolean("onboarding_complete", false)) {
            nextPage = new Intent(this, OnboardingActivity.class);
        } else {
            nextPage = new Intent(this, MainActivity.class);
        }

        startActivity(nextPage);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        // Close the main Activity
        finish();
        return;
    }
}
