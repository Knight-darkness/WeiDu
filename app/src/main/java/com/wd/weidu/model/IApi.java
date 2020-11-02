package com.wd.weidu.model;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * @ProjectName: Wangyizhuo20201019
 * @Package: com.bawei.wangyizhuo.model
 * @ClassName: IApi
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/19
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public interface IApi {

    //登录
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("user/v1/login")
    Observable<ResponseBody> getLoginData(@Body RequestBody requestBody);

    //注册
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("user/v1/register")
    Observable<ResponseBody> getRegisterData(@Body RequestBody requestBody);

    //照片上传
    @Multipart
    @POST("user/verify/v1/modifyHeadPic")
    Observable<ResponseBody> getPhotoPut(@Part MultipartBody.Part file);

    //我的圈子
    @GET("circle/verify/v1/findMyCircleById?page=1&count=5")
    Observable<ResponseBody> getMyCircleById();

    //商品详情页中的XBanner----fragment_home
    @GET("commodity/v1/bannerShow")
    Observable<ResponseBody> getXBannerById();

    //shopping首页
    @GET("commodity/v1/commodityList")
    Observable<ResponseBody> getShoppingAll();


    //查询圈子
    @GET("circle/v1/findCircleList?page=1&count=10")
    Observable<ResponseBody> getCircleList();

    //查询购物车
    @GET("order/verify/v1/findShoppingCart")
    Observable<ResponseBody> getCartData();

    //查询订单
    @GET("order/verify/v1/findOrderListByStatus?count=5&page=1")
    Observable<ResponseBody> getOrderListByStatus(@Query("status") int status);

    //查询商品详情
    @GET("commodity/v1/findCommodityDetailsById")
    Observable<ResponseBody> getInfo(@Query("commodityId") int commodityId);

    //创建订单
    @FormUrlEncoded
    @POST("order/verify/v1/createOrder")
    Observable<ResponseBody> createOrder(@Field("orderInfo") String orderInfo, @Field("totalPrice") double totalPrice, @Field("addressId") int addressId);


    //支付
    @FormUrlEncoded
    @POST("order/verify/v1/pay")
    Observable<ResponseBody> getPay(@Field("orderId") String orderId, @Field("payType") int payType);


    //我的评价
    @GET("commodity/verify/v1/browseList?page=1&count=5")
    Observable<ResponseBody> getFootPrint();

    //我的钱包
    @GET("user/verify/v1/findUserWallet?page=1&count=20")
    Observable<ResponseBody> getWallet();


}
