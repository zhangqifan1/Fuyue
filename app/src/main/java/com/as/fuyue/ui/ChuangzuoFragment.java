package com.as.fuyue.ui;


import android.graphics.Color;
import android.view.View;

import com.as.fuyue.App;
import com.as.fuyue.MainActivity;
import com.as.fuyue.R;
import com.as.fuyue.databinding.FragmentChuangzuoBinding;
import com.as.fuyue.ui.detail.chuangzuo.Image0;
import com.as.fuyue.ui.detail.chuangzuo.Image1;
import com.as.fuyue.ui.detail.chuangzuo.Image2;
import com.zqf.base.ui.fragment.BaseFragment;

/**
 * 创作
 */
public class ChuangzuoFragment extends BaseFragment<FragmentChuangzuoBinding> implements View.OnClickListener {


    public ChuangzuoFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_chuangzuo;
    }

    @Override
    public void initView(View rootView) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mViewBinding.but0.setOnClickListener(this);
        mViewBinding.but1.setOnClickListener(this);
        mViewBinding.but2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but0:
                startActivity(Image0.class);
                break;
            case R.id.but1:
                startActivity(Image1.class);
                break;
            case R.id.but2:
                startActivity(Image2.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity activity= (MainActivity) getActivity();
        activity.viewStatusbar.setBackgroundColor(_mActivity.getResources().getColor(R.color.gray));
        App.variable.set(App.variable.get()+1);
    }
}
