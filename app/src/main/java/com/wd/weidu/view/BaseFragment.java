package com.wd.weidu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.wd.weidu.R;
import com.wd.weidu.presenter.BasePresenter;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.view
 * @ClassName: BaseFragment
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/20
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    private View view;
    public P presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(layoutId(), container, false);
        //绑定控件
        initView(view);
        //初始化presenter
        presenter = initPresenter();
        //绑定
        presenter.attachView(this);
        return view;
    }

    protected abstract P initPresenter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //初始化数据
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int layoutId();

    //解绑

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatchView();
        }
    }
}
