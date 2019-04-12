package com.example.dxnima.zhidao.ui.personcenter;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dxnima.zhidao.R;

/**
 * 我的主页界面
 * 对应xml:activity_my
 * Created by DXnima on 2019/4/13.
 */
public class MypageFragment extends Fragment{

    private TextView mypage_setting,mypage_user;

    private ImageView mypage_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my, container, false);
        mypage_setting=(TextView) view.findViewById(R.id.mypage_setting);
        mypage_image=(ImageView) view.findViewById(R.id.mypage_image);
        mypage_setting=(TextView) view.findViewById(R.id.mypage_setting);
        mypage_user=(TextView) view.findViewById(R.id.mypage_user);
        mypage_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}