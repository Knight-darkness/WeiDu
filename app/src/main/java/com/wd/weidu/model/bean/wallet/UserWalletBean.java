package com.wd.weidu.model.bean.wallet;

import java.util.List;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean
 * @ClassName: UserWalletBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/11/2 15:37
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class UserWalletBean {

    /**
     * result : {"balance":9995507,"detailList":[{"amount":298,"consumerTime":1604287575000,"orderId":"2020110211240923481057","userId":81057},{"amount":298,"consumerTime":1604287572000,"orderId":"2020110211234392581057","userId":81057},{"amount":298,"consumerTime":1604287417000,"orderId":"2020110211232531081057","userId":81057},{"amount":298,"consumerTime":1604287395000,"orderId":"2020110211115758881057","userId":81057},{"amount":31,"consumerTime":1604283661000,"orderId":"2020110209090661281057","userId":81057},{"amount":31,"consumerTime":1604283576000,"orderId":"2020110209091211281057","userId":81057},{"amount":629,"consumerTime":1603943124000,"orderId":"2020102911452305281057","userId":81057},{"amount":139,"consumerTime":1603943028000,"orderId":"2020102911434700981057","userId":81057},{"amount":156,"consumerTime":1603857631000,"orderId":"2020102812003026881057","userId":81057},{"amount":248,"consumerTime":1603857599000,"orderId":"2020102811595807681057","userId":81057},{"amount":139,"consumerTime":1603853437000,"orderId":"2020102810503564581057","userId":81057},{"amount":78,"consumerTime":1603849514000,"orderId":"2020102809450987281057","userId":81057},{"amount":249,"consumerTime":1603711060000,"orderId":"2020102619173869281057","userId":81057},{"amount":19,"consumerTime":1603703644000,"orderId":"2020102617140264281057","userId":81057},{"amount":139,"consumerTime":1603631353000,"orderId":"2020102521091165881057","userId":81057},{"amount":39,"consumerTime":1603630907000,"orderId":"2020101219514763981057","userId":81057},{"amount":88,"consumerTime":1603630896000,"orderId":"2020102521013447681057","userId":81057},{"amount":139,"consumerTime":1602766502000,"orderId":"2020101520550037881057","userId":81057},{"amount":278,"consumerTime":1602766262000,"orderId":"2020101520510006481057","userId":81057},{"amount":139,"consumerTime":1602766234000,"orderId":"2020101520503275581057","userId":81057}]}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * balance : 9995507
         * detailList : [{"amount":298,"consumerTime":1604287575000,"orderId":"2020110211240923481057","userId":81057},{"amount":298,"consumerTime":1604287572000,"orderId":"2020110211234392581057","userId":81057},{"amount":298,"consumerTime":1604287417000,"orderId":"2020110211232531081057","userId":81057},{"amount":298,"consumerTime":1604287395000,"orderId":"2020110211115758881057","userId":81057},{"amount":31,"consumerTime":1604283661000,"orderId":"2020110209090661281057","userId":81057},{"amount":31,"consumerTime":1604283576000,"orderId":"2020110209091211281057","userId":81057},{"amount":629,"consumerTime":1603943124000,"orderId":"2020102911452305281057","userId":81057},{"amount":139,"consumerTime":1603943028000,"orderId":"2020102911434700981057","userId":81057},{"amount":156,"consumerTime":1603857631000,"orderId":"2020102812003026881057","userId":81057},{"amount":248,"consumerTime":1603857599000,"orderId":"2020102811595807681057","userId":81057},{"amount":139,"consumerTime":1603853437000,"orderId":"2020102810503564581057","userId":81057},{"amount":78,"consumerTime":1603849514000,"orderId":"2020102809450987281057","userId":81057},{"amount":249,"consumerTime":1603711060000,"orderId":"2020102619173869281057","userId":81057},{"amount":19,"consumerTime":1603703644000,"orderId":"2020102617140264281057","userId":81057},{"amount":139,"consumerTime":1603631353000,"orderId":"2020102521091165881057","userId":81057},{"amount":39,"consumerTime":1603630907000,"orderId":"2020101219514763981057","userId":81057},{"amount":88,"consumerTime":1603630896000,"orderId":"2020102521013447681057","userId":81057},{"amount":139,"consumerTime":1602766502000,"orderId":"2020101520550037881057","userId":81057},{"amount":278,"consumerTime":1602766262000,"orderId":"2020101520510006481057","userId":81057},{"amount":139,"consumerTime":1602766234000,"orderId":"2020101520503275581057","userId":81057}]
         */

        private int balance;
        private List<DetailListBean> detailList;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * amount : 298
             * consumerTime : 1604287575000
             * orderId : 2020110211240923481057
             * userId : 81057
             */

            private int amount;
            private long consumerTime;
            private String orderId;
            private int userId;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public long getConsumerTime() {
                return consumerTime;
            }

            public void setConsumerTime(long consumerTime) {
                this.consumerTime = consumerTime;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
