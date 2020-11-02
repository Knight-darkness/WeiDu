package com.wd.weidu.presenter;

import com.wd.weidu.view.IBaseView;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.presenter
 * @ClassName: BasePresenter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class BasePresenter<V extends IBaseView> {
    public V mView;

    //绑定
    public void attachView(V v) {
        mView = v;
    }

    //解绑
    public void deatchView() {
        mView = null;
    }
}
