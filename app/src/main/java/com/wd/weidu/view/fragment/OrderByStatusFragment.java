package com.wd.weidu.view.fragment;


import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.adapter.MyRecycleInterval;
import com.wd.weidu.adapter.order.orderAllAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.orderForm.orderAllBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderByStatusFragment extends BaseFragment<MainPresenter> implements IMainConstant.IMainView {


    @BindView(R.id.order_fm_status_tablayout)
    TabLayout orderFmStatusTablayout;
    @BindView(R.id.orderByAllbage)
    LinearLayout orderByAllbage;
    @BindView(R.id.all_order_fragment)
    RecyclerView allOrderFragment;
    private Unbinder bind;
    private orderAllAdapter adapter;

    @Override
    public void setData(String json, int i) {
        orderAllBean orderAllBean = new Gson().fromJson(json, orderAllBean.class);
        if (orderAllBean.getStatus().equals("0000")) {
            List<orderAllBean.OrderListBean> orderList = orderAllBean.getOrderList();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            allOrderFragment.setLayoutManager(linearLayoutManager);
            adapter = new orderAllAdapter(orderList);
            allOrderFragment.setAdapter(adapter);

            setChanger();

        } else {
            orderByAllbage.setBackgroundResource(R.drawable.data_null);

        }

    }

    private void setChanger() {
        orderFmStatusTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //添加选中tab逻辑
                switch (tab.getPosition()) {
                    case 0:
                        presenter.getOrderListBy(0);
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        presenter.getOrderListBy(1);
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        presenter.getOrderListBy(2);
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        presenter.getOrderListBy(3);
                        adapter.notifyDataSetChanged();
                        break;
                    case 4:
                        presenter.getOrderListBy(9);
                        adapter.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //添加未选中逻辑
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中逻辑

            }
        });

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {

        orderFmStatusTablayout.addTab(orderFmStatusTablayout.newTab().setText("订单").setIcon(R.drawable.order_all));
        orderFmStatusTablayout.addTab(orderFmStatusTablayout.newTab().setText("代付款").setIcon(R.drawable.order_pay));
        orderFmStatusTablayout.addTab(orderFmStatusTablayout.newTab().setText("待收货").setIcon(R.drawable.order_receive));
        orderFmStatusTablayout.addTab(orderFmStatusTablayout.newTab().setText("待评价").setIcon(R.drawable.order_comment));
        orderFmStatusTablayout.addTab(orderFmStatusTablayout.newTab().setText("已完成").setIcon(R.drawable.shop_car_all));


        presenter.getOrderListBy(0);
        /*presenter.getOrderListBy(9);*/
        /*ArrayList<Fragment> mlist = new ArrayList<>();
        mlist.add(new AllOrderFragment());//全部
        mlist.add(new AllOrderFragment());//付款
        mlist.add(new AllOrderFragment());//收货
        mlist.add(new AllOrderFragment());//评价
        mlist.add(new AllOrderFragment());//完成

        ArrayList<String> titleList = new ArrayList<>();
        titleList.add("全部订单");
        titleList.add("代付款");
        titleList.add("待收货");
        titleList.add("待评价");
        titleList.add("已完成");

        orderFmStatusViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mlist.get(position);
            }

            @Override
            public int getCount() {
                return mlist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);
            }
        });

        orderFmStatusTablayout.setupWithViewPager(orderFmStatusViewpager);

        orderFmStatusTablayout.getTabAt(0).setIcon(R.drawable.order_all);
        orderFmStatusTablayout.getTabAt(1).setIcon(R.drawable.order_pay);
        orderFmStatusTablayout.getTabAt(2).setIcon(R.drawable.order_receive);
        orderFmStatusTablayout.getTabAt(3).setIcon(R.drawable.order_comment);
        orderFmStatusTablayout.getTabAt(4).setIcon(R.drawable.shop_car_all);*/

    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_order_by_status;
    }
}
