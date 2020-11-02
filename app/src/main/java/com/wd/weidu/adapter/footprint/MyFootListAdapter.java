package com.wd.weidu.adapter.footprint;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.model.bean.foot.MyFootprintBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter.circle
 * @ClassName: MyCircleListAdapter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/23
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyFootListAdapter extends XRecyclerView.Adapter<MyFootListAdapter.MyViewHolder> {
    List<MyFootprintBean.ResultBean> result;


    public MyFootListAdapter(List<MyFootprintBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_foot_mxrecycle, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.footImage.setImageURI(result.get(position).getMasterPic());
        holder.footName.setText(result.get(position).getCommodityName());
        holder.footBrowse.setText("浏览次数" + result.get(position).getBrowseNum() + "次");
        holder.footMoney.setText("$" + result.get(position).getPrice());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        holder.footTime.setText(simpleDateFormat.format(result.get(position).getBrowseTime()));

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyViewHolder extends XRecyclerView.ViewHolder {
        @BindView(R.id.foot_image)
        SimpleDraweeView footImage;
        @BindView(R.id.foot_name)
        TextView footName;
        @BindView(R.id.foot_money)
        TextView footMoney;
        @BindView(R.id.foot_browse)
        TextView footBrowse;
        @BindView(R.id.foot_time)
        TextView footTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
