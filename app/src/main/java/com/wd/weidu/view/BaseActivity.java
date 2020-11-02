package com.wd.weidu.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wd.weidu.presenter.BasePresenter;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.view
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutID());
        //初始化控件
        initView();
        //初始化presenter
        presenter = initPresenter();
        //绑定
        presenter.attachView(this);
        //初始化数据
        initData();
    }

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int layoutID();

    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatchView();
        }
    }
}
