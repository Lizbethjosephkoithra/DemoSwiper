package com.myapplicationdev.demoswiper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button back,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);
        back = findViewById(R.id.btnBack);
        next = findViewById(R.id.btnNext);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if  (vPager.getCurrentItem() > 0){
                    int previousPage = vPager.getCurrentItem() -1 ;
                    vPager.setCurrentItem(previousPage,true);
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int max = vPager.getChildCount();
                if  (vPager.getCurrentItem() < max- 1){
                    int nextPage = vPager.getCurrentItem() +1 ;
                    vPager.setCurrentItem(nextPage,true);
                }
            }
        });

    }

}

