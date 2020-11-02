package com.wd.weidu.view.fragment;


import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.adapter.shopping.MyShoppingAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.shopping.bannerShowBean;
import com.wd.weidu.model.bean.shopping.shoppingAllBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<MainPresenter> implements IMainConstant.IMainView {


    @BindView(R.id.home_banner)
    Banner homeBanner;
    @BindView(R.id.home_fm_rv)
    XRecyclerView homeFmRv;
    private Unbinder bind;
    private int page = 1;

    @Override
    public void setData(String json, int i) {


        switch (i) {
            case 1:
                //banner数据处理
                showBanner(json);
                break;
            case 2:
                //商品处理数据
                setShopping(json);
                break;
        }


    }

    private void showBanner(String json) {
        bannerShowBean bannerShowBean = new Gson().fromJson(json, bannerShowBean.class);
        List<com.wd.weidu.model.bean.shopping.bannerShowBean.ResultBean> result = bannerShowBean.result;
        ArrayList<String> imagelist = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            imagelist.add(result.get(i).imageUrl);
        }
        homeBanner.setImages(imagelist);
        homeBanner.setDelayTime(3000);
        homeBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        homeBanner.setImageLoader(new ImageLoader() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Uri parse = Uri.parse((String) path);
                imageView.setImageURI(parse);

            }

            @Override
            public ImageView createImageView(Context context) {
                SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
                return simpleDraweeView;
            }
        });
        homeBanner.start();

    }


    //商品数据
    private void setShopping(String json) {



        homeFmRv.setPullRefreshEnabled(true);
        homeFmRv.setLoadingMoreEnabled(true);

        shoppingAllBean shoppingAllBean = new Gson().fromJson(json, shoppingAllBean.class);
        if (shoppingAllBean.getStatus().equals("0000")) {
            com.wd.weidu.model.bean.shopping.shoppingAllBean.ResultBean result = shoppingAllBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            homeFmRv.setLayoutManager(linearLayoutManager);
            MyShoppingAdapter adapter = new MyShoppingAdapter(result);
            if (page == 1) {
                adapter.notifyDataSetChanged();
                complete();
            }
            homeFmRv.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "获取数据事变", Toast.LENGTH_SHORT).show();
        }

    }

    private void complete() {
        homeFmRv.refreshComplete();
        homeFmRv.loadMoreComplete();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        //获取xbanner数据
        presenter.getXBannerById();
        //获取商品详情
        presenter.getShoppingAll();

        homeFmRv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenter.getShoppingAll();
            }

            @Override
            public void onLoadMore() {
                page = 2;
                presenter.getShoppingAll();
            }
        });
    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
