package com.wd.weidu.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.wd.weidu.R;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseFragment;
import com.wd.weidu.view.activity.MyFootprintActivity;
import com.wd.weidu.view.activity.WalletActivity;
import com.wd.weidu.view.activity.toactivity.ChangeDataActivity;
import com.wd.weidu.view.activity.toactivity.LoginActivity;
import com.wd.weidu.view.activity.toactivity.MyCircleByIdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<MainPresenter> implements IMainConstant.IMainView {


    @BindView(R.id.my_h_back)
    ImageView myHBack;
    @BindView(R.id.my_h_head)
    ImageView myHHead;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.my_personal_datum)
    LinearLayout myPersonalDatum;
    @BindView(R.id.my_personal_estimate)
    LinearLayout myPersonalEstimate;
    @BindView(R.id.my_personal_footprint)
    LinearLayout myPersonalFootprint;
    @BindView(R.id.my_personal_wallet)
    LinearLayout myPersonalWallet;
    @BindView(R.id.my_personal_site)
    LinearLayout myPersonalSite;
    private Unbinder bind;

    private static final String TAG = "MyFragment";


    @Override
    public void setData(String json, int i) {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {

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
        return R.layout.fragment_my;
    }


    @OnClick({R.id.my_h_head, R.id.user_name, R.id.my_personal_datum, R.id.my_personal_estimate, R.id.my_personal_footprint, R.id.my_personal_wallet, R.id.my_personal_site})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_h_head:
                if (loginBeanThis()) {
                    changehead();
                } else {
                    startReturn();
                }
                break;
            case R.id.user_name:
                if (loginBeanThis()) {
                    changehead();
                } else {
                    startReturn();
                }
                break;
            case R.id.my_personal_datum:
                if (loginBeanThis()) {
                    changehead();
                } else {
                    startReturn();
                }
                break;
            case R.id.my_personal_estimate:
                if (loginBeanThis()) {
                    changehead();
                } else {
                    startEstimate();
                }
                break;
            //足迹
            case R.id.my_personal_footprint:
                if (loginBeanThis()) {
                    footprint();
                } else {
                    changehead();
                }
                break;
                //钱包
            case R.id.my_personal_wallet:
                if (loginBeanThis()) {
                    wallet();
                } else {
                    startReturn();
                }
                break;
            case R.id.my_personal_site:
                if (loginBeanThis()) {
                    changehead();
                } else {
                    startReturn();
                }
                break;
        }
    }

    //查询圈子
    private void startEstimate() {
        Intent intent = new Intent(getActivity(), MyCircleByIdActivity.class);
        getActivity().startActivity(intent);
    }

    //改变头像和个人信息
    private void changehead() {
        Intent intenst = new Intent(getActivity(), ChangeDataActivity.class);
        getActivity().startActivity(intenst);
    }

    //登录
    private void startReturn() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    //钱包
    private void wallet() {
        Intent intent = new Intent(getActivity(), WalletActivity.class);
        startActivity(intent);
    }

    //足迹
    private void footprint() {
        Intent intent = new Intent(getActivity(), MyFootprintActivity.class);
        startActivity(intent);
    }

    //登录判定
    private boolean loginBeanThis() {
        SharedPreferences user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean loginState = user.getBoolean("loginState", false);
        if (!loginState) {
            return false;
        }
        return true;
    }
}
