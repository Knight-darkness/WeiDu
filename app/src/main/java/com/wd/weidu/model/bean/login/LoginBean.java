package com.wd.weidu.model.bean.login;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean
 * @ClassName: LoginBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/21
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class LoginBean {

    /**
     * result : {"headPic":"http://172.17.8.100/images/small/head_pic/2020-10-17/20201017103445.jpg","nickName":"wg_Gx670","phone":"15137430789","sessionId":"160326153429113945","sex":1,"userId":13945}
     * message : 登录成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {

        public String headPic;
        public String nickName;
        public String phone;
        public String sessionId;
        public int sex;
        public int userId;
    }
}
