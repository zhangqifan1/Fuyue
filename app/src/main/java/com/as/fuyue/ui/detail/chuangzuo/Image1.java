package com.as.fuyue.ui.detail.chuangzuo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.as.fuyue.R;

public class Image1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image1);
        TextView tv0 = findViewById(R.id.tv0);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        TextView tv4 = findViewById(R.id.tv4);

        /**
         * 这里我们只判断 如果是亮色 则设置为黑色字体 如果是暗色 则设置为白色字体
         */
        ColorDrawable c0 = (ColorDrawable) (tv0.getBackground());
        int t0 = c0.getColor();
        if(isLightColor(t0)){
            tv0.setTextColor(Color.parseColor("#000000"));
        }else{
            tv0.setTextColor(Color.parseColor("#FFFFFF"));
        }



        ColorDrawable c1 = (ColorDrawable) (tv1.getBackground());
        int t1 = c1.getColor();
        if(isLightColor(t1)){
            tv1.setTextColor(Color.parseColor("#000000"));
        }else{
            tv1.setTextColor(Color.parseColor("#FFFFFF"));
        }


        ColorDrawable c2 = (ColorDrawable) (tv2.getBackground());
        int t2 = c2.getColor();
        if(isLightColor(t2)){
            tv2.setTextColor(Color.parseColor("#000000"));
        }else{
            tv2.setTextColor(Color.parseColor("#FFFFFF"));
        }

        ColorDrawable c3 = (ColorDrawable) (tv3.getBackground());
        int t3 = c3.getColor();
        if(isLightColor(t3)){
            tv3.setTextColor(Color.parseColor("#000000"));
        }else{
            tv3.setTextColor(Color.parseColor("#FFFFFF"));
        }

        ColorDrawable c4 = (ColorDrawable) (tv4.getBackground());
        int t4 = c4.getColor();
        if(isLightColor(t4)){
            tv4.setTextColor(Color.parseColor("#000000"));
        }else{
            tv4.setTextColor(Color.parseColor("#FFFFFF"));
        }
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
