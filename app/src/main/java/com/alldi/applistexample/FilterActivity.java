package com.alldi.applistexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alldi.applistexample.databinding.ActivityFilterBinding;

public class FilterActivity extends AppCompatActivity {

    ActivityFilterBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }
}
