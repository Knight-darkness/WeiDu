package com.wd.weidu.adapter.shopping.VFPadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.model.bean.shopping.shoppingAllBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.shopping.VFPadapter
 * @ClassName: MyVFPShoppingRxxp
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/23
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyVFPShoppingRxxp extends XRecyclerView.Adapter<MyVFPShoppingRxxp.MyVFPViewholder> {
    List<shoppingAllBean.ResultBean.RxxpBean.CommodityListBean> result;

    public MyVFPShoppingRxxp(List<shoppingAllBean.ResultBean.RxxpBean.CommodityListBean> result) {
        this.result = result;
    }


    @NonNull
    @Override
    public MyVFPViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.rex_item_rxxp, null);
        return new MyVFPViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVFPViewholder holder, int position) {
        holder.rxxpSdv.setImageURI(result.get(position).getMasterPic());
        holder.rxxpTvName.setText(result.get(position).getCommodityName() + "");
        holder.rxxpTvPrice.setText(result.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyVFPViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.rxxp_sdv)
        SimpleDraweeView rxxpSdv;
        @BindView(R.id.rxxp_tv_name)
        TextView rxxpTvName;
        @BindView(R.id.rxxp_tv_price)
        TextView rxxpTvPrice;


        public MyVFPViewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

