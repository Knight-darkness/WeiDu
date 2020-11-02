package com.wd.weidu.view.fragment;


import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.adapter.circle.MyCircleListAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.query.MyCircleListBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleListFragment extends BaseFragment<MainPresenter> implements IMainConstant.IMainView {


    @BindView(R.id.circle_mXRecycle)
    XRecyclerView circleMXRecycle;
    private Unbinder bind;

    private int page = 1;

    @Override
    public void setData(String json, int i) {
        circleMXRecycle.setPullRefreshEnabled(true);
        circleMXRecycle.setLoadingMoreEnabled(true);




        MyCircleListBean myCircleListBean = new Gson().fromJson(json, MyCircleListBean.class);
        String status = myCircleListBean.getStatus();
        if (status.equals("0000")) {
            List<MyCircleListBean.ResultBean> result = myCircleListBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            circleMXRecycle.setLayoutManager(linearLayoutManager);
            MyCircleListAdapter adapter = new MyCircleListAdapter(result);
            if (page == 1) {
                adapter.notifyDataSetChanged();


                complete();
            }

            circleMXRecycle.setAdapter(adapter);

            complete();

        }

    }

    private void complete() {
        circleMXRecycle.refreshComplete();
        circleMXRecycle.loadMoreComplete();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.getCircleList();


        circleMXRecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenter.getCircleList();
            }

            @Override
            public void onLoadMore() {
                page = 2;
                presenter.getCircleList();
            }
        });

        //设置数据间距
        circleMXRecycle.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                Resources resources = getContext().getResources();
                int pos = parent.getChildLayoutPosition(view); //当前条目的position
                int itemCount = state.getItemCount() - 1;

                if (pos != itemCount) {
                    outRect.top = (int) resources.getDimension(R.dimen.dp_12);
                }
            }
        });

    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);
    }

    //解除butterknife
    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_circle_list;
    }
}
