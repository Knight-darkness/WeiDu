package com.wd.weidu.view.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.weidu.R;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.net.NumberProgressBar;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.upapp.UpdateManager;
import com.wd.weidu.view.BaseActivity;

import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {

    private NumberProgressBar bnp;

    //延迟时间
    private static final int TIME = 15;
    //跳转计时
    private static int skip = 1;
    private static int skip_time = 11;
    int[] bag = {R.drawable.start_0, R.drawable.start_1, R.drawable.start_2, R.drawable.start_3, R.drawable.start_4, R.drawable.start_5,};


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {

                if (skip <= 100) {
                    skip++;
                    if (skip % 10 == 0) {
                        main_skip.setText(skip_time + "");
                        skip_time--;
                    }
                    bnp.setProgress(skip);
                    mHandler.sendEmptyMessageDelayed(0, TIME);
                } else {
                    goHome();
                }
            }
        }
    };
    private LinearLayout main_background;
    private TextView main_skip;


    @Override
    public void setData(String json, int i) {

    }

    @Override
    protected void initData() {
        int min = 0;
        int max = 4;
        Random random = new Random();
        int num = random.nextInt(max) % (max - min + 1) + min;
        main_background.setBackgroundResource(bag[num]);

    }

    @Override
    protected void initView() {


        bnp = (NumberProgressBar) findViewById(R.id.numberbar1);
        main_background = (LinearLayout) findViewById(R.id.main_background);
        main_skip = (TextView) findViewById(R.id.main_skip);

        new UpdateManager(this,"http://192.168.138.2:8080/version.json").checkUpdate();

        Message message = mHandler.obtainMessage();
        message.what = 0;
        mHandler.sendMessage(message);//发送信息

        /*setBackgroundResource(R.drawable.start_2);*/
        main_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_main;
    }

    private void goHome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);

    }

}