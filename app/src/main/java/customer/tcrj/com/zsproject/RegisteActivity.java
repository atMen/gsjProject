package customer.tcrj.com.zsproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

import customer.tcrj.com.zsproject.adapter.registeFragmentPagerAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;

public class RegisteActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private registeFragmentPagerAdapter myFragmentPagerAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_registe;
    }

    @Override
    protected void setView() {

//        mViewPager.setOffscreenPageLimit(4);
        myFragmentPagerAdapter = new registeFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
        txtTitle.setText("注册");
        btnback.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;
        }
    }
}
