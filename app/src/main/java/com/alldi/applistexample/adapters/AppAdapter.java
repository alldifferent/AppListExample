package com.alldi.applistexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alldi.applistexample.R;
import com.alldi.applistexample.datas.App;

import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends ArrayAdapter<App> {

    Context mContext;
    List<App> mList;
    LayoutInflater inf;

    public AppAdapter(Context context, List<App> list){
        super(context, R.layout.app_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null){
            row = inf.inflate(R.layout.app_list_item, null);
        }

        App appDate = mList.get(position);
        TextView rankTxt = row.findViewById(R.id.rankTxt);
        TextView companyTxt = row.findViewById(R.id.companyTxt);
        ImageView starImv = row.findViewById(R.id.starImv);
        ImageView starImv1 = row.findViewById(R.id.starImv1);
        ImageView starImv2 = row.findViewById(R.id.starImv2);
        ImageView starImv3 = row.findViewById(R.id.starImv3);
        ImageView starImv4 = row.findViewById(R.id.starImv4);
        TextView InstallTxt = row.findViewById(R.id.InstallTxt);

        rankTxt.setText(String.format("%d. %s",appDate.rank,appDate.title));
        companyTxt.setText(appDate.companyName);

        if (appDate.isMine){
            InstallTxt.setText("설치된 항목");
        }else {
            InstallTxt.setText(String.format("%,d원",appDate.price));
        }

        List<ImageView> stars = new ArrayList<>();
        stars.add(starImv);
        stars.add(starImv1);
        stars.add(starImv2);
        stars.add(starImv3);
        stars.add(starImv4);

//        리스트뷰는 재사용성 때문에 데이터가 잘못 나올수 있음.
//        항상 초기상태로 돌려주는 작업 필요.

        for (ImageView star:stars){
            star.setImageResource(R.drawable.star_empty);
        }
        for (int i=0;i<appDate.userRanting;i++){
            stars.get(i).setImageResource(R.drawable.star_fill);
        }

//        if (appDate.userRanting == 1){
//            starImv.setImageResource(R.drawable.star_fill);
//            starImv1.setImageResource(R.drawable.star_empty);
//            starImv2.setImageResource(R.drawable.star_empty);
//            starImv3.setImageResource(R.drawable.star_empty);
//            starImv4.setImageResource(R.drawable.star_empty);
//        }else if (appDate.userRanting == 2){
//            starImv.setImageResource(R.drawable.star_fill);
//            starImv1.setImageResource(R.drawable.star_fill);
//            starImv2.setImageResource(R.drawable.star_empty);
//            starImv3.setImageResource(R.drawable.star_empty);
//            starImv4.setImageResource(R.drawable.star_empty);
//        }else if(appDate.userRanting == 3){
//            starImv.setImageResource(R.drawable.star_fill);
//            starImv1.setImageResource(R.drawable.star_fill);
//            starImv2.setImageResource(R.drawable.star_fill);
//            starImv3.setImageResource(R.drawable.star_empty);
//            starImv4.setImageResource(R.drawable.star_empty);
//
//        }else if (appDate.userRanting == 4){
//            starImv.setImageResource(R.drawable.star_fill);
//            starImv1.setImageResource(R.drawable.star_fill);
//            starImv2.setImageResource(R.drawable.star_fill);
//            starImv3.setImageResource(R.drawable.star_fill);
//            starImv4.setImageResource(R.drawable.star_empty);
//        }else {
//            starImv.setImageResource(R.drawable.star_fill);
//            starImv1.setImageResource(R.drawable.star_fill);
//            starImv2.setImageResource(R.drawable.star_fill);
//            starImv3.setImageResource(R.drawable.star_fill);
//            starImv4.setImageResource(R.drawable.star_fill);
//        }
//
//        if (row == null){
//            starImv.setImageResource(R.drawable.star_empty);
//            starImv1.setImageResource(R.drawable.star_empty);
//            starImv2.setImageResource(R.drawable.star_empty);
//            starImv3.setImageResource(R.drawable.star_empty);
//            starImv4.setImageResource(R.drawable.star_empty);
//        }


        return row;
    }
}
