package com.wd.weidu.adapter;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.weidu.R;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.adapter
 * @ClassName: MyRecycleInterval
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/23
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyRecycleInterval extends RecyclerView.ItemDecoration {

    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Resources resources = view.getResources();
        int pos = parent.getChildLayoutPosition(view); //当前条目的position
        int itemCount = state.getItemCount() - 1;
        //最后一条数据
        if (pos == itemCount) {
            outRect.top = (int) resources.getDimension(R.dimen.dp_12);
            outRect.left = (int) resources.getDimension(R.dimen.dp_12);
            outRect.right = (int) resources.getDimension(R.dimen.dp_12);
            outRect.bottom = (int) resources.getDimension(R.dimen.dp_12);
        }
        //第一条数据
        if (pos == 0) {
            outRect.left = (int) resources.getDimension(R.dimen.dp_m_30);
            outRect.bottom = (int) resources.getDimension(R.dimen.dp_m_12);
        }
        if (pos != itemCount) {
            outRect.top = (int) resources.getDimension(R.dimen.dp_12);
            outRect.right = (int) resources.getDimension(R.dimen.dp_12);
            outRect.left = (int) resources.getDimension(R.dimen.dp_12);
            outRect.bottom = (int) resources.getDimension(R.dimen.dp_12);
        }
    }
}
