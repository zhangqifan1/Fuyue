package com.as.fuyue.adapter.yinyue;

import android.support.annotation.Nullable;

import com.as.fuyue.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/24.
 * ---------------------------
 */
public class Xiaoguo4Adapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public Xiaoguo4Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.item_text, item);
    }
}
