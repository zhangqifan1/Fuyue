package com.as.fuyue.ui.detail.yinyue;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.as.fuyue.R;
import com.as.fuyue.adapter.yinyue.Xiaoguo4Adapter;
import com.as.fuyue.customview.NestedTouchScrollingLayout;

import java.util.ArrayList;
import java.util.List;

public class Xiaoguo4 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo4);


        FrameLayout fram = findViewById(R.id.fram);
        RecyclerView recycler_xiaoguo4 = findViewById(R.id.recycler_xiaoguo4);
        NestedTouchScrollingLayout mNestedTouchScrollingLayout = findViewById(R.id.wrapper);
        mNestedTouchScrollingLayout.setSheetDirection(NestedTouchScrollingLayout.SheetDirection.BOTTOM);

        List<String> list=new ArrayList<String>(){{
            for (int i = 0; i < 30; i++) {
                add(i+" ");
            }
        }};

        Xiaoguo4Adapter xiaoguo4Adapter=new Xiaoguo4Adapter(R.layout.item_text_xiaoguo4,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_xiaoguo4.setAdapter(xiaoguo4Adapter);
        recycler_xiaoguo4.setLayoutManager(linearLayoutManager);

        mNestedTouchScrollingLayout.registerNestScrollChildCallback(new NestedTouchScrollingLayout.INestChildScrollChange() {
            @Override
            public void onNestChildScrollChange(float deltaY, float velocityY) {

                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) fram.getLayoutParams();
                params.height = (int) (getResources().getDimension(R.dimen.p300) + deltaY);
                fram.setLayoutParams(params);
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onNestChildScrollRelease(final float deltaY, final int velocityY) {
//                mNestedTouchScrollingLayout.recover(0, new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i("NestedTouchScrollingLayout ---> ", "deltaY : " + deltaY + " velocityY : " + velocityY);
//                    }
//                });
            }

            @Override
            public void onFingerUp(float velocityY) {

            }

            @Override
            public void onNestChildHorizationScroll(MotionEvent event, float deltaX, float deltaY) {

            }

            @Override
            public void onNestScrollingState(int state) {

            }
        });

    }
}
