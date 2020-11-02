package com.wd.weidu.adapter.shopping;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.adapter.MyRecycleInterval;
import com.wd.weidu.adapter.shopping.VFPadapter.MyVFPShoppingMiss;
import com.wd.weidu.adapter.shopping.VFPadapter.MyVFPShoppingPzsh;
import com.wd.weidu.adapter.shopping.VFPadapter.MyVFPShoppingRxxp;
import com.wd.weidu.model.bean.shopping.shoppingAllBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.shopping
 * @ClassName: MyShoppingAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/23
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyShoppingAdapter extends XRecyclerView.Adapter<MyShoppingAdapter.MyViewholder> {
    shoppingAllBean.ResultBean result;

    public MyShoppingAdapter(shoppingAllBean.ResultBean result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.home_item_shopping_all, null);

        return new MyViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        
        //展示热销新品rxxp
        List<shoppingAllBean.ResultBean.RxxpBean.CommodityListBean> commodityList = result.getRxxp().getCommodityList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        holder.fmShoppingRxxp.setLayoutManager(linearLayoutManager);
        holder.fmShoppingRxxp.setAdapter(new MyVFPShoppingRxxp(commodityList));
        holder.fmShoppingRxxp.addItemDecoration(new MyRecycleInterval());


        //展示魔丽时尚miss
        List<shoppingAllBean.ResultBean.MlssBean.CommodityListBeanXX> commodityListBeanXXES = result.getMlss().getCommodityList();
        LinearLayoutManager linearLayoutManagermlss = new LinearLayoutManager(holder.itemView.getContext());
        holder.fmShoppingMlss.setLayoutManager(linearLayoutManagermlss);
        holder.fmShoppingMlss.setAdapter(new MyVFPShoppingMiss(commodityListBeanXXES));
        holder.fmShoppingMlss.addItemDecoration(new MyRecycleInterval());
        //展示品质生活pzsh
        List<shoppingAllBean.ResultBean.PzshBean.CommodityListBeanX> commodityListBeanXES = result.getPzsh().getCommodityList();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(holder.itemView.getContext(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        holder.fmShoppingPzsh.setLayoutManager(gridLayoutManager);
        holder.fmShoppingPzsh.setAdapter(new MyVFPShoppingPzsh(commodityListBeanXES));
        holder.fmShoppingPzsh.addItemDecoration(new MyRecycleInterval());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.fm_shopping_rxxp_recy)
        RecyclerView fmShoppingRxxp;
        @BindView(R.id.fm_shopping_mlss_recy)
        RecyclerView fmShoppingMlss;
        @BindView(R.id.fm_shopping_pzsh_recy)
        RecyclerView fmShoppingPzsh;
        @BindView(R.id.scrollView2)
        ScrollView scrollView2;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
