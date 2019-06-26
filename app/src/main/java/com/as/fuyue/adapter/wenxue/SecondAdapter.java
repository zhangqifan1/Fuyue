package com.as.fuyue.adapter.wenxue;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.as.fuyue.R;
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
public class SecondAdapter extends BaseMultiItemQuickAdapter<SecondMultiBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public SecondAdapter(List<SecondMultiBean> data) {
        super(data);
        addItemType(SecondMultiBean.Type0, R.layout.item_wenxue_second_type0);
        addItemType(SecondMultiBean.Type1, R.layout.item_wenxue_second_type1);
    }

    @Override
    protected void convert(BaseViewHolder helper, SecondMultiBean item) {
        int itemViewType = helper.getItemViewType();
        switch (itemViewType) {
            case SecondMultiBean.Type0:
                helper.setText(R.id.item_wenxue_title_second, item.getTitle());
                helper.addOnClickListener(R.id.item_wenxue_title_second);

                helper.getView(R.id.item_wenxue_title_second).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int adapterPosition = helper.getAdapterPosition();
                        SecondMultiBean secondMultiBean = mData.get(adapterPosition + 1);
                        secondMultiBean.setShow(!secondMultiBean.isShow());
                        notifyItemChanged(adapterPosition + 1);
                    }
                });

                break;
            case SecondMultiBean.Type1:
                RecyclerView recycler_second = helper.getView(R.id.recycler_second);
                if(item.isShow()){
                    recycler_second.setVisibility(View.GONE);
                    return;
                }else{
                    //第一次是false
                    recycler_second.setVisibility(View.VISIBLE);
                }

                CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
                linearLayoutManager.setScrollEnabled(false);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                ThirdAdapter thirdAdapter = new ThirdAdapter(item.getSecondBeans());
                recycler_second.setAdapter(thirdAdapter);
                recycler_second.setLayoutManager(linearLayoutManager);



                break;
            default:
                break;
        }

    }
}
