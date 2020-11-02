package com.wd.weidu.contract;

import com.wd.weidu.view.IBaseView;

import okhttp3.MultipartBody;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.contract
 * @ClassName: IMainContract
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public interface IMainConstant {

    interface IMainView extends IBaseView {
        void setData(String json, int i);
    }

    interface IMainPresenter {
        //登录
        void getLoginData(String phone, String pwd);

        //注册
        void getRegisterData(String phone, String pwd);

        //头像上传
        void getHeadPicData(MultipartBody.Part body);

        //我的圈子
        void getMyCircleById();

        //XBanner
        void getXBannerById();

        //shopping首页
        void getShoppingAll();

        //圈子列表
        void getCircleList();

        //购物车列表
        void getShoppingCart();

        //订单列表
        void getOrderListBy(int status);

        //支付
        void getPay(String orderId, int payType);

        //我的评价
        void getFootPrint();

        void getWallet();

    }

}
