package com.as.fuyue.bean;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class SecondBean {


    private String titleThird;//作者

    private int resid;  //头像

    private List<ThirdBean> datas;


    public String getTitleThird() {

        return titleThird;
    }

    public void setTitleThird(String titleThird) {
        this.titleThird = titleThird;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public List<ThirdBean> getDatas() {
        return datas;
    }


    public SecondBean(String titleThird, int resid) {
        this.titleThird = titleThird;
        this.resid = resid;
    }

    public SecondBean(List<ThirdBean> datas) {
        this.datas = datas;
    }
}
