package com.eldorado.endoguide.fragments.onboarding;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.eldorado.endoguide.R;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class OnboardingFragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        View rootView = inflater.inflate(R.layout.onboarding_screen1, container, false);

        ImageView logo = (ImageView) rootView.findViewById(R.id.logo);

        Animation slideIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);

        logo.startAnimation(slideIn);

        return rootView;
    }
}
