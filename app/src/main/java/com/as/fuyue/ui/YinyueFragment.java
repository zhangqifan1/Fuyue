package com.as.fuyue.ui;


import android.view.View;

import com.as.fuyue.App;
import com.as.fuyue.MainActivity;
import com.as.fuyue.R;
import com.as.fuyue.databinding.FragmentYinyueBinding;
import com.as.fuyue.ui.detail.yinyue.Xiaoguo1;
import com.as.fuyue.ui.detail.yinyue.Xiaoguo2;
import com.as.fuyue.ui.detail.yinyue.Xiaoguo3;
import com.as.fuyue.ui.detail.yinyue.Xiaoguo4;
import com.zqf.base.ui.fragment.BaseFragment;

/**
 * 音乐
 */
public class YinyueFragment extends BaseFragment<FragmentYinyueBinding> implements View.OnClickListener {


    public YinyueFragment() {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yinyue;
    }

    @Override
    public void initView(View rootView) {
        mViewBinding.but1.setOnClickListener(this);
        mViewBinding.but2.setOnClickListener(this);
        mViewBinding.but3.setOnClickListener(this);
        mViewBinding.but4.setOnClickListener(this);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                startActivity(Xiaoguo1.class);
                break;
            case R.id.but2:
                startActivity(Xiaoguo2.class);
                break;
            case R.id.but3:
                startActivity(Xiaoguo3.class);
                break;
            case R.id.but4:
                startActivity(Xiaoguo4.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity activity= (MainActivity) getActivity();
        activity.viewStatusbar.setBackgroundColor(_mActivity.getResources().getColor(R.color.lime));
        App.variable.set(App.variable.get()+1);
    }
}
