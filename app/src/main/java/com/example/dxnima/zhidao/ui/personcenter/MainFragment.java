package com.example.dxnima.zhidao.ui.personcenter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.dxnima.zhidao.R;

/**
 * 消息通知页面
 * 对应xml:activity_main
 * Created by DXnima on 2019/4/13.
 */
public class MainFragment extends Fragment{

    private SearchView searchView;

    private ListView listMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        searchView=(SearchView) view.findViewById(R.id.searchView);
        listMsg=(ListView) view.findViewById(R.id.listMsg);
        return view;
    }
}