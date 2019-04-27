package com.alldi.applistexample;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.alldi.applistexample.databinding.ActivityAppDetailBinding;
import com.alldi.applistexample.datas.App;

import java.util.Calendar;

public class AppDetailActivity extends AppCompatActivity {

    ActivityAppDetailBinding act;
    App mAppData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);

//        String appTitle = getIntent().getStringExtra("제목");
//        String appCompanyName = getIntent().getStringExtra("회사이름");

        mAppData = (App)getIntent().getSerializableExtra("앱정보");

        act.appTitleTxt.setText(mAppData.title);
        act.companyNameTxt.setText(mAppData.companyName);
        act.userRatingTxt.setText(String.format("%d점",mAppData.userRanting));

//        구매 여부에 따라 필요한 버튼만 보여주기
        if (mAppData.isMine){
            act.removeBtn.setVisibility(View.VISIBLE);
            act.launchBtn.setVisibility(View.VISIBLE);
            act.purchaseBtn.setVisibility(View.GONE);
        }else   {
            act.removeBtn.setVisibility(View.GONE);
            act.launchBtn.setVisibility(View.GONE);
            act.purchaseBtn.setVisibility(View.VISIBLE);

            act.purchaseBtn.setText(String.format("구매하기(%,d원)",mAppData.price));
        }

        act.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneUri = Uri.parse("tel:019-9876-3949");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
                startActivity(intent);
            }
        });

        act.dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("텍스트뷰 클릭!","실제로 동작하나?");
                DatePickerDialog dpd = new DatePickerDialog(AppDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                        Toast.makeText(AppDetailActivity.this, String.format("%d년 %d월 %d일",year,month+1,dayOfMonth), Toast.LENGTH_SHORT).show();

                        Calendar cal = Calendar.getInstance(); // new Calender라고 만들지 않는다.
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, month);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        cal.set(year,month,dayOfMonth);

//                        같은 메쏘드인데, arg의 종류/변수에 따라 다른 행동을함. => overLoading의 예시



                    }
                }, 2019, 3, 27);

                dpd.show();
            }
        });


    }
}
