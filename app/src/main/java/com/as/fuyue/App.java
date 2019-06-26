package com.as.fuyue;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.multidex.MultiDex;

import com.zqf.base.application.BaseApplication;
import com.zqf.base.greendao.UserInfo;

/**
 * -----------------------------
 * Created by zqf on 2019/5/29.
 * ---------------------------
 */
public class App extends BaseApplication {
    public static UserInfo userInfo;

    public static ObservableInt variable;

    @Override
    public void initThirdParty() {

        variable = new ObservableInt(0);





    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
