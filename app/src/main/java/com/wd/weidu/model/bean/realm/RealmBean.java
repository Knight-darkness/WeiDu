package com.wd.weidu.model.bean.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @ProjectName: WeiDuShoppingDemo
 * @Package: com.wd.weidu.model.bean
 * @ClassName: RealmBean
 * @Description: java类作用描述
 * @Author: DELL
 * @CreateDate: 2020/10/21
 * @UpdateUser: 王祎卓
 * @Version: 1.0
 */
public class RealmBean extends RealmObject {
    @PrimaryKey
    public int userId;
    public String headPic;
    public String nickName;
    public String phone;
    public String sessionId;
    public int sex;
}
