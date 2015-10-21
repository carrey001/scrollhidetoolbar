package com.carrey.scrollhidetoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        findViewById(R.id.partOneButton).setOnClickListener(this);
        findViewById(R.id.partTwoButton).setOnClickListener(this);
        findViewById(R.id.partThreeButton).setOnClickListener(this);
        findViewById(R.id.partFourButton).setOnClickListener(this);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.app_name));
    }

    @Override
    public void onClick(View v) {
        Intent myIntent;
        switch (v.getId()) {
            case R.id.partOneButton:
                myIntent = new Intent(this, PartOneActivity.class);
                startActivity(myIntent);
                break;
            case R.id.partTwoButton:
                myIntent = new Intent(this, PartTwoActivity.class);
                startActivity(myIntent);
                break;
            case R.id.partThreeButton:
                myIntent = new Intent(this, PartThreeActivity.class);
                startActivity(myIntent);
                break;
            case R.id.partFourButton:
                myIntent = new Intent(this,PartFourActivity.class);
                startActivity(myIntent);
                break;
        }
    }
}
