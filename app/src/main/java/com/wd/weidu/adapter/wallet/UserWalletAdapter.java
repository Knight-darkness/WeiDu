package com.wd.weidu.adapter.wallet;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.weidu.R;
import com.wd.weidu.model.bean.wallet.UserWalletBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.wallet
 * @ClassName: UserWalletAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/11/2 15:39
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class UserWalletAdapter extends RecyclerView.Adapter<UserWalletAdapter.MyViewHolder> {
    List<UserWalletBean.ResultBean.DetailListBean> detailList;


    public UserWalletAdapter(List<UserWalletBean.ResultBean.DetailListBean> detailList) {
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_walle_all, null);

        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.wootmoney.setText("$ " + detailList.get(position).getAmount());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        /*String format = simpleDateFormat.format(date);*/
        holder.woottime.setText(simpleDateFormat.format(detailList.get(position).getConsumerTime()));

    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.wootmoney)
        TextView wootmoney;
        @BindView(R.id.woottime)
        TextView woottime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
