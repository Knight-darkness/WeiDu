package com.wd.weidu.model.bean.foot;

import java.util.List;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean.foot
 * @ClassName: MyFootprintBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/11/2 14:01
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class MyFootprintBean {

    /**
     * result : [{"browseNum":3,"browseTime":1604347114000,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg","price":78,"userId":81057},{"browseNum":1,"browseTime":1604338550000,"commodityId":26,"commodityName":"【加绒保暖 软底舒适】蝴蝶结情侣雪地靴平底真皮磨砂加绒冬季保暖豆豆鞋棉鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/2/1.jpg","price":129,"userId":81057},{"browseNum":6,"browseTime":1604337849000,"commodityId":189,"commodityName":"高尔夫GOLF锦纶双肩包男士个性旅行背包大容量电脑背包D8BV33913J","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/sjb/6/1.jpg","price":179,"userId":81057},{"browseNum":6,"browseTime":1604337849000,"commodityId":176,"commodityName":"瑞士军刀大容量背包多功能户外出差旅行包双肩包男15.6英寸笔记本电脑包手提斜挎行李包旅游登山包防泼水 黑色【多功能手提斜跨双肩单肩】","masterPic":"http://mobile.bwstudent.com/images/small/commodity/xbsd/dnb/7/1.jpg","price":119,"userId":81057},{"browseNum":11,"browseTime":1604329866000,"commodityId":21,"commodityName":"【加绒休闲 舒适轻便】秋冬增高休闲鞋厚底棉鞋运动户外通勤简约韩版女鞋","masterPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/4/1.jpg","price":189,"userId":81057}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * browseNum : 3
         * browseTime : 1604347114000
         * commodityId : 19
         * commodityName : 环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋
         * masterPic : http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg
         * price : 78
         * userId : 81057
         */

        private int browseNum;
        private long browseTime;
        private int commodityId;
        private String commodityName;
        private String masterPic;
        private int price;
        private int userId;

        public int getBrowseNum() {
            return browseNum;
        }

        public void setBrowseNum(int browseNum) {
            this.browseNum = browseNum;
        }

        public long getBrowseTime() {
            return browseTime;
        }

        public void setBrowseTime(long browseTime) {
            this.browseTime = browseTime;
        }

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public String getMasterPic() {
            return masterPic;
        }

        public void setMasterPic(String masterPic) {
            this.masterPic = masterPic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
