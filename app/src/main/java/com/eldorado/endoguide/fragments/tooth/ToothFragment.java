package com.eldorado.endoguide.fragments.tooth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.fragments.BasicFragment;
import com.eldorado.endoguide.model.Description;
import com.eldorado.endoguide.model.Tooth;

import java.io.Serializable;
import java.util.List;

/**
 * Created by msi-pc on 10/19/2015.
 */
public class ToothFragment extends BasicFragment {

    private List<Description> descriptionList;

    public static ToothFragment newInstance(List<Description> descriptionList) {
        ToothFragment f = new ToothFragment();
        Bundle args = new Bundle();
        args.putSerializable("descriptionList", (Serializable) descriptionList);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        rootView = inflater.inflate(R.layout.fragment_tooth_1, container, false);

        Bundle args = getArguments();
        if (args != null) {

            descriptionList = (List) getArguments().getSerializable("descriptionList");

            for (Description description : descriptionList) {
                View v = inflater.inflate(R.layout.tooth_description_view, null);

                TextView descriptionText = (TextView) v.findViewById(R.id.description_text);
                ImageView descriptionImage = (ImageView) v.findViewById(R.id.description_image);

                descriptionText.setText(description.getText());
                descriptionImage.setImageDrawable(getResources().getDrawable(description.getDrawableId()));

                ViewGroup insertPoint = (ViewGroup) rootView.findViewById(R.id.list_description);
                insertPoint.addView(v);


            }
        }

        return rootView;
    }

    @Override
    public void startAnimation() {
    }
}