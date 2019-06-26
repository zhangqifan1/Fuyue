package com.zqf.base.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

/**
 * -----------------------------
 * Created by zqf on 2018/4/27.
 * 当前用户的数据库
 * ---------------------------
 */
@Entity
public class UserInfo {
    //不能用int
    @Id(autoincrement = true)
    private Long id;

    private int userid;

    private String name;

    private boolean isLogin;

    private String image;

    @Generated(hash = 941451256)
    public UserInfo(Long id, int userid, String name, boolean isLogin,
                    String image) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.isLogin = isLogin;
        this.image = image;
    }

    @Keep
    public UserInfo(String name, String image) {
        this.name = name;
        this.image = image;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean getIsLogin() {
        return this.isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
