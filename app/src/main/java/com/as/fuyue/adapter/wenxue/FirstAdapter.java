package com.as.fuyue.adapter.wenxue;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.as.fuyue.R;
import com.as.fuyue.bean.multi.FirstMultiBean;
import com.as.fuyue.bean.multi.SecondMultiBean;
import com.as.fuyue.layoutmanager.CustomLinearLayoutManager;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class FirstAdapter extends BaseMultiItemQuickAdapter<FirstMultiBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public FirstAdapter(List<FirstMultiBean> data) {
        super(data);
        addItemType(FirstMultiBean.Type0, R.layout.item_wenxue_first_type0);
        addItemType(FirstMultiBean.Type1, R.layout.item_wenxue_first_type1);
    }

    @Override
    protected void convert(BaseViewHolder helper, FirstMultiBean item) {
        int itemViewType = helper.getItemViewType();


        switch (itemViewType) {
            case FirstMultiBean.Type0:
                helper.setText(R.id.item_wenxue_title_first, item.getTitle());
                helper.addOnClickListener(R.id.item_wenxue_title_first);
                break;
            case FirstMultiBean.Type1:

                RecyclerView recycler_first = helper.getView(R.id.recycler_first);

                if(item.isShow()){
                    recycler_first.setVisibility(View.GONE);
                    return;
                }else{
                    //第一次是false
                    recycler_first.setVisibility(View.VISIBLE);
                }
                List<SecondMultiBean> secondBeans = item.getFirstBean().getSecondBeans();
                SecondAdapter secondAdapter = new SecondAdapter(secondBeans);
                recycler_first.setAdapter(secondAdapter);
                CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
                linearLayoutManager.setScrollEnabled(false);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler_first.setLayoutManager(linearLayoutManager);


                break;
            default:
                break;
        }

    }
}
