package com.alldi.applistexample;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.alldi.applistexample.databinding.ActivityAppDetailBinding;
import com.alldi.applistexample.datas.App;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
                Intent intent = new Intent(Intent.ACTION_CALL, phoneUri);
                startActivity(intent);
            }
        });

        act.smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri smsUri = Uri.parse("smsto:01023455234");
                Intent intent = new Intent(Intent.ACTION_SENDTO, smsUri);
                intent.putExtra("sms_body","미리 작성될 메세지");
                startActivity(intent);
            }
        });

        act.homepageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        act.purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=com.supercell.brawlstars");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        act.dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dpd = new DatePickerDialog(AppDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Calendar cal = Calendar.getInstance();
                        cal.set(year, month, dayOfMonth);

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");
                        String dateStr = sdf.format(cal.getTimeInMillis());

                        act.dateTxt.setText(dateStr);

                    }
                }, 2019, 3, 27);
                dpd.show();



            }
        });

        act.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog tpd = new TimePickerDialog(AppDetailActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        cal.set(Calendar.MINUTE, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("a h시 m분",Locale.KOREA);
                        String timeStr = sdf.format(cal.getTimeInMillis());

                        act.timeTxt.setText(timeStr);

                    }
                }, 04,27, false);

                tpd.show();

            }
        });



    }
}
