package com.eldorado.endoguide.fragments.tooth;

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
 * Created by msi-pc on 10/19/2015.
 */
public class ToothFragment1 extends BasicFragment {

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
    }
}