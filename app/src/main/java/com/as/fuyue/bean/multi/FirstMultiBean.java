package com.as.fuyue.bean.multi;

import com.as.fuyue.bean.FirstBean;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class FirstMultiBean implements MultiItemEntity {

    public  static final  int Type0=1132;
    public  static final  int Type1=5564;

    private int type;
    private boolean show;


    @Override
    public int getItemType() {
        return type;
    }

    /*******0********/
    private  String  title;

    /*****1*******/

    private FirstBean firstBean;

    public FirstMultiBean(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public FirstMultiBean(int type, FirstBean firstBean,boolean show) {
        this.type = type;
        this.firstBean = firstBean;
        this.show=show;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FirstBean getFirstBean() {
        return firstBean;
    }

    public void setFirstBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }


    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
