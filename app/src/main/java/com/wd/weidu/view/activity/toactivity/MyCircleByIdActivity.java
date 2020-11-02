package com.wd.weidu.view.activity.toactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.wd.weidu.R;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;

public class MyCircleByIdActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {


    @Override
    public void setData(String json,int i) {
        Toast.makeText(this, "" + json, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        //查询圈子信息
        presenter.getMyCircleById();
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_my_circle_by_id;
    }
}
