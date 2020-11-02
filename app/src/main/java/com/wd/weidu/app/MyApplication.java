package com.wd.weidu.app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wd.weidu.model.RetrofitManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import io.realm.Realm;


/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo
 * @ClassName: MyApplication
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Realm.init(this);


        boolean net = RetrofitManager.getInstance().isNet(this);
        if (net) {
            Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        }
    }
}
