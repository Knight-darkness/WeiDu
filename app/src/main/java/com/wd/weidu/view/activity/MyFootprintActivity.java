package com.wd.weidu.view.activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.adapter.footprint.MyFootListAdapter;
import com.wd.weidu.app.MyApplication;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.foot.MyFootprintBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.internal.Context;

public class MyFootprintActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {
    @BindView(R.id.foot_mRecycle)
    RecyclerView footMXRecycle;
    private Unbinder bind;

    @Override
    public void setData(String json, int i) {

        MyFootprintBean myFootprintBean = new Gson().fromJson(json, MyFootprintBean.class);
        if (myFootprintBean.getMessage().equals("0000")) {
            List<MyFootprintBean.ResultBean> result = myFootprintBean.getResult();
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MyFootprintActivity.this, 2, GridLayoutManager.VERTICAL, false);

            footMXRecycle.setLayoutManager(gridLayoutManager);
            MyFootListAdapter adapter = new MyFootListAdapter(result);
            footMXRecycle.setAdapter(adapter);

        }
    }


    @Override
    protected void initData() {
        presenter.getFootPrint();

        //设置数据间距
        footMXRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                Resources resources = getApplicationContext().getResources();
                int pos = parent.getChildLayoutPosition(view); //当前条目的position
                int itemCount = state.getItemCount() - 1;

                if (pos != itemCount) {
                    outRect.top = (int) resources.getDimension(R.dimen.dp_12);
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
        bind = ButterKnife.bind(this);

    }

    //解除butterknife
    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_my_footprint;
    }


}
