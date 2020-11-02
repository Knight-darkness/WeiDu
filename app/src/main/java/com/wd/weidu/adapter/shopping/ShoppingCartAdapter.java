package com.wd.weidu.adapter.shopping;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.weidu.R;
import com.wd.weidu.adapter.shopping.cart.ShoppingCartParticulars;
import com.wd.weidu.model.bean.shopping.CartBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyShoppingCartViewHolder> {
    List<CartBean.ResultBean> result;

    public ShoppingCartAdapter(List<CartBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyShoppingCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_cart_shopping, null);
        return new MyShoppingCartViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyShoppingCartViewHolder holder, int position) {
        holder.shoppingCheck.setText(result.get(position).getCategoryName());
        //二级列表
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        holder.itemCartShoppingRecycle.setLayoutManager(linearLayoutManager);

        List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList = result.get(position).getShoppingCartList();
        holder.itemCartShoppingRecycle.setAdapter(new ShoppingCartParticulars(shoppingCartList));

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyShoppingCartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shopping_check)
        TextView shoppingCheck;
        @BindView(R.id.item_cart_shopping_recycle)
        RecyclerView itemCartShoppingRecycle;

        public MyShoppingCartViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
