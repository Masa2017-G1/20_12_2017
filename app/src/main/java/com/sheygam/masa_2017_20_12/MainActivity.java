package com.sheygam.masa_2017_20_12;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private Button fragABtn, fragBBtn, fragCBtn;
    private ViewPager pager;
    private MyPagerAdapter adapter;
    private FrameLayout fragAInd,fragBInd,fragCInd;
    private int indColor = Color.rgb(0,0,255);
    private int transColor = Color.argb(0,0,0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragABtn = findViewById(R.id.frag_a_btn);
        fragBBtn = findViewById(R.id.frag_b_btn);
        fragCBtn = findViewById(R.id.frag_c_btn);
        fragAInd = findViewById(R.id.frag_a_ind);
        fragBInd = findViewById(R.id.frag_b_ind);
        fragCInd = findViewById(R.id.frag_c_ind);
        fragAInd.setBackgroundColor(indColor);
        pager = findViewById(R.id.my_pager);
        fragABtn.setOnClickListener(this);
        fragBBtn.setOnClickListener(this);
        fragCBtn.setOnClickListener(this);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frag_a_btn:
                pager.setCurrentItem(0);
                fragAInd.setBackgroundColor(indColor);
                fragBInd.setBackgroundColor(transColor);
                fragCInd.setBackgroundColor(transColor);
                break;
            case R.id.frag_b_btn:
                pager.setCurrentItem(1);
                fragAInd.setBackgroundColor(transColor);
                fragBInd.setBackgroundColor(indColor);
                fragCInd.setBackgroundColor(transColor);
                break;
            case R.id.frag_c_btn:
                pager.setCurrentItem(2,false);
                fragAInd.setBackgroundColor(transColor);
                fragBInd.setBackgroundColor(transColor);
                fragCInd.setBackgroundColor(indColor);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                fragAInd.setBackgroundColor(indColor);
                fragBInd.setBackgroundColor(transColor);
                fragCInd.setBackgroundColor(transColor);
                break;
            case 1:
                fragAInd.setBackgroundColor(transColor);
                fragBInd.setBackgroundColor(indColor);
                fragCInd.setBackgroundColor(transColor);
                break;
            case 2:
                fragAInd.setBackgroundColor(transColor);
                fragBInd.setBackgroundColor(transColor);
                fragCInd.setBackgroundColor(indColor);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragments;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new FragmentA());
            fragments.add(new FragmentB());
            fragments.add(new FragmentC());
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
