package com.as.fuyue.adapter.wenxue;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.as.fuyue.R;
import com.as.fuyue.bean.SecondBean;
import com.as.fuyue.bean.ThirdBean;
import com.as.fuyue.bean.multi.ThirdMultiBean;
import com.as.fuyue.layoutmanager.CustomLinearLayoutManager;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * -----------------------------
 * Created by zqf on 2019/6/20.
 * ---------------------------
 */
public class ThirdAdapter extends BaseMultiItemQuickAdapter<ThirdMultiBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ThirdAdapter(List<ThirdMultiBean> data) {
        super(data);
        addItemType(ThirdMultiBean.Type0, R.layout.item_wenxue_third_type0);
        addItemType(ThirdMultiBean.Type1, R.layout.item_wenxue_third_type1);
    }

    @Override
    protected void convert(BaseViewHolder helper, ThirdMultiBean item) {
        int itemViewType = helper.getItemViewType();

        SecondBean secondBean = item.getSecondBean();
        List<ThirdBean> thirdBeans = item.getThirdBeans();

        switch (itemViewType) {
            case ThirdMultiBean.Type0:
                helper.setText(R.id.title_third, secondBean.getTitleThird());
                Glide.with(mContext)
                        .load(secondBean.getResid())
                        .into((ImageView) helper.getView(R.id.image_third));

                helper.getView(R.id.title_third).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int adapterPosition = helper.getAdapterPosition();
                        ThirdMultiBean thirdMultiBean = mData.get(adapterPosition + 1);
                        thirdMultiBean.setShow(!thirdMultiBean.isShow());
                        notifyItemChanged(adapterPosition + 1);
                    }
                });
                break;
            case ThirdMultiBean.Type1:
                RecyclerView recycler_third = helper.getView(R.id.recycler_third);
                if(item.isShow()){
                    recycler_third.setVisibility(View.GONE);
                    return;
                }else{
                    //第一次是false
                    recycler_third.setVisibility(View.VISIBLE);
                }
                CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
                linearLayoutManager.setScrollEnabled(false);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                ThirdContentAdapter thirdContentAdapter=new ThirdContentAdapter(R.layout.item_content, thirdBeans);
                recycler_third.setLayoutManager(linearLayoutManager);
                recycler_third.setAdapter(thirdContentAdapter);

                break;
            default:
                break;
        }

    }
}
