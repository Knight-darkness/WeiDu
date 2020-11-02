package com.wd.weidu.adapter.order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.adapter.order.twoOrder.orderAllTwoAdapter;
import com.wd.weidu.model.RetrofitManager;
import com.wd.weidu.model.bean.pay.PayBean;
import com.wd.weidu.model.bean.orderForm.orderAllBean;

import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

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
public class orderAllAdapter extends RecyclerView.Adapter<orderAllAdapter.MyViewHolder> {
    List<orderAllBean.OrderListBean> orderList;


    public orderAllAdapter(List<orderAllBean.OrderListBean> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.item_order_all, null);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //订单号
        holder.itemOrderNameNum.setText(orderList.get(position).getOrderId());

        //订单时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        holder.itemCircleTime.setText(simpleDateFormat.format(orderList.get(position).getOrderTime()));
        int sumNum = 0;
        int sumMoney = 0;
        for (int j = 0; j < orderList.get(position).getDetailList().size(); j++) {

            sumNum += 1;
            sumMoney += orderList.get(position).getDetailList().get(j).getCommodityPrice();

        }
        if (orderList.get(position).getOrderStatus() == 1) {
            holder.itemOrderVisib.setVisibility(View.VISIBLE);
            holder.itemOrderVisib.setText("代付款");
            holder.itemOrderVisib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());

                    builder.setTitle("请选择支付方式！");
                    String[] strings = {"余额", "支付宝", "微信"};
                    builder.setSingleChoiceItems(strings, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            /*Toast.makeText(holder.itemView.getContext(), strings[which], Toast.LENGTH_SHORT).show();*/
                            if (which == 0) {
                                String orderId = orderList.get(position).getOrderId();
                                int payType = 1;

                                HashMap<String, Object> hashMap = new HashMap<>();
                                hashMap.put("orderId", orderId);
                                hashMap.put("payType", payType);
                                String string = new JSONObject(hashMap).toString();
                                RequestBody requestBody = RequestBody.create(MediaType.parse("Content-type:application/json"), string);


                                RetrofitManager.getInstance().create().getPay(orderId,payType)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Observer<ResponseBody>() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onNext(ResponseBody value) {
                                                try {
                                                    String string = value.string();
                                                    PayBean payBean = new Gson().fromJson(string, PayBean.class);
                                                    String message = payBean.getMessage();
                                                    notifyDataSetChanged();
                                                    Toast.makeText(holder.itemView.getContext(), "" + message, Toast.LENGTH_SHORT).show();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }

                                            @Override
                                            public void onError(Throwable e) {

                                            }

                                            @Override
                                            public void onComplete() {

                                            }
                                        });

                            }

                            dialog.dismiss();
                        }
                    });

                    builder.show();
                }
            });


        }


        holder.itemOrderGoodnum.setText("共" + sumNum + "种商品,总价:" + sumMoney + "元");


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(holder.itemView.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        holder.itemOrderAllRecycle.setLayoutManager(linearLayoutManager);
        holder.itemOrderAllRecycle.setAdapter(new orderAllTwoAdapter(orderList.get(position).getDetailList()));


    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_recycle)
        RecyclerView itemOrderAllRecycle;
        @BindView(R.id.item_order_name_num)
        TextView itemOrderNameNum;
        @BindView(R.id.item_order_time)
        TextView itemCircleTime;
        @BindView(R.id.item_order_goodnum)
        TextView itemOrderGoodnum;
        @BindView(R.id.item_order_praise)
        Button itemCirclePraise;
        @BindView(R.id.item_order_visib)
        Button itemOrderVisib;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
