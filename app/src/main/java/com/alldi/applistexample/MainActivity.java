package com.alldi.applistexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alldi.applistexample.databinding.ActivityMainBinding;
import com.alldi.applistexample.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<App> appList = new ArrayList<>();
    ActivityMainBinding act;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupEvents();
        setValues();
        fillApp();
        bindView();
    }

    void setupEvents(){

    }

    void setValues(){

    }

    void fillApp(){

        appList.add(new App(1,"아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new App(2,"Minecraft - Pocket Edition", "Mojang", 3, 5000, true));
        appList.add(new App(3,"아스팔트 7: 하트", "GameLoft", 4, 1000, false));
        appList.add(new App(4,"팔라독", "FazeCat", 1, 1800, false));
        appList.add(new App(5,"Plants Vs Zombies", "EA Swiss Sarl", 5, 5200, false));
        appList.add(new App(6,"스왐피", "Disney", 2, 1600, false));


    }

    void bindView(){

    }

}
