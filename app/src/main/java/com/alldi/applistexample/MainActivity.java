package com.alldi.applistexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alldi.applistexample.adapters.AppAdapter;
import com.alldi.applistexample.databinding.ActivityMainBinding;
import com.alldi.applistexample.datas.App;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<App> appList = new ArrayList<>();
    ActivityMainBinding act;
    AppAdapter appAdapter;


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
        
        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        act.appRankListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.format("%d번 줄 클릭", position), Toast.LENGTH_SHORT).show();


            }
        });

        act.appRankListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, String.format("%d번 줄을 오래 누름",position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    void setValues(){

        appAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankListView.setAdapter(appAdapter);

    }

    void fillApp(){

        appList.add(new App(1,"아스팔트 8: 에어본", "GameLoft", 2, 6000, true));
        appList.add(new App(2,"Minecraft - Pocket Edition", "Mojang", 3, 5000, true));
        appList.add(new App(3,"아스팔트 7: 하트", "GameLoft", 4, 1000, false));
        appList.add(new App(4,"팔라독", "FazeCat", 1, 1800, false));
        appList.add(new App(5,"Plants Vs Zombies", "EA Swiss Sarl", 5, 5200, false));
        appList.add(new App(6,"스왐피", "Disney", 2, 1600, false));
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
