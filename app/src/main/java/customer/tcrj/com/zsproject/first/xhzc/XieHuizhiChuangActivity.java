package customer.tcrj.com.zsproject.first.xhzc;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.first.cyzj.FuChiZhengCeShenQinActivity;
import customer.tcrj.com.zsproject.first.cyzj.MingXingQiYeActivity;

public class XieHuizhiChuangActivity extends BaseActivity {

    @BindView(R.id.rl_01)
    LinearLayout rl01;
    @BindView(R.id.rl_02)
    LinearLayout rl02;
    @BindView(R.id.rl_03)
    LinearLayout rl03;
    @BindView(R.id.rl_04)
    LinearLayout rl04;
    @BindView(R.id.rl_05)
    LinearLayout rl05;

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    @Override
    protected int setLayout() {
        return R.layout.activity_xhzc;
    }

    @Override
    protected void setView() {
        txtTitle.setText("协会之窗");

    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.rl_01,R.id.rl_02,R.id.rl_03,R.id.rl_04,R.id.rl_05,R.id.btnback})
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.rl_01:
                toClass(this,XieHuiDongTaiActivity.class);//天使投资
                break;

            case R.id.rl_02:

                toClass(this,FuChiZhengCeShenQinActivity.class);//天使投资

                break;

            case R.id.rl_03:
                toClass(this,FuChiZhengCeShenQinActivity.class);//扶持政策申请
                break;

            case R.id.rl_04:
                toClass(this,FuChiZhengCeShenQinActivity.class);//商务秘书公司
                break;
            case R.id.rl_05:
                toClass(this,MingXingQiYeActivity.class);//数据
                break;

            case R.id.btnback:
                finish();
                break;

            default:
                break;
        }
    }



}
