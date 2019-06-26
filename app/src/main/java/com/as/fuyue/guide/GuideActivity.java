package com.as.fuyue.guide;

import android.animation.Animator;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.as.fuyue.App;
import com.as.fuyue.Datas;
import com.as.fuyue.MainActivity;
import com.as.fuyue.R;
import com.as.fuyue.databinding.GuideLayoutBinding;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.zqf.base.greendao.GreenDaoUtils_UserInfo;
import com.zqf.base.greendao.UserInfo;
import com.zqf.base.util.utils_blankj.ActivityUtils;
import com.zqf.base.util.utils_blankj.DeviceUtils;
import com.zqf.base.util.utils_blankj.ToastUtils;
import com.zqf.base.util.utils_blankj.security_sp.SecuritySharedPreference;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GuideActivity extends Activity {

    private boolean isFirstLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFirstLogin = SecuritySharedPreference.getInstance().getBoolean("isFirstLogin", false);
    }

    @Override
    protected void onResume() {
        super.onResume();


        View view = getLayoutInflater().inflate(R.layout.guide_layout, null);
        getWindow().setContentView(view);
        GuideLayoutBinding layoutBinding = DataBindingUtil.bind(view);

        ToGetTouxiang(layoutBinding);
        ToSetText(layoutBinding);


    }

    /**
     * 一句诗词动起来
     *
     * @param layoutBinding
     */
    private void ToSetText(GuideLayoutBinding layoutBinding) {
        int size = Datas.datas.size() - 1;

        Random random = new Random();
        int i = random.nextInt(size);

        layoutBinding.atpv.setText(Datas.datas.get(i));

        if (i % 2 == 0) {
            layoutBinding.atpv.startAnimation(0, 1);
        } else {
            layoutBinding.atpv.startAnimation(1, 0);
        }

    }

    /**
     * 设置小动画  动画结束 获取头像
     */
    private void ToGetTouxiang(GuideLayoutBinding layoutBinding) {
        YoYo.with(Techniques.Tada)
                .withListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //登录过直接赋值
                                if (isFirstLogin) {
                                    App.userInfo = GreenDaoUtils_UserInfo.queryAll();
                                    ActivityUtils.startActivity(MainActivity.class);
                                    finish();
                                } else {  //没有设置过头像
                                    Album.image(GuideActivity.this) // 选择图片。
                                            .multipleChoice()
                                            .camera(true)//有照相机
                                            .columnCount(3)//一行三个
                                            .selectCount(1)//选择一个
                                            .onResult(new Action<ArrayList<AlbumFile>>() {
                                                @Override
                                                public void onAction(int requestCode, @android.support.annotation.NonNull ArrayList<AlbumFile> result) {
                                                    AlbumFile albumFile = result.get(0);
                                                    String path = albumFile.getPath();
                                                    //获取设备型号
                                                    String model = DeviceUtils.getModel();
                                                    String manufacturer = DeviceUtils.getManufacturer();

                                                    new AsyncTask<Void, Void, Void>() {
                                                        @Override
                                                        protected Void doInBackground(Void... voids) {
                                                            UserInfo userInfo = new UserInfo(model + manufacturer, path);
                                                            GreenDaoUtils_UserInfo.insertUserInfo(userInfo);
                                                            SecuritySharedPreference.getInstance().edit().putBoolean("isFirstLogin", true).apply();
                                                            App.userInfo = userInfo;

                                                            return null;
                                                        }

                                                        @Override
                                                        protected void onPostExecute(Void aVoid) {

                                                            ActivityUtils.startActivity(MainActivity.class);
                                                            finish();
                                                        }
                                                    }.execute();
                                                }
                                            })
                                            .onCancel(new Action<String>() {
                                                @Override
                                                public void onAction(int requestCode, @android.support.annotation.NonNull String result) {
                                                    ToastUtils.showShort("亲亲,不选头像玩蛋哦");
                                                }
                                            })
                                    .start();
                                }
                            }
                        }, 1000);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .duration(1000).delay(200).repeat(1)

                .playOn(layoutBinding.guideImage);
    }
}
