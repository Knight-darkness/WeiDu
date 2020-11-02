package com.wd.weidu.adapter.shopping.VFPadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
public class MyVFPShoppingMiss extends XRecyclerView.Adapter<MyVFPShoppingMiss.MyVFPViewholder> {
    List<shoppingAllBean.ResultBean.MlssBean.CommodityListBeanXX> result;

    public MyVFPShoppingMiss(List<shoppingAllBean.ResultBean.MlssBean.CommodityListBeanXX> result) {
        this.result = result;
    }


    @NonNull
    @Override
    public MyVFPViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.rex_item_mlss, null);
        return new MyVFPViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVFPViewholder holder, int position) {
        holder.mlssSdv.setImageURI(result.get(position).getMasterPic());
        holder.mlssTvName.setText(result.get(position).getCommodityName() + "");
        holder.mlssTvPrice.setText(result.get(position).getPrice() + "");
        


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyVFPViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.mlss_sdv)
        SimpleDraweeView mlssSdv;
        @BindView(R.id.mlss_tv_name)
        TextView mlssTvName;
        @BindView(R.id.mlss_tv_price)
        TextView mlssTvPrice;

        public MyVFPViewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

