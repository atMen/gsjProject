package customer.tcrj.com.zsproject.first.zscq;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.first.fgdtj.dthdActivity;
import customer.tcrj.com.zsproject.first.fgdtj.zzfcActivity;

public class zscqActivity extends BaseActivity {

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
    @BindView(R.id.rl_06)
    LinearLayout rl06;
    @BindView(R.id.rl_07)
    LinearLayout rl07;

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    @Override
    protected int setLayout() {
        return R.layout.activity_zscq;
    }

    @Override
    protected void setView() {
        txtTitle.setText("非公党团建");
    }

    @Override
    protected void setData() {

    }


    @OnClick({R.id.rl_01,R.id.rl_02,R.id.rl_03,R.id.rl_04,R.id.rl_05,R.id.rl_06,R.id.rl_07,R.id.btnback})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_01:
//                toClass(this,zzfcActivity.class);//商标注册缴费

                break;

            case R.id.rl_02:

                toClass(this,ZhiShiChanQuanActivity.class);//商标代理

                break;

            case R.id.rl_03:
//                toClass(this,dthdActivity.class);//商标质押
                break;

            case R.id.rl_04:
//                toClass(this,ZhiShiChanQuanFaLvYuanZhuActivity.class);//商标国际注册
                break;
            case R.id.rl_05:
                toClass(this,ZhiShiChanQuanFaLvYuanZhuActivity.class);//知识产权法律援助服务
                break;
            case R.id.rl_06:
//                toClass(this,sjActivity.class);//线上商标馆
                break;
            case R.id.rl_07:
//                toClass(this,sjActivity.class);//商标品牌建设政策解读
                break;

            case R.id.btnback:
                finish();
                break;

            default:
                break;
        }
    }



}
