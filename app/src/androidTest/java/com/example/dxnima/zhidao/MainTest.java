package com.example.dxnima.zhidao;

import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.dxnima.zhidao.ui.personcenter.MainFragment;
import com.example.dxnima.zhidao.ui.personcenter.MypageFragment;

/**
 * Created by DXnima on 2019/4/13.
 */
public class MainTest extends FragmentActivity{
    //定义fragment
    private MypageFragment mypageFragment;
    private MainFragment mainFragment;
    // 定义FragmentManager对象管理器
    private FragmentManager fragmentManager;
    /**
     * 设置点击选项卡的事件处理
     *
     * @param index 选项卡的标号：0, 1
     */
    private void setChioceItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragments(fragmentTransaction);//隐藏所以fragment
        switch (index) {
            case 0:
                 // 如果为空，则创建一个并添加到界面上
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                    fragmentTransaction.add(R.id.fragment_container, mainFragment);
                } else {
                    // 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(mainFragment);
                }
                break;
            case 1:
                if (mypageFragment == null) {
                    mypageFragment = new MypageFragment();
                    fragmentTransaction.add(R.id.fragment_container, mypageFragment);
                } else {
                    fragmentTransaction.show(mypageFragment);
                }
                break;
        }
        fragmentTransaction.commit(); // 提交
    }

    /**
     * 隐藏Fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (mainFragment !=null){
            fragmentTransaction.hide(mainFragment);
        }
        if (mypageFragment!=null){
            fragmentTransaction.hide(mypageFragment);
        }
    }
}