package com.wd.weidu.adapter.circle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.weidu.R;
import com.wd.weidu.model.bean.query.MyCircleListBean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

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
public class MyCircleListAdapter extends XRecyclerView.Adapter<MyCircleListAdapter.MyViewHolder> {
    List<MyCircleListBean.ResultBean> result;

    public MyCircleListAdapter(List<MyCircleListBean.ResultBean> result) {
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_circle_mxrecycle, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //评价人头像
        Glide.with(holder.itemView).load(result.get(position).getHeadPic())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(holder.itemCircleHead);
        //评价人
        holder.itemCircleName.setText(result.get(position).getNickName());
        //评价时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        /*String format = simpleDateFormat.format(date);*/
        holder.itemCircleTime.setText(simpleDateFormat.format(result.get(position).getCreateTime()));
        //评价内容
        holder.itemCircleEvaluate.setText(result.get(position).getContent());
        //评价图片

        Glide.with(holder.itemView).load(result.get(position).getImage()).into(holder.itemCircleShow);


        //点赞数量
        holder.itemCircleGoodnum.setText(result.get(position).getGreatNum() + "");

        holder.itemCirclePraise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int greatNum = result.get(position).getGreatNum();
                if (isChecked) {
                    greatNum += 1;
                    holder.itemCircleGoodnum.setText(greatNum + "");
                } else {
                    holder.itemCircleGoodnum.setText(greatNum + "");

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyViewHolder extends XRecyclerView.ViewHolder {
        @BindView(R.id.item_circle_head)
        ImageView itemCircleHead;
        @BindView(R.id.item_circle_name)
        TextView itemCircleName;
        @BindView(R.id.item_circle_time)
        TextView itemCircleTime;
        @BindView(R.id.item_circle_evaluate)
        TextView itemCircleEvaluate;
        @BindView(R.id.item_circle_show)
        ImageView itemCircleShow;
        @BindView(R.id.item_circle_praise)
        CheckBox itemCirclePraise;
        @BindView(R.id.item_circle_goodnum)
        TextView itemCircleGoodnum;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
