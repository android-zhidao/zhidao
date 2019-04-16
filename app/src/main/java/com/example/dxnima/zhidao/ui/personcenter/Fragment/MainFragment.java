package com.example.dxnima.zhidao.ui.personcenter.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.dxnima.zhidao.R;
import com.example.dxnima.zhidao.ui.listView.Data;
import com.example.dxnima.zhidao.ui.listView.MyAdapter;
import com.example.dxnima.zhidao.ui.personcenter.Activity.SeemsgActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * 消息通知页面
 * 对应xml:activity_main
 * Created by DXnima on 2019/4/13.
 */
public class MainFragment extends Fragment {

    private SearchView searchView;
    private ListView listMsg;
    private TextView txt_empty;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    //创造View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        searchView=(SearchView) view.findViewById(R.id.searchView);
        listMsg=(ListView) view.findViewById(R.id.listMsg);
        txt_empty=(TextView) view.findViewById(R.id.text_empty);
        //listview初始化
        mData = new LinkedList<Data>();
        mAdapter = new MyAdapter((LinkedList<Data>) mData,getActivity());
        initData();
        bindViews();
        return view;
    }

    //开始
    @Override
    public void onStart() {
        for (int position = 0; position <mData.size(); position++) {
            //item的点击事件，里面可以设置跳转并传值
            listMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Data data=mData.get(position);
                    Intent intent = new Intent(getActivity().getApplicationContext(), SeemsgActivity.class);
                    intent.putExtra("title", data.getTitle());
                    intent.putExtra("endtime", data.getEndtime());
                    startActivity(intent);
                }
            });
        }
        super.onStart();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void bindViews() {
        listMsg.setAdapter(mAdapter);
        txt_empty.setText("暂无通知~");
        listMsg.setEmptyView(txt_empty);
    }

    //修改某一行的list数据
    private void updateListItem(int postion,Data mData){
        int visiblePosition = listMsg.getFirstVisiblePosition();
        View v = listMsg.getChildAt(postion - visiblePosition);
        ImageView msgimage = (ImageView) v.findViewById(R.id.list_msgimage);
        TextView msgtitel = (TextView) v.findViewById(R.id.list_msgtitle);
        TextView msgendtime=(TextView) v.findViewById(R.id.list_msgendtime);
        msgimage.setImageResource(mData.getImgId());
        msgtitel.setText(mData.getTitle());
        msgendtime.setText(mData.getEndtime());
    }

    //添加list数据
    public void initData() {
        mAdapter.add(new Data(R.drawable.xingxing, "英语考试1", "10：15"));
        mAdapter.add(new Data(R.drawable.xingxing, "英语考试2", "10：15"));
        mAdapter.add(new Data(R.drawable.xingxing, "英语考试3", "10：15"));
        mAdapter.add(new Data(R.drawable.xingxing, "英语考试4", "10：15"));
        mAdapter.add(new Data(R.drawable.xingxing, "英语考试5", "10：15"));
        }
}