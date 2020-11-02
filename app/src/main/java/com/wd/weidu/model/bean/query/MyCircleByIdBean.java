package com.wd.weidu.model.bean.query;

import java.util.List;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean.query
 * @ClassName: MyCircleByIdBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/22
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyCircleByIdBean {


    /**
     * result : [{"commodityId":5,"content":"按时","createTime":1602813955000,"greatNum":0,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-10-21/20201021233359.jpg","id":4940,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-10-15/5273820201015210555.png","nickName":"王某人","userId":81057,"whetherGreat":1},{"commodityId":6,"content":"啊啊啊","createTime":1602552859000,"greatNum":1,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-10-21/20201021233359.jpg","id":4926,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-10-12/9482520201012203419.png","nickName":"王某人","userId":81057,"whetherGreat":1},{"commodityId":17,"content":"..........","createTime":1602532894000,"greatNum":2,"headPic":"http://mobile.bwstudent.com/images/small/head_pic/2020-10-21/20201021233359.jpg","id":4920,"image":"http://mobile.bwstudent.com/images/small/circle_pic/2020-10-12/7548120201012150134.png","nickName":"王某人","userId":81057,"whetherGreat":1}]
     * message : 查詢成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * commodityId : 5
         * content : 按时
         * createTime : 1602813955000
         * greatNum : 0
         * headPic : http://mobile.bwstudent.com/images/small/head_pic/2020-10-21/20201021233359.jpg
         * id : 4940
         * image : http://mobile.bwstudent.com/images/small/circle_pic/2020-10-15/5273820201015210555.png
         * nickName : 王某人
         * userId : 81057
         * whetherGreat : 1
         */

        public int commodityId;
        public String content;
        public long createTime;
        public int greatNum;
        public String headPic;
        public int id;
        public String image;
        public String nickName;
        public int userId;
        public int whetherGreat;
    }
}
