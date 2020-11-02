package com.wd.weidu.view.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.wd.weidu.R;
import com.wd.weidu.adapter.CustomViewPager;
import com.wd.weidu.adapter.MyPagerAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;
import com.wd.weidu.view.fragment.CircleListFragment;
import com.wd.weidu.view.fragment.HomeFragment;
import com.wd.weidu.view.fragment.MyFragment;
import com.wd.weidu.view.fragment.OrderByStatusFragment;
import com.wd.weidu.view.fragment.ShoppingCartFragment;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {

    private CustomViewPager home_viewpager;
    private RadioGroup home_rgr;
    private RadioButton home_rb_home_n;
    private RadioButton home_rb_circle_n;
    private RadioButton home_rb_shop_car;
    private RadioButton home_rb_order_n;
    private RadioButton home_rb_account_n;
    private MyPagerAdapter myPagerAdapter;

    @Override
    public void setData(String json,int i) {

    }

    @Override
    protected void initData() {
        /*
         * radiogroup+viewpager
         *
         * */
        ArrayList<Fragment> mlist = new ArrayList<>();
        mlist.add(new HomeFragment());
        mlist.add(new CircleListFragment());
        mlist.add(new ShoppingCartFragment());
        mlist.add(new OrderByStatusFragment());
        mlist.add(new MyFragment());

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mlist);

        home_viewpager.setAdapter(myPagerAdapter);
        home_viewpager.setOffscreenPageLimit(1);
        home_viewpager.setCurrentItem(0);
        home_viewpager.setNoScroll(true);

        home_rgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                home_rgr.check(checkedId);
                switch (checkedId) {
                    case R.id.home_rb_home_n:
                        home_viewpager.setCurrentItem(0);
                        break;
                    case R.id.home_rb_circle_n:
                        home_viewpager.setCurrentItem(1);
                        break;
                    case R.id.home_rb_shop_car:
                        home_viewpager.setCurrentItem(2);
                        break;
                    case R.id.home_rb_order_n:
                        home_viewpager.setCurrentItem(3);
                        break;
                    case R.id.home_rb_account_n:
                        home_viewpager.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        home_viewpager = (CustomViewPager) findViewById(R.id.home_viewpager);
        home_rgr = (RadioGroup) findViewById(R.id.home_rgr);
        //主页(xbananer)
        home_rb_home_n = (RadioButton) findViewById(R.id.home_rb_home_n);
        //圈子
        home_rb_circle_n = (RadioButton) findViewById(R.id.home_rb_circle_n);
        //购物车
        home_rb_shop_car = (RadioButton) findViewById(R.id.home_rb_shop_car);
        //订单
        home_rb_order_n = (RadioButton) findViewById(R.id.home_rb_order_n);
        //个人
        home_rb_account_n = (RadioButton) findViewById(R.id.home_rb_account_n);
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_home;
    }
}
