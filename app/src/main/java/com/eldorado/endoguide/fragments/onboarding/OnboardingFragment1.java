package com.eldorado.endoguide.fragments.onboarding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.fragments.BasicFragment;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class OnboardingFragment1 extends BasicFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        rootView = inflater.inflate(R.layout.onboarding_screen1, container, false);

        startAnimation();

        return rootView;
    }

    @Override
    public void startAnimation() {
        ImageView logo = (ImageView) rootView.findViewById(R.id.logo);
        TextView welcome = (TextView) rootView.findViewById(R.id.welcomeTV);
        TextView abir = (TextView) rootView.findViewById(R.id.abirTV);
        TextView endoguide = (TextView) rootView.findViewById(R.id.endoguideTV);

        ObjectAnimator logoFadeIn = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f).setDuration(3000);
        ObjectAnimator welcomeFadeIn = ObjectAnimator.ofFloat(welcome, "alpha", 0f, 1f).setDuration(3000);
        ObjectAnimator abirFadeIn = ObjectAnimator.ofFloat(abir, "alpha", 0f, 1f).setDuration(3000);
        ObjectAnimator endoguideFadeIn = ObjectAnimator.ofFloat(endoguide, "alpha", 0f, 1f).setDuration(3000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(logoFadeIn).with(welcomeFadeIn).with(abirFadeIn).with(endoguideFadeIn);

        mAnimationSet.start();
    }
}
