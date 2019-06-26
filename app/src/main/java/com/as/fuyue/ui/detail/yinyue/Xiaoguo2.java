package com.as.fuyue.ui.detail.yinyue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.as.fuyue.R;
import com.as.fuyue.customview.ParallaxListView2;

public class Xiaoguo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaoguo2);

        ParallaxListView2 plv = findViewById(R.id.plv);
        View mHeaderView = View.inflate(this, R.layout.layout_list_header2, null);
        final ImageView iv_header = (ImageView) mHeaderView.findViewById(R.id.iv_header);
        plv.addHeaderView(mHeaderView);
        iv_header.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {/*如果当前布局渲染完毕, 此方法被调用,可以获取宽高,ImageView设置进去*/
                plv.setParallaxImage(iv_header);
                iv_header.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        plv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
    }
}
