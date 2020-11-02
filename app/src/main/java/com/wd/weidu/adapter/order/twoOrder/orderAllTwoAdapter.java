package com.wd.weidu.adapter.order.twoOrder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.weidu.R;
import com.wd.weidu.model.bean.orderForm.orderAllBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.order
 * @ClassName: orderAllAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/28
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class orderAllTwoAdapter extends RecyclerView.Adapter<orderAllTwoAdapter.MyViewHolder> {
    List<orderAllBean.OrderListBean.DetailListBean> detailList;


    public orderAllTwoAdapter(List<orderAllBean.OrderListBean.DetailListBean> detailList) {
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_order_to_all, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String commodityPic = detailList.get(position).getCommodityPic();
        String[] split = commodityPic.split(",");
        final ArrayList<String> list = new ArrayList<>();
        for (int it = 0; it <= split.length - 1; it++) {
            list.add(split[it]);
        }
        holder.orderImage.setImageURI(list.get(0));//图片
        holder.orderName.setText(detailList.get(position).getCommodityName());
        holder.orderPrice.setText("$ :" + detailList.get(position).getCommodityPrice());
        

    }

    private interface thingNum {
        void onThingNum(String data);
    }


    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_image)
        SimpleDraweeView orderImage;
        @BindView(R.id.order_name)
        TextView orderName;
        @BindView(R.id.order_price)
        TextView orderPrice;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
