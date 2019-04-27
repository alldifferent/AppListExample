package com.alldi.applistexample;

import android.content.Intent;
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
//                Toast.makeText(MainActivity.this, "확인버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();

                appList.add(new App(10, "임시 게임", "이상", 4,7000, false));
                appAdapter.notifyDataSetChanged();
                act.appRankListView.smoothScrollToPosition(appList.size()-1);
            }
        });

        act.appRankListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, String.format("%d번 줄 클릭", position), Toast.LENGTH_SHORT).show();

                App clickedAppData = appList.get(position);

                Intent intent = new Intent(MainActivity.this, AppDetailActivity.class);

//                intent.putExtra("제목", clickedAppData.title);
//                intent.putExtra("회사이름", clickedAppData.companyName);
                intent.putExtra("앱정보", clickedAppData);
                startActivity(intent);

            }
        });

        act.appRankListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(MainActivity.this, String.format("%d번 줄을 오래 누름",position), Toast.LENGTH_SHORT).show();

                appList.remove(position);

                appAdapter.notifyDataSetChanged();

                return true;
            }
        });

    }

    void setValues(){

        appAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankListView.setAdapter(appAdapter);

    }

    void fillApp(){

        appList.add(new App(1,"아스팔트 8: 에어본", "GameLoft", 1, 6000, true));
        appList.add(new App(2,"Minecraft - Pocket Edition", "Mojang", 2, 5000, true));
        appList.add(new App(3,"아스팔트 7: 하트", "GameLoft", 3, 1000, false));
        appList.add(new App(4,"팔라독", "FazeCat", 4, 1800, false));
        appList.add(new App(5,"Plants Vs Zombies", "EA Swiss Sarl", 5, 5200, false));
        appList.add(new App(6,"스왐피", "Disney", 1, 1600, false));
        appList.add(new App(1,"아스팔트 8: 에어본", "GameLoft", 2, 6000, true));
        appList.add(new App(2,"Minecraft - Pocket Edition", "Mojang", 3, 5000, true));
        appList.add(new App(3,"아스팔트 7: 하트", "GameLoft", 4, 1000, false));
        appList.add(new App(4,"팔라독", "FazeCat", 5, 1800, false));
        appList.add(new App(5,"Plants Vs Zombies", "EA Swiss Sarl", 1, 5200, false));
        appList.add(new App(6,"스왐피", "Disney", 2, 1600, false));


    }

    void bindView(){

    }

}
