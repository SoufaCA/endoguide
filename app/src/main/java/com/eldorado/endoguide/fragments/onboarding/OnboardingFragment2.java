package com.eldorado.endoguide.fragments.onboarding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eldorado.endoguide.R;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class OnboardingFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        View rootView = inflater.inflate(R.layout.onboarding_screen2, container, false);

        ImageView preview = (ImageView) rootView.findViewById(R.id.preview);
        TextView message = (TextView) rootView.findViewById(R.id.message);

        ObjectAnimator previewFadeIn = ObjectAnimator.ofFloat(preview, "alpha", 0f, 1f).setDuration(3000);
        ObjectAnimator messageFadeIn = ObjectAnimator.ofFloat(message, "alpha", 0f, 1f).setDuration(3000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(previewFadeIn).with(messageFadeIn);

        mAnimationSet.start();

        return rootView;
    }

}
