package com.wd.weidu.view.fragment;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.adapter.shopping.ShoppingCartAdapter;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.RetrofitManager;
import com.wd.weidu.model.bean.add.CreateOrderBean;
import com.wd.weidu.model.bean.event.CalcPriceEvent;
import com.wd.weidu.model.bean.shopping.CartBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCartFragment extends BaseFragment<MainPresenter> implements IMainConstant.IMainView {

    @BindView(R.id.iv_category)
    TextView tvCategory;
    @BindView(R.id.shoppingCartAll)
    LinearLayout shoppingCartAll;
    @BindView(R.id.rv_shopping_cart)
    RecyclerView rvShoppingCart;
    @BindView(R.id.cb_all)
    CheckBox checkAll;
    @BindView(R.id.tv_allprice)
    TextView tvAllPrice;
    @BindView(R.id.tv_allnum)
    TextView tvAllNum;
    @BindView(R.id.closeAccounts)
    Button closeAccounts;
    private Unbinder bind;

    private static final String TAG = "ShoppingCartFragment";
    private ShoppingCartAdapter cartAdapter;
    private int price;
    private List<CartBean.ResultBean> result;
    private int commodityId;

    @Override
    public void setData(String json, int i) {
        CartBean cartBean = new Gson().fromJson(json, CartBean.class);
        if (cartBean.getStatus().equals("0000")) {
            Log.i(TAG, "setData: " + json);
            result = cartBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
            rvShoppingCart.setLayoutManager(linearLayoutManager);

            cartAdapter = new ShoppingCartAdapter(result);
            rvShoppingCart.setAdapter(cartAdapter);
            changeAll(result);
            calcAll();

            closeAccounts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    RetrofitManager.getInstance().create()
                            .createOrder("[{\"commodityId\":26,\"amount\":1},{\"commodityId\":19,\"amount\":1}]", 207, 14049)
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
                                        CreateOrderBean createOrderBean = new Gson().fromJson(string, CreateOrderBean.class);
                                        String message = createOrderBean.getMessage();
                                        Toast.makeText(getActivity(), message + "", Toast.LENGTH_SHORT).show();

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
            });

        } else {
            shoppingCartAll.setBackgroundResource(R.drawable.data_null);
        }

    }

    private void changeAll(List<CartBean.ResultBean> result) {

        checkAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = checkAll.isChecked();
                checkAll.setChecked(checked);
                for (int i = 0; i < result.size(); i++) {
                    for (int j = 0; j < result.get(i).getShoppingCartList().size(); j++) {
                        //我通过选中框的监听,然后看用户是否改变选中框的状态,如果改变,记录到Bean类中
                        result.get(i).getShoppingCartList().get(j).setSelect(checked);
                        //其他不做处理
                        calcAll();
                    }
                    cartAdapter.notifyDataSetChanged();
                }
            }
        });
    }


    private int allPrice;//总价
    private int allNum;//总数量
    private boolean isSelectAll = true; //所有的商品是否选中

    private void calcAll() {
        //因为Bean类里有缓存的数据和UI界面不一样,所以为了保持一致,我把数据重置
        allPrice = 0;
        allNum = 0;
        isSelectAll = true;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).getShoppingCartList().size(); j++) {
                if (result.get(i).getShoppingCartList().get(j).isSelect()) {
                    commodityId = result.get(i).getShoppingCartList().get(j).getCommodityId();
                    allPrice += result.get(i).getShoppingCartList().get(j).getPrice() * result.get(i).getShoppingCartList().get(j).getCount();
                    allNum += result.get(i).getShoppingCartList().get(j).getCount();

                } else {
                    isSelectAll = false;
                }
            }
        }

        tvAllPrice.setText("合计 : $ " + allPrice);
        tvAllNum.setText("合计 : " + allNum + "件商品");
        checkAll.setChecked(isSelectAll);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCalcPrice(CalcPriceEvent calcPriceEvent) {
        calcAll();
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.getShoppingCart();


    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this, view);
    }


    @Override
    protected int layoutId() {
        return R.layout.fragment_shopping_cart;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}