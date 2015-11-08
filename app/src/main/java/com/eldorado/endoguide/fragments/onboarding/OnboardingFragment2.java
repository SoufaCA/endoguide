package com.eldorado.endoguide.fragments.onboarding;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.fragments.BasicFragment;

/**
 * Created by msi-pc on 10/11/2015.
 */
public class OnboardingFragment2 extends BasicFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        rootView = inflater.inflate(R.layout.onboarding_screen2, container, false);
        VideoView videoView = (VideoView) rootView.findViewById(R.id.preview);
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.demo_1));

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        startAnimation();
        videoView.start();

        return rootView;
    }

    @Override
    public void startAnimation() {
        VideoView preview = (VideoView) rootView.findViewById(R.id.preview);
        TextView message = (TextView) rootView.findViewById(R.id.message);
        message.setTranslationY(-300);

        ObjectAnimator previewFadeIn = ObjectAnimator.ofFloat(preview, "alpha", 0f, 1f).setDuration(2000);
        ObjectAnimator previewSlideIn = ObjectAnimator.ofFloat(preview, "translationY", 0, -rootView.getHeight() / 2).setDuration(2000);
        ObjectAnimator messageFadeIn = ObjectAnimator.ofFloat(message, "alpha", 0f, 1f).setDuration(2000);
        ObjectAnimator messageSlideIn = ObjectAnimator.ofFloat(message, "translationY", -rootView.getHeight() / 2, 0).setDuration(1000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(previewFadeIn).with(messageFadeIn).with(messageSlideIn);

        mAnimationSet.start();
    }

}
