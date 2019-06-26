package com.as.fuyue.bean.multi;

import com.as.fuyue.bean.SecondBean;
import com.as.fuyue.bean.ThirdBean;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class ThirdMultiBean implements MultiItemEntity {

    public static final int Type0 = 1632;
    public static final int Type1 = 5324;

    private int type;

    private boolean show;
    @Override
    public int getItemType() {
        return type;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private List<ThirdBean> thirdBeans;

    public List<ThirdBean> getThirdBeans() {
        return thirdBeans;
    }

    public void setThirdBeans(List<ThirdBean> thirdBeans) {
        this.thirdBeans = thirdBeans;
    }

    public ThirdMultiBean(int type, List<ThirdBean> thirdBeans, boolean show) {
        this.type = type;
        this.thirdBeans = thirdBeans;
        this.show=show;
    }

    private SecondBean secondBean;

    public ThirdMultiBean(int type, SecondBean secondBean) {
        this.type = type;
        this.secondBean = secondBean;
    }

    public SecondBean getSecondBean() {
        return secondBean;
    }

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
