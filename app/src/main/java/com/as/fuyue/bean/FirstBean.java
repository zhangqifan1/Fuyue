package com.as.fuyue.bean;

import com.as.fuyue.bean.multi.SecondMultiBean;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class FirstBean {
    private String titleFirst;  //唐

    private List<SecondMultiBean> secondBeans;

    public FirstBean(List<SecondMultiBean> secondBeans) {
        this.secondBeans = secondBeans;
    }

    public List<SecondMultiBean> getSecondBeans() {
        return secondBeans;
    }

    public void setSecondBeans(List<SecondMultiBean> secondBeans) {
        this.secondBeans = secondBeans;
    }
}
