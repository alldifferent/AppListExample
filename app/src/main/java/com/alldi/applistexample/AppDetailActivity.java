package com.alldi.applistexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alldi.applistexample.databinding.ActivityAppDetailBinding;
import com.alldi.applistexample.datas.App;

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


    }
}
