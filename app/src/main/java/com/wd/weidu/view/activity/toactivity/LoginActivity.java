package com.wd.weidu.view.activity.toactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.login.LoginBean;
import com.wd.weidu.model.bean.realm.RealmBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;

import io.realm.Realm;

public class LoginActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {


    private EditText main_phone;
    private EditText main_pwd;
    private ImageView show_pwd;
    private Button main_login;
    private Button main_register;
    private boolean isOpenEye = false;

    @Override
    protected void initData() {

        show_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpenEye) {
                    isOpenEye = true;
                    main_pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //密码不可见
                    isOpenEye = false;
                    main_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        //登录
        main_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = main_phone.getText().toString();
                String pwd = main_pwd.getText().toString();
                presenter.getLoginData(phone, pwd);

            }
        });
        //注册
        main_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        main_phone = (EditText) findViewById(R.id.main_phone);
        main_pwd = (EditText) findViewById(R.id.main_pwd);
        show_pwd = (ImageView) findViewById(R.id.show_pwd);
        main_login = (Button) findViewById(R.id.main_login);
        main_register = (Button) findViewById(R.id.main_register);
    }

    @Override
    public void setData(String json,int i) {
        LoginBean loginBean = new Gson().fromJson(json, LoginBean.class);
        String message = loginBean.message;
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        if (loginBean.status.equals("0000")) {
/*            SharedPreferences user = getSharedPreferences("user", MODE_APPEND);
            SharedPreferences.Editor edit = user.edit();
            int userId = loginBean.result.userId;
            String sessionId = loginBean.result.sessionId;
            String headPic = loginBean.result.headPic;
            String nickName = loginBean.result.nickName;

            edit.putBoolean("loginState", true);
            edit.putString("userId", String.valueOf(userId));
            edit.putString("sessionId", sessionId);
            edit.putString("headPic", headPic);
            edit.putString("nickName", nickName);
            edit.commit();*/

            SharedPreferences user = getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor edit = user.edit();
            edit.putBoolean("loginState", true);
            edit.commit();
            //进行数据缓存
            int userId = loginBean.result.userId;
            String sessionId = loginBean.result.sessionId;
            String headPic = loginBean.result.headPic;
            String nickName = loginBean.result.nickName;
            Realm realm = Realm.getDefaultInstance();
            RealmBean userRealm = new RealmBean();
            userRealm.sessionId = sessionId;
            userRealm.userId = userId;
            userRealm.headPic = headPic;
            userRealm.nickName = nickName;
            //开启事务,并提交
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(userRealm);
            realm.commitTransaction();

            finish();

        }


    }

    @Override
    protected int layoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatchView();
        }
    }

/*    private void submit() {
        // validate
        String phone = main_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = main_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "pwd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

    }*/
}