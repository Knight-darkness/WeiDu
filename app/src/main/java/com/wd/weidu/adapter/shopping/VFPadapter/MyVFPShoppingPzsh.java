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
public class MyVFPShoppingPzsh extends XRecyclerView.Adapter<MyVFPShoppingPzsh.MyVFPViewholder> {
    List<shoppingAllBean.ResultBean.PzshBean.CommodityListBeanX> result;

    public MyVFPShoppingPzsh(List<shoppingAllBean.ResultBean.PzshBean.CommodityListBeanX> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyVFPViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.rex_item_pzsh, null);
        return new MyVFPViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVFPViewholder holder, int position) {
        holder.pzshSdv.setImageURI(result.get(position).getMasterPic());
        holder.pzshTvName.setText(result.get(position).getCommodityName() + "");
        holder.pzshTvPrice.setText(result.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyVFPViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.pzsh_sdv)
        SimpleDraweeView pzshSdv;
        @BindView(R.id.pzsh_tv_name)
        TextView pzshTvName;
        @BindView(R.id.pzsh_tv_price)
        TextView pzshTvPrice;

        public MyVFPViewholder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

