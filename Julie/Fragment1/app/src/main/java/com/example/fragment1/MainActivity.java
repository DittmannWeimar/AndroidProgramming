package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Fragment redFrag;
    Fragment greenFrag;
    Fragment blueFrag;
    Fragment yellowFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redFrag = new RedFragment();
        greenFrag = new GreenFragment();
        blueFrag = new BlueFragment();
        yellowFrag = new YellowFragment();

        fragmentManager = getSupportFragmentManager();

        findViewById(R.id.RedB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.fragmentLayout, redFrag);
                fragTrans.addToBackStack(null);
                fragTrans.commit();
            }
        });

        findViewById(R.id.GreenB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.fragmentLayout, greenFrag);
                fragTrans.addToBackStack(null);
                fragTrans.commit();
            }
        });

        findViewById(R.id.BlueB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.fragmentLayout, blueFrag);
                fragTrans.addToBackStack(null);
                fragTrans.commit();
            }
        });

        findViewById(R.id.YellowB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragTrans = fragmentManager.beginTransaction();
                fragTrans.replace(R.id.fragmentLayout, yellowFrag);
                fragTrans.addToBackStack(null);
                fragTrans.commit();
            }
        });
    }
}
