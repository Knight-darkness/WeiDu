package com.wd.weidu.adapter.shopping.cart;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.weidu.R;
import com.wd.weidu.model.bean.event.CalcPriceEvent;
import com.wd.weidu.model.bean.shopping.CartBean;
import com.wd.weidu.net.AddSubView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.logging.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.shopping.cart
 * @ClassName: ShoppingCartParticulars
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/24
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class ShoppingCartParticulars extends RecyclerView.Adapter<ShoppingCartParticulars.MyCartParticularsViewHolder> {
    List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList;

    public ShoppingCartParticulars(List<CartBean.ResultBean.ShoppingCartListBean> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }


    @NonNull
    @Override
    public MyCartParticularsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_cart_item_shopping, null);
        return new MyCartParticularsViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartParticularsViewHolder holder, int position) {
        CartBean.ResultBean.ShoppingCartListBean shoppingCartListBean = shoppingCartList.get(position);
        //数据的绑定
        holder.shoppingImage.setImageURI(shoppingCartListBean.getPic());
        holder.shoppingName.setText(shoppingCartListBean.getCommodityName());//商品名字
        holder.tvPrice.setText("$" + shoppingCartListBean.getPrice());//商品价格
        holder.addSubviewAsv.setValue(shoppingCartListBean.getCount());//商品数量
        holder.shoppingCheck.setChecked(shoppingCartListBean.isSelect());//商品是否选中,进行界面展示

        //实现点击改变
        holder.addSubviewAsv.setOnNumberChangerListener(new AddSubView.OnNumberChangerListener() {
            @Override
            public void onNumberChanger(int value) {
                shoppingCartList.get(position).setCount(value);
                EventBus.getDefault().post(new CalcPriceEvent());
            }
        });
        holder.shoppingCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                shoppingCartListBean.setSelect(isChecked);
                EventBus.getDefault().post(new CalcPriceEvent());

            }
        });

    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    public class MyCartParticularsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shopping_cart_check)
        CheckBox shoppingCheck;
        @BindView(R.id.shopping_image)
        SimpleDraweeView shoppingImage;
        @BindView(R.id.shopping_name)
        TextView shoppingName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.addsubview_asv)
        AddSubView addSubviewAsv;


        public MyCartParticularsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
