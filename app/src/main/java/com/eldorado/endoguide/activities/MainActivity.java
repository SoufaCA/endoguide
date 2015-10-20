package com.eldorado.endoguide.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.controllers.DataGenerator;
import com.eldorado.endoguide.model.Position;
import com.eldorado.endoguide.model.Quadrant;
import com.eldorado.endoguide.model.Tooth;
import com.eldorado.endoguide.util.EGConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    DataGenerator dataGenerator;
    List<Tooth> teeth;
    Tooth defaultTooth;
    Tooth selectedTooth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startAnimation();

        dataGenerator = new DataGenerator();
        dataGenerator.generateTeeth();

        teeth = new ArrayList<>();

        defaultTooth = new Tooth();
        defaultTooth.setGeneratedName(getStringResourceByName("select_one"));
        teeth.add(defaultTooth);

        teeth.addAll(dataGenerator.getTeeth());

        generateTeethNames();

        Spinner spinner = (Spinner) findViewById(R.id.teeth_spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                selectedTooth = (Tooth) parentView.getSelectedItem();

                if (!selectedTooth.equals(defaultTooth)) {
                    goToToothActivity();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, teeth);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setPrompt(getStringResourceByName("tooth_selection"));
    }

    public void startAnimation() {
        ImageView permanentTeeth = (ImageView) findViewById(R.id.permanent_teeth);

        ObjectAnimator permanentTeethFadeIn = ObjectAnimator.ofFloat(permanentTeeth, "alpha", 0f, 1f).setDuration(3000);
        ObjectAnimator permanentTeethSlideIn = ObjectAnimator.ofFloat(permanentTeeth, "translationY", this.getResources().getDisplayMetrics().heightPixels / 2, 0).setDuration(2000);

        final AnimatorSet mAnimationSet = new AnimatorSet();

        mAnimationSet.play(permanentTeethFadeIn).with(permanentTeethSlideIn);

        mAnimationSet.start();
    }

    public String getQuadrantName(Quadrant quadrant) {
        return getStringResourceByName(quadrant.getPosition()) + " " + getStringResourceByName(quadrant.getArcade());
    }

    public String getPositionName(Position position) {
        return position.getNumber() + " - " + getQuadrantName(position.getQuadrant());
    }

    public String getToothName(Tooth tooth) {
        return getPositionName(tooth.getPosition()) + " " + getStringResourceByName(tooth.getName());
    }

    public void generateTeethNames() {
        for (Tooth tooth : teeth) {
            if (!tooth.equals(defaultTooth)) {
                tooth.setGeneratedName(getToothName(tooth));
            }
        }
    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    protected void goToToothActivity() {

        Intent toothActivity = new Intent(this, ToothActivity.class);

        toothActivity.putExtra("selectedTooth", selectedTooth);

        startActivity(toothActivity);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        return;
    }
}
