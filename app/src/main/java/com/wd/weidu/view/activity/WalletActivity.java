package com.wd.weidu.view.activity;

import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.adapter.wallet.UserWalletAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.wallet.UserWalletBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;

import java.util.List;


public class WalletActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {

    private TextView pay;
    private RecyclerView payRecycle;


    @Override
    protected void initData() {
        presenter.getWallet();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        pay = (TextView) findViewById(R.id.handleereaspay);
        payRecycle = (RecyclerView) findViewById(R.id.handleereaspayRecycle);

    }


    @Override
    protected int layoutID() {
        return R.layout.activity_wallet;
    }


    @Override
    public void setData(String json, int i) {
        UserWalletBean userWalletBean = new Gson().fromJson(json, UserWalletBean.class);
        UserWalletBean.ResultBean result = userWalletBean.getResult();
        if (userWalletBean.getStatus().equals("0000")) {
            int balance = result.getBalance();
            List<UserWalletBean.ResultBean.DetailListBean> detailList = result.getDetailList();
            pay.setText(balance + "");
            UserWalletAdapter walletAdapter = new UserWalletAdapter(detailList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WalletActivity.this);
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            payRecycle.setLayoutManager(linearLayoutManager);
            payRecycle.setAdapter(walletAdapter);
        }


    }
}
