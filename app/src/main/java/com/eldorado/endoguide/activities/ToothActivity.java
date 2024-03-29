package com.eldorado.endoguide.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.eldorado.endoguide.R;
import com.eldorado.endoguide.fragments.tooth.ToothFragment;
import com.eldorado.endoguide.model.Tooth;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

public class ToothActivity extends ActionBarActivity implements
        ActionBar.TabListener {

    private ViewPager pager;
    private SmartTabLayout indicator;
    private ActionBar actionBar;
    private List<String> tabs;
    private Tooth selectedTooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tooth);

        tabs = new ArrayList<>();

        tabs.add(getString(R.string.general));
        tabs.add(getString(R.string.roots));
        tabs.add(getString(R.string.other));

        selectedTooth = (Tooth) getIntent().getSerializableExtra("selectedTooth");

        setTitle(selectedTooth.getGeneratedName());

        pager = (ViewPager) findViewById(R.id.tooth_pager);

        final FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return ToothFragment.newInstance(selectedTooth.getFirstDescriptions());
                    case 1:
                        return ToothFragment.newInstance(selectedTooth.getSecondDescriptions());
                    case 2:
                        return ToothFragment.newInstance(selectedTooth.getThirdDescriptions());
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        pager.setAdapter(adapter);

        /**
         * on swiping the viewpager make respective tab selected
         * */
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
