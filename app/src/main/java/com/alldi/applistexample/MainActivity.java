package com.alldi.applistexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    static int REQ_FOR_FILTER = 1;


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

                AlertDialog.Builder okAlert = new AlertDialog.Builder(MainActivity.this);
                okAlert.setTitle("게임 추가 알림");
                okAlert.setMessage("임시 게임이 추가됩니다.");
                okAlert.setPositiveButton("확인", null);
                okAlert.show();

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

                final int finalPosition = position;

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("앱 삭제 확인");
                alert.setMessage("정말 이 앱을 삭제하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        appList.remove(finalPosition);
                        appAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "해당 앱이 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소", null);
                alert.show();



                return true;
            }
        });

        act.filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilterActivity.class);
                startActivityForResult(intent, REQ_FOR_FILTER);
            }
        });

    }

    void setValues(){

        appAdapter = new AppAdapter(MainActivity.this, appList);
        act.appRankListView.setAdapter(appAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("액티비티 결과", "결과가돌아옴");
        Log.d("리퀘스트 코드",requestCode+"");
        Log.d("ResultCode",resultCode+"");

        if (requestCode == REQ_FOR_FILTER){
            if (resultCode == RESULT_OK){
//                Toast.makeText(this, "필터가 설정되었습니다.", Toast.LENGTH_SHORT).show();
                int filteredRating = data.getIntExtra("최소평점", 0);
                act.filterRatingTxt.setText(String.format("(현재 필터 : %d점)",filteredRating));
            }else {
                Toast.makeText(this, "필터 설정을 취소했습니다.", Toast.LENGTH_SHORT).show();
            }
        }
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
