package com.wd.weidu.model.bean.orderForm;

import java.util.List;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean.orderForm
 * @ClassName: orderAllBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/28
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class orderAllBean {


    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/5.jpg","commodityPrice":139,"orderDetailId":23897}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020102810503564581057","orderStatus":2,"orderTime":1603853436000,"payAmount":139,"payMethod":1,"userId":81057},{"detailList":[{"commentStatus":1,"commodityCount":2,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":23893}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020102809450987281057","orderStatus":3,"orderTime":1603849510000,"payAmount":78,"payMethod":1,"userId":81057},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":159,"commodityName":"富贵鸟 头层牛皮系带百搭商务休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/swxxx/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/swxxx/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/swxxx/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/swxxx/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/swxxx/4/5.jpg","commodityPrice":249,"orderDetailId":23771}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020102619173869281057","orderStatus":2,"orderTime":1603711059000,"payAmount":249,"payMethod":1,"userId":81057},{"detailList":[{"commentStatus":2,"commodityCount":1,"commodityId":8,"commodityName":"Lara style蜜颊润泽腮红","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/6/4.jpg","commodityPrice":19,"orderDetailId":23764}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020102617140264281057","orderStatus":9,"orderTime":1603703643000,"payAmount":19,"payMethod":1,"userId":81057},{"detailList":[{"commentStatus":2,"commodityCount":1,"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/3/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/3/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/3/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/3/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/3/5.jpg","commodityPrice":139,"orderDetailId":23727}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020102521091165881057","orderStatus":9,"orderTime":1603631352000,"payAmount":139,"payMethod":1,"userId":81057}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/5.jpg","commodityPrice":139,"orderDetailId":23897}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020102810503564581057
         * orderStatus : 2
         * orderTime : 1603853436000
         * payAmount : 139
         * payMethod : 1
         * userId : 81057
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 23
             * commodityName : 小白鞋 女款 时尚百搭休闲板鞋
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/5.jpg
             * commodityPrice : 139
             * orderDetailId : 23897
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
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

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
