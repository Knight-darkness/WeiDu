package com.wd.weidu.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter
 * @ClassName: MyPageAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/20
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
