package com.as.fuyue.bean.multi;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class SecondMultiBean implements MultiItemEntity {

    public  static final  int Type0=1232;
    public  static final  int Type1=5364;

    private int type;

    private boolean show;
    @Override
    public int getItemType() {
        return type;
    }

    /*******0********/
    private  String  title;//诗

    /*****1*******/
    private List<ThirdMultiBean> secondBeans;

    public SecondMultiBean(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public SecondMultiBean(int type, List<ThirdMultiBean> secondBeans,boolean show) {
        this.type = type;
        this.secondBeans = secondBeans;
        this.show=show;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ThirdMultiBean> getSecondBeans() {
        return secondBeans;
    }

    public void setSecondBeans(List<ThirdMultiBean> secondBeans) {
        this.secondBeans = secondBeans;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
