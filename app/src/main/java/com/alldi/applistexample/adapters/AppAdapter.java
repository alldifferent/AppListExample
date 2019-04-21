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




        return row;
    }
}
