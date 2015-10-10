package com.eldorado.endoguide.activities;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.util.EGConstants;

import android.app.Activity;
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
                if(!skippedSplashScreen) {
                    goToMainActivity();
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
            goToMainActivity();
        }
    };

    protected void goToMainActivity() {
        /* Create an Intent that will start the Menu-Activity. */

    }
}
