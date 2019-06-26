package com.as.fuyue.adapter.wenxue;

import android.support.annotation.Nullable;

import com.as.fuyue.R;
import com.as.fuyue.bean.ThirdBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class ThirdContentAdapter extends BaseQuickAdapter<ThirdBean, BaseViewHolder> {

    public ThirdContentAdapter(int layoutResId, @Nullable List<ThirdBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ThirdBean item) {
        helper.setText(R.id.item_text_title, item.getTitleThird());
        helper.setText(R.id.item_text_content, item.getContent());
    }
}
