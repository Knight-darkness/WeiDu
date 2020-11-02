package com.wd.weidu.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.wd.weidu.R;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.net
 * @ClassName: AddSubView
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/24
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class AddSubView extends FrameLayout implements View.OnClickListener {
    private TextView iv_sub;
    private TextView iv_add;
    private TextView tv_value;
    private int value = 1;

    public AddSubView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public AddSubView(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AddSubView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context) {
        View inflate = View.inflate(context, R.layout.add_sub_view, this);
        iv_sub = (TextView) inflate.findViewById(R.id.iv_sub);
        iv_add = (TextView) inflate.findViewById(R.id.iv_add);
        tv_value = (TextView) inflate.findViewById(R.id.tv_value);

        iv_sub.setOnClickListener(this);
        iv_add.setOnClickListener(this);

        //获取TeXView的值
        value = getValue();
        //设置TextView的值
        setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
        tv_value.setText(value + "");
    }

    private int getValue() {
        //从TextView里拿出内容
        String trim = tv_value.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            value = Integer.valueOf(trim);
        }
        return value;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_add:
                if (value < 10) {
                    value++;
                }
                setValue(value);
                mOnNumberChangerListener.onNumberChanger(value);
                break;
            case R.id.iv_sub:
                if (value > 1) {
                    value--;
                }
                setValue(value);
                mOnNumberChangerListener.onNumberChanger(value);
                break;
        }
    }

    public interface OnNumberChangerListener {
        void onNumberChanger(int value);
    }

    private OnNumberChangerListener mOnNumberChangerListener;

    public void setOnNumberChangerListener(OnNumberChangerListener onNumberChangerListener) {
        mOnNumberChangerListener = onNumberChangerListener;
    }
}