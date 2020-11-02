package com.wd.weidu.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import com.wd.weidu.app.MyApplication;
import com.wd.weidu.model.bean.realm.RealmBean;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_APPEND;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.model
 * @ClassName: RetrofitManager
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class RetrofitManager {

    private final Retrofit mRetrofit;

    //单例
    private static final class RetrofitManagerHolder {
        private static final RetrofitManager INSTANT = new RetrofitManager();
    }

    public static RetrofitManager getInstance() {
        return RetrofitManagerHolder.INSTANT;
    }

    //构建okhttpclient
    private OkHttpClient mOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("userId", String.valueOf(mUserId))
                                .addHeader("sessionId", mSessionId + "");
                        Request request = builder.build();
                        return chain.proceed(request);
                    }
                })
                .build();
    }

    //构建retrofit
    private RetrofitManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(mOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static int mUserId;
    private static String mSessionId;

    //构建IApi接口
    public IApi create() {
        Realm realm = Realm.getDefaultInstance();
        RealmBean first = realm.where(RealmBean.class).findFirst();
        if (first != null) {
            mUserId = first.userId;
            mSessionId = first.sessionId;
        }
 /*       SharedPreferences user = MyApplication.context.getSharedPreferences("user", MODE_APPEND);
        String sessionId = user.getString("sessionId", "");
        String userId = user.getString("userId", "");
        if (sessionId != null && userId != null) {
            mUserId = userId;
            mSessionId = sessionId;

        }*/
        return mRetrofit.create(IApi.class);
    }

    //网络判断
    public boolean isNet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
}
