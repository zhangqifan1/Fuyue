package com.as.fuyue;


import android.content.Context;
import android.databinding.Observable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.widget.DrawerLayout;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.as.fuyue.adapter.MyPageAdapter;
import com.as.fuyue.databinding.ActivityMainBinding;
import com.as.fuyue.ui.ChuangzuoFragment;
import com.as.fuyue.ui.WenXueFragment;
import com.as.fuyue.ui.YinyueFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.jaeger.library.StatusBarUtil;
import com.zqf.base.ui.activity.BaseActivity;
import com.zqf.base.util.utils_blankj.BarUtils;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class MainActivity extends BaseActivity<ActivityMainBinding> {


    public  View viewStatusbar;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initView() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        viewStatusbar = mViewBinding.viewStatusbar;
        mViewBinding.viewStatusbar.getLayoutParams().height=BarUtils.getStatusBarHeight();




        App.variable.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {


                ColorDrawable background = (ColorDrawable)mViewBinding.viewStatusbar.getBackground();
                int color = background.getColor();
                boolean lightColor = isLightColor(color);
                if(lightColor){

                    StatusBarUtil.setLightMode(MainActivity.this);
                }else{

                    StatusBarUtil.setDarkMode(MainActivity.this);
                }

            }
        });


        App.variable.set(App.variable.get()+1);

        List<Fragment> list = new ArrayList<>();
        Fragment wenXueFragment = new WenXueFragment();
        Fragment yinyueFragment = new YinyueFragment();
        Fragment czFragment = new ChuangzuoFragment();

        list.add(wenXueFragment);
        list.add(yinyueFragment);
        list.add(czFragment);
        mViewBinding.bnve.enableItemShiftingMode(true);//为true 时  只有当前选中项 会显示文字
        mViewBinding.bnve.enableShiftingMode(true);//为true 时,当前选中项宽度改变
        mViewBinding.bnve.enableAnimation(true);//开启或关闭点击动画(文字放大效果和图片移动效果)。默认为 true.


        //设置底部导航栏 的 图标大小
        mViewBinding.bnve.setIconSize(30, 30);

        //可以提现 文字 和 图标的距离
        mViewBinding.bnve.setItemHeight(200);
        mViewBinding.bnve.setSmallTextSize(12);
        mViewBinding.bnve.setLargeTextSize(14);

        MyPageAdapter myPageAdapter = new MyPageAdapter(getSupportFragmentManager(), list);
        mViewBinding.viewPager.setAdapter(myPageAdapter);

        mViewBinding.bnve.setupWithViewPager(mViewBinding.viewPager);


        mViewBinding.draw.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                mViewBinding.right.layout(mViewBinding.mainInclude.mainDrawer.getRight(), 0, mViewBinding.mainInclude.mainDrawer.getRight() + display.getWidth(), display.getHeight());
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

    }

    @Override
    protected void initData() {
        setMainDrawerInfo();
    }

    @Override
    protected void initListener() {

    }

    /**
     * 设置个人信息
     */
    private void setMainDrawerInfo() {

        //设置头像
        Glide.with(this)
                .load(App.userInfo.getImage())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(mViewBinding.mainInclude.mainDrawerContentIvUser);

        //设置头像背景
        Glide.with(this)
                .load(App.userInfo.getImage())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation()))
                .into(mViewBinding.mainInclude.mainDrawerContentIvUserBg);


    }


    public boolean isLightColor(int color) {
        double v = ColorUtils.calculateLuminance(color);
        if (v >= 0.5) {
            return true;
//            ToastUtils.showShort("是亮色");
            //设置黑色状态栏字体
        }
//            ToastUtils.showShort("是暗色");
        //设置白色状态栏字体
        return false;
    }

}
