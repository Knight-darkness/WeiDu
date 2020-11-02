package com.wd.weidu.presenter;

import android.util.Log;

import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.RetrofitManager;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.presenter
 * @ClassName: MainPresenter
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MainPresenter extends BasePresenter<IMainConstant.IMainView> implements IMainConstant.IMainPresenter {

    //登录
    @Override
    public void getLoginData(String phone, String pwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone + "");
        map.put("pwd", pwd + "");
        String toJs = new JSONObject(map).toString();

        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-type:application/json"), toJs);

        RetrofitManager.getInstance().create()
                .getLoginData(requestBody)
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
                            Log.i("login", "onNext: " + string);
                            mView.setData(string, 1);
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

    //注册
    @Override
    public void getRegisterData(String phone, String pwd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("pwd", pwd);
        String toJs = new JSONObject(map).toString();

        RequestBody requestBody = RequestBody.create(MediaType.parse("Content-type:application/json"), toJs);

        RetrofitManager.getInstance().create()
                .getRegisterData(requestBody)
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
                            Log.i("Register", "onNext: " + string);
                            mView.setData(string, 1);
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

    //上传头像
    @Override
    public void getHeadPicData(MultipartBody.Part body) {
        RetrofitManager.getInstance().create()
                .getPhotoPut(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("HeadPic", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    //我的圈子
    @Override
    public void getMyCircleById() {
        RetrofitManager.getInstance().create()
                .getMyCircleById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("myquanzi", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    //商品详情xbanner
    @Override
    public void getXBannerById() {
        RetrofitManager.getInstance().create()
                .getXBannerById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("xbanner", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    //查询主页购物信息
    @Override
    public void getShoppingAll() {
        RetrofitManager.getInstance().create()
                .getShoppingAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("ShoppingAll", "onNext: " + jsonData);
                            mView.setData(jsonData, 2);
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

    //圈子列表
    @Override
    public void getCircleList() {
        RetrofitManager.getInstance().create()
                .getCircleList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("quanzi", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    //查询购物车
    @Override
    public void getShoppingCart() {
        RetrofitManager.getInstance().create()
                .getCartData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("Cart", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    //查询订单
    @Override
    public void getOrderListBy(int status) {
        RetrofitManager.getInstance().create()
                .getOrderListByStatus(status)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("OrderList", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    @Override
    public void getPay(String orderId, int payType) {
        //orderAllAdapter中
    }

    @Override
    public void getFootPrint() {
        RetrofitManager.getInstance().create()
                .getFootPrint()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String jsonData = value.string();
                            Log.i("OrderList", "onNext: " + jsonData);
                            mView.setData(jsonData, 1);
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

    @Override
    public void getWallet() {
        RetrofitManager.getInstance().create()
                .getWallet()
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
                            Log.i("wallet", "onNext: " + string);
                            mView.setData(string, 1);
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


}
