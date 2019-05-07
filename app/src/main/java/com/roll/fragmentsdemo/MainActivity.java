package com.roll.fragmentsdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Button btFragmentA;
    Button btFragmentB;
    FrameLayout flMainFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initXML();
    }

    void initXML(){
        btFragmentA = findViewById(R.id.btnFragmentA);
        btFragmentB = findViewById(R.id.btnFragmentB);
        flMainFrame = findViewById(R.id.mainFrame);

        btFragmentA.setOnClickListener(this);
        btFragmentB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()){
            case R.id.btnFragmentA:
                Log.i(TAG,"Click on btnFragmentA");
                fragment = new AFragment();
                openFragment(fragment);
                break;
            case R.id.btnFragmentB:
                Log.i(TAG,"Click on btnFragmentB");
                fragment = new BFragment();
                openFragment(fragment);
                break;
        }
    }

    public void openFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFrame,fragment);
        ft.commit();
    }
}
