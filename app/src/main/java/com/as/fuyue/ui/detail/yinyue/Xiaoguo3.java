package com.as.fuyue.ui.detail.yinyue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.as.fuyue.R;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.zqf.base.util.utils_blankj.ScreenUtils;

public class Xiaoguo3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo3);
        ObservableScrollView observer_scrollview = findViewById(R.id.observer_scrollview);
        ImageView imagetop = findViewById(R.id.image_top);
        int minwidth = imagetop.getLayoutParams().width;//
        int minheight = imagetop.getLayoutParams().height;//
        observer_scrollview.setScrollViewCallbacks(new ObservableScrollViewCallbacks() {
            @Override
            public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
                int maxheight = minheight + scrollY / 4;
                if (maxheight >= ScreenUtils.getScreenHeight() / 2) {
                    return;
                }
                imagetop.getLayoutParams().height = maxheight;
                imagetop.getLayoutParams().width = maxheight * 1080 / 1920;
                imagetop.requestLayout();
            }

            @Override
            public void onDownMotionEvent() {

            }

            @Override
            public void onUpOrCancelMotionEvent(ScrollState scrollState) {

            }
        });

    }
}
