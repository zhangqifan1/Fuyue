package com.as.fuyue.ui;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.as.fuyue.App;
import com.as.fuyue.MainActivity;
import com.as.fuyue.R;
import com.as.fuyue.adapter.wenxue.FirstAdapter;
import com.as.fuyue.bean.FirstBean;
import com.as.fuyue.bean.SecondBean;
import com.as.fuyue.bean.ThirdBean;
import com.as.fuyue.bean.multi.FirstMultiBean;
import com.as.fuyue.bean.multi.SecondMultiBean;
import com.as.fuyue.bean.multi.ThirdMultiBean;
import com.as.fuyue.databinding.FragmentWenXueBinding;
import com.as.fuyue.layoutmanager.CustomLinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zqf.base.ui.fragment.BaseFragment;
import com.zqf.base.util.utils_blankj.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文学
 */
public class WenXueFragment extends BaseFragment<FragmentWenXueBinding> {


    private  boolean firstHide=false;
    public WenXueFragment() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wen_xue;
    }

    @Override
    public void initView(View rootView) {
        mViewBinding.wenxueIvTopbg.getLayoutParams().height = ScreenUtils.getScreenWidth() * 316 / 843;

    }

    @Override
    protected void initData() {


        FirstMultiBean f0 = new FirstMultiBean(FirstMultiBean.Type0, "唐");
        FirstMultiBean f1 = new FirstMultiBean(FirstMultiBean.Type1,
                new FirstBean(new ArrayList<SecondMultiBean>() {{
                    add(new SecondMultiBean(SecondMultiBean.Type0, "诗-李白斗酒诗百篇"));
                    add(new SecondMultiBean(SecondMultiBean.Type1, new ArrayList<ThirdMultiBean>() {
                        {
                            add(new ThirdMultiBean(ThirdMultiBean.Type0,
                                    new SecondBean("李白", R.drawable.ic_launcher_background)));
                            add(new ThirdMultiBean(ThirdMultiBean.Type1, new ArrayList<ThirdBean>() {{
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                            }},false));
                        }
                    },false));

                    add(new SecondMultiBean(SecondMultiBean.Type0, "诗-便引诗情到碧霄"));
                    add(new SecondMultiBean(SecondMultiBean.Type1, new ArrayList<ThirdMultiBean>() {
                        {
                            add(new ThirdMultiBean(ThirdMultiBean.Type0,
                                    new SecondBean("李白", R.drawable.ic_launcher_background)));
                            add(new ThirdMultiBean(ThirdMultiBean.Type1, new ArrayList<ThirdBean>() {{
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                                add(new ThirdBean("<<静夜思>>", "床前明月光，疑是地上霜。\n举头望明月，低头思故乡。"));
                            }},false));
                        }
                    },false));
                }

                }),true);

        FirstMultiBean f2 = new FirstMultiBean(FirstMultiBean.Type0, "宋");
        FirstMultiBean f3 = new FirstMultiBean(FirstMultiBean.Type1,
                new FirstBean( new ArrayList<SecondMultiBean>() {{
                    add(new SecondMultiBean(SecondMultiBean.Type0, "词"));
                    add(new SecondMultiBean(SecondMultiBean.Type1, new ArrayList<ThirdMultiBean>() {
                        {
                            add(new ThirdMultiBean(ThirdMultiBean.Type0,
                                    new SecondBean("李清照", R.drawable.ic_launcher_background)));
                            add(new ThirdMultiBean(ThirdMultiBean.Type1, new ArrayList<ThirdBean>() {{
                                add(new ThirdBean("《如梦令·常记溪亭日暮》", "常记溪亭日暮，沉醉不知归路，\n兴尽晚回舟，误入藕花深处。\n争渡，争渡，惊起一滩鸥鹭。"));
                                add(new ThirdBean("《如梦令·常记溪亭日暮》", "常记溪亭日暮，沉醉不知归路，\n兴尽晚回舟，误入藕花深处。\n争渡，争渡，惊起一滩鸥鹭。"));
                                add(new ThirdBean("《如梦令·常记溪亭日暮》", "常记溪亭日暮，沉醉不知归路，\n兴尽晚回舟，误入藕花深处。\n争渡，争渡，惊起一滩鸥鹭。"));
                                add(new ThirdBean("《如梦令·常记溪亭日暮》", "常记溪亭日暮，沉醉不知归路，\n兴尽晚回舟，误入藕花深处。\n争渡，争渡，惊起一滩鸥鹭。"));
                            }},false));
                        }
                    },false));
                }}),true);
        FirstMultiBean f4 = new FirstMultiBean(FirstMultiBean.Type0, "元");
        FirstMultiBean f5 = new FirstMultiBean(FirstMultiBean.Type1,
                new FirstBean( new ArrayList<SecondMultiBean>() {{
                    add(new SecondMultiBean(SecondMultiBean.Type0, "曲"));
                    add(new SecondMultiBean(SecondMultiBean.Type1, new ArrayList<ThirdMultiBean>() {
                        {
                            add(new ThirdMultiBean(ThirdMultiBean.Type0,
                                    new SecondBean("马致远", R.drawable.ic_launcher_background)));
                            add(new ThirdMultiBean(ThirdMultiBean.Type1, new ArrayList<ThirdBean>() {{
                                add(new ThirdBean("《天净沙·秋思》", "枯藤老树昏鸦，小桥流水人家，\n古道西风瘦马。\n夕阳西下，断肠人在天涯。"));
                            }},false));
                        }
                    },false));
                }}),true);

        FirstMultiBean f6 = new FirstMultiBean(FirstMultiBean.Type0, "明清");
        FirstMultiBean f7 = new FirstMultiBean(FirstMultiBean.Type1,
                new FirstBean(new ArrayList<SecondMultiBean>() {{
                    add(new SecondMultiBean(SecondMultiBean.Type0, "小说"));
                    add(new SecondMultiBean(SecondMultiBean.Type1, new ArrayList<ThirdMultiBean>() {
                        {
                            add(new ThirdMultiBean(ThirdMultiBean.Type0,
                                    new SecondBean("许仲琳", R.drawable.ic_launcher_background)));
                            add(new ThirdMultiBean(ThirdMultiBean.Type1, new ArrayList<ThirdBean>() {{
                                add(new ThirdBean("《封神演义》", "有志不在年高，\n无谋空言百岁。"));
                                add(new ThirdBean("《封神演义》", "人言不足信，\n天命不足畏。"));
                                add(new ThirdBean("《封神演义》", "宁在直中取，不在曲中求\n非为锦麟设，专钓王与侯。"));
                                add(new ThirdBean("《封神演义》", "心似白云常自在\n意如流水任东西。"));
                            }},false));
                        }
                    },false));
                }}),true);

        List<FirstMultiBean> list = new ArrayList<FirstMultiBean>() {{
            add(f0);
            add(f1);
            add(f2);
            add(f3);
            add(f4);
            add(f5);
            add(f6);
            add(f7);
        }};

        FirstAdapter firstAdapter = new FirstAdapter(list);
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(_mActivity);
        linearLayoutManager.setScrollEnabled(false);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mViewBinding.fragWenxueRecycler.setAdapter(firstAdapter);
        mViewBinding.fragWenxueRecycler.setLayoutManager(linearLayoutManager);

        firstAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                            case R.id.item_wenxue_title_first :
                                FirstMultiBean firstMultiBean = list.get(position+1);
                                boolean show = firstMultiBean.isShow();
                                firstMultiBean.setShow(!show);

                                adapter.notifyItemChanged(position+1);
                                break;
                            default:
                                break;
                        }
            }
        });

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        MainActivity activity= (MainActivity) getActivity();
        activity.viewStatusbar.setBackgroundColor(_mActivity.getResources().getColor(R.color.black));
        App.variable.set(App.variable.get()+1);
    }
}
