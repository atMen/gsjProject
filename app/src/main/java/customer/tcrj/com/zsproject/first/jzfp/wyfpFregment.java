package customer.tcrj.com.zsproject.first.jzfp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.ldjhAdapter;
import customer.tcrj.com.zsproject.base.BaseFragment;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class wyfpFregment extends BaseFragment  {


    @BindView(R.id.tv_sclc)
    TextView  tv_sclc;
    @BindView(R.id.tv_xslc)
    TextView  tv_xslc;

    private FragmentManager fragmentManager;
    private wdfpFragment newsFragment;
    private fpdxFregment settingFragment;



    @Override
    protected int setLayout() {
        return R.layout.wyfp_fregment;
    }

    @Override
    protected void setView() {
        fragmentManager = getActivity().getSupportFragmentManager();

        setTabSelection(0);
    }

    @OnClick({R.id.tv_sclc,R.id.tv_xslc})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_sclc:
                tv_sclc.setTextColor(getResources().getColor(R.color.blue));
                tv_xslc.setTextColor(getResources().getColor(R.color.login_textcolor));
                setTabSelection(0);
                break;

            case R.id.tv_xslc:
                tv_xslc.setTextColor(getResources().getColor(R.color.blue));
                tv_sclc.setTextColor(getResources().getColor(R.color.login_textcolor));
                setTabSelection(1);
                break;


        }
    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (newsFragment == null) {
                    newsFragment = new wdfpFragment();
                    transaction.add(R.id.contentContainer, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }

                break;
            case 1:
                if (settingFragment == null) {
                    settingFragment = new fpdxFregment();
                    transaction.add(R.id.contentContainer, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;

        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {

        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }


    }
    @Override
    protected void setData() {
//        getData(pageNum);
    }

}
