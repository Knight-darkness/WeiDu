package com.wd.weidu.view.activity.toactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.wd.weidu.R;
import com.wd.weidu.contract.IMainConstant;
import com.wd.weidu.model.bean.realm.RealmBean;
import com.wd.weidu.model.bean.up.HeadPicBean;
import com.wd.weidu.presenter.MainPresenter;
import com.wd.weidu.view.BaseActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.Realm;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ChangeDataActivity extends BaseActivity<MainPresenter> implements IMainConstant.IMainView {


    @BindView(R.id.change_up_head)
    RelativeLayout changeUpHead;
    @BindView(R.id.personal_id)
    ImageView personalId;
    @BindView(R.id.change_up_name)
    RelativeLayout changeUpName;
    @BindView(R.id.exit_id)
    Button exitId;
    @BindView(R.id.change_up_back)
    RelativeLayout changeUpBack;
    private Unbinder bind;
    private static final String TAG = "ChangeDataActivity";

    @Override
    public void setData(String json,int i) {
        HeadPicBean headPicBean = new Gson().fromJson(json, HeadPicBean.class);
        String headPath = headPicBean.getHeadPath();
        Toast.makeText(this, "" + headPath, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "setData: " + headPath);
        Glide.with(this).load(headPath)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(personalId);

    }

    @Override
    protected void initData() {
        changeUpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        changeUpHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_PICK);
                it.setType("image/*");
                startActivityForResult(it, 1000);
            }
        });
        exitId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear(ChangeDataActivity.this);
                finish();
            }
        });
    }

    /*
     * https://blog.csdn.net/a_man_coder/article/details/78085295  清空SharedPreferences
     * */
    //清空SharedPreferences
    public static void clear(Context context) {
        SharedPreferences user = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = user.edit();
        edit.putBoolean("loginState", false);
       /* edit.putString("userId", "");
        edit.putString("sessionId", "");
        edit.putString("headPic", "");
        edit.putString("nickName", "");*/

        Realm realm = Realm.getDefaultInstance();
        RealmBean userRealm = new RealmBean();
        userRealm.sessionId = null;
        userRealm.userId = 0;
        userRealm.headPic = null;
        userRealm.nickName = null;
        //开启事务,并提交
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(userRealm);
        realm.commitTransaction();
        edit.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Intent it = new Intent("com.android.camera.action.CROP");
            it.setDataAndType(uri, "image/*");
            it.putExtra("CROP", true);
            it.putExtra("return-data", true);
            startActivityForResult(it, 2000);
        }
        if (requestCode == 2000 && resultCode == RESULT_OK) {
            Bitmap mBitMap = data.getParcelableExtra("data");
            personalId.setImageBitmap(mBitMap);
            File file = getFile(mBitMap);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
            presenter.getHeadPicData(part);
        }
    }


    private File getFile(Bitmap mBitMap) {
        String defaultGoodInfo = getApplicationContext().getFilesDir().getAbsolutePath() + "defaultGoodInfo";
        File file = new File(defaultGoodInfo);
        if (!file.exists()) {
            file.mkdirs();
        }
        String defaultGoodPath = defaultGoodInfo + "/messageImage.jpg";
        file = new File(defaultGoodPath);
        try {
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);
            mBitMap.compress(Bitmap.CompressFormat.PNG, 20, fOut);
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected int layoutID() {
        return R.layout.activity_change_data;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }


}
